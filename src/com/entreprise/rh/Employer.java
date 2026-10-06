package com.entreprise.rh;

import com.entreprise.compta.Payable;

public  abstract class Employer implements Payable , Comparable<Employer> {
	 protected String matricule;   
	 protected String nom;  
	 protected String agence;    
	 private static int nbEmployes = 0; 
	 
	 public Employer (String nom, String agence) {      
		 nbEmployes++;     
		 this.matricule = "E" + nbEmployes;  
		 this.nom = nom;       
		 this.agence = agence;    
		 }   
	 
	 public Employer (String nom) {     
		 this(nom, "Casablanca");    
		 }      
	 public abstract String getPoste();  
	 public abstract double getSalaire();   
	 public static int getNbEmployes() {      
		 return nbEmployes;    
		 }    
	 
	 
	 @Override   
	 public String toString() {     
		 return "matricule=" + matricule + ", nom=" + nom + ", agence=" + agence;   
		 } 
	 
	 @Override
	 public double getMontantAPayer() {
	     return getSalaire();
	 }
	 @Override
	 public int compareTo(Employer autre) {
	     return Double.compare(this.getSalaire(), autre.getSalaire());
	 }
	 
	 public boolean estMieuxPayeQue(Employer autre) {
		    return compareTo(autre) > 0;
		}
	 
}

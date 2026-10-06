package com.entreprise.compta;

public class Facture implements Payable {
	private String num;
	private String fournisseur;
	private double montant;
	
	public Facture (String num, String fournisseur,double montant ) {
		this.fournisseur=fournisseur;
		this.montant=montant;
		this.num=num;
		
	}

	@Override
	public double getMontantAPayer() {
		return montant;
	}
	 @Override
	    public String toString() {
	        return "Facture " + num + " (" + fournisseur + ") : " + montant;
	    }
	
	
	

}

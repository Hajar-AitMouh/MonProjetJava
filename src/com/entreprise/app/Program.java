package com.entreprise.app;

import com.entreprise.compta.Facture;
import com.entreprise.compta.Payable;
import com.entreprise.exception.MontantInvalideException;
import com.entreprise.rh.Augmentable;
import com.entreprise.rh.Employer;
import com.entreprise.rh.Permanent;

public class Program {

	public static void main(String[] args) {
		
		Service service = new Service();

        int tentatives = 0;

        // Ajout de Karim
        try {
            Employer karim = new Permanent("Karim", 4400);
            service.ajouter(karim);
            System.out.println("Embauche de Karim : " + karim.getSalaire());
        } catch (MontantInvalideException e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            tentatives++;
        }

        // Ajout de Salma
        try {
            Employer salma = new Permanent("Salma", 4600);
            service.ajouter(salma);
            System.out.println("Embauche de Salma : " + salma.getSalaire());
        } catch (MontantInvalideException e) {
            System.out.println("Erreur : " + e.getMessage());
        } finally {
            tentatives++;
        }

        String[] noms = {"Nadia", "Invalide", "Leila"};
        double[] salaires = {4500, -800, 3800};

        for (int i = 0; i < noms.length; i++) {

            try {
                double salaire = salaires[i];

                if (salaire == -800) {
                    Double.parseDouble("abc");
                }

                Employer employe = new Permanent(noms[i], salaire);
                service.ajouter(employe);

                System.out.println("Embauche de " + noms[i]
                        + " : " + employe.getSalaire());

            } catch (NumberFormatException e) {
                System.out.println("Saisie ignorée : \"abc\" n'est pas un montant");

            } catch (MontantInvalideException e) {
                System.out.println("Erreur : " + e.getMessage());

            } catch (RuntimeException e) {
                System.out.println("Erreur : " + e.getMessage());

            } finally {
                tentatives++;
            }
        }

        System.out.println("Tentatives : " + tentatives);
        System.out.println("Employés dans le service : " + service.getNb());
        
     // Tri des employés par salaire
        service.trier();
        service.afficher();
        
     
        Augmentable a = (Augmentable) service.getEmploye(0);
        try {
			a.augmenter(0.05);
			System.out.println("Après augmentation : " + service.getEmploye(0));
		} catch (MontantInvalideException e) {
			System.out.println("Erreur : " + e.getMessage()+ " [valeur reçue : " + e.getValeur() + "]");
		}
        
        try {
            service.getEmploye(7);
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        
     
        Payable[] elements = {
            new Facture("F-102", "Bureau Plus", 450.0),
            service.getEmploye(1)
        };

        double total = 0;

        for (Payable element : elements) {
            System.out.println("À payer : " + element);
            total += element.getMontantAPayer();
        }

        System.out.println("Total à payer : " + total);
        
        System.out.println("Nombre d'employés créés : " + Employer.getNbEmployes());

        

	}

}

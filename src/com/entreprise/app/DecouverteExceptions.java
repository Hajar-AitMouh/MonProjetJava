package com.entreprise.app;

import com.entreprise.compta.Facture;

public class DecouverteExceptions {

	public static void main(String[] args) {
		
		// ArrayIndexOutOfBoundsException
        try {
            double[] primes = new double[3];
            primes[5] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }

        // NumberFormatException
        try {
            double m = Double.parseDouble("abc");
            //  un catch general avant un catch plus precis provoque une erreur.
            /*
            } catch (Exception e) {
                System.out.println("Erreur");
            } catch (NumberFormatException e) {
                System.out.println("Format incorrect");
            }
            */
  
        } catch (NumberFormatException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }

        // NullPointerException
        try {
            Facture f = null;
            f.getMontantAPayer();
        } catch (NullPointerException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }

        // ArithmeticException
     // Avec double, la division par zero donne Infinity ,donc aucune exception n'est levee
        try {
            double partParPersonne = 9000.0 / 0;
        } catch (ArithmeticException e) {
            System.out.println(e.getClass().getSimpleName() + " : " + e.getMessage());
        }finally {
            System.out.println("Fin des essais");
        }

	}

}

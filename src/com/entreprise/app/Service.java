package com.entreprise.app;

import com.entreprise.exception.EquipeCompleteException;
import com.entreprise.rh.Employer;

public class Service {
	private Employer[] equipe;
    private int nb;

    public Service() {
        equipe = new Employer[4];
        nb = 0;
    }

    public void ajouter(Employer e) {
        if (nb >= equipe.length) {
            throw new EquipeCompleteException();
        }

        equipe[nb] = e;
        nb++;
    }

    public Employer getEmploye(int index) {
        if (index < 0 || index >= nb) {
            throw new IllegalArgumentException("indice invalide : " + index);
        }

        return equipe[index];
    }

    public int getNb() {
        return nb;
    }

    public double getMasseSalariale() {
        double total = 0;

        for (int i = 0; i < nb; i++) {
            total += equipe[i].getSalaire();
        }

        return total;
    }

    public void trier() {
        for (int i = 0; i < nb - 1; i++) {
            for (int j = i + 1; j < nb; j++) {

                if (equipe[i].compareTo(equipe[j]) > 0) {
                    Employer temp = equipe[i];
                    equipe[i] = equipe[j];
                    equipe[j] = temp;
                }
            }
        }
    }

    public void afficher() {
        for (int i = 0; i < nb; i++) {
            System.out.println(equipe[i]);
        }
    }

}

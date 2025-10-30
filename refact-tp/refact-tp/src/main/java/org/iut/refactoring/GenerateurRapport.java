package org.iut.refactoring;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class GenerateurRapport {

    public final static String SALAIRE = "SALAIRE";
    public final static String EXPERIENCE = "EXPERIENCE";
    public final static String DIVISION = "DIVISION";

    public static void generationRapport(String typeRapport, String filtre, GestionPersonnel gest) {
        System.out.println("=== RAPPORT: " + typeRapport + " ===");

        switch (typeRapport) {
            case SALAIRE -> {
                generationRapportSalaire(filtre, gest);
            }
            case EXPERIENCE -> {
                generationRapportExperience(filtre, gest);
            }
            case DIVISION -> {
                generationRapportDivision(filtre, gest);
            }
        }
        Logger.addLog(LocalDateTime.now() + " - Rapport généré: " + typeRapport);
    }

    private static void generationRapportSalaire(String filtre, GestionPersonnel gest){
        for (Employe emp : gest.getEmployes()) {
            if (filtre == null ||
                    emp.getEquipe().equals(filtre)) {
                String id = emp.getId();
                String nom = emp.getNom();
                double salaire = gest.calculSalaire(id);
                System.out.println(nom + ": " + salaire + " €");
            }
        }
    }

    private static void generationRapportExperience(String filtre, GestionPersonnel gest){
        for (Employe emp : gest.getEmployes()) {
            if (filtre == null ||
                    emp.getEquipe().equals(filtre)) {
                String nom = emp.getNom();
                int exp = emp.getExperience();
                System.out.println(nom + ": " + exp + " années");
            }
        }
    }

    private static void generationRapportDivision(String filtre, GestionPersonnel gest){
        HashMap<String, Integer> compteurDivisions = new HashMap<>();
        for (Employe emp : gest.getEmployes()) {
            String div = emp.getEquipe();
            compteurDivisions.put(div, compteurDivisions.getOrDefault(div, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : compteurDivisions.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " employés");
        }
    }

}

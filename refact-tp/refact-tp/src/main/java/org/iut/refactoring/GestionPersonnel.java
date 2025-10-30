package org.iut.refactoring;

import java.util.*;
import java.time.*;

public class GestionPersonnel {
    
    public ArrayList<Employe> employes = new ArrayList<>();
    public HashMap<String, Double> salairesEmployes = new HashMap<>();
    
    public void ajouteSalarie(String type, String nom, double salaireDeBase, int experience, String equipe) {
        Employe emp = new Employe(UUID.randomUUID().toString(), type, nom, salaireDeBase, experience, equipe);
        
        employes.add(emp);
        
        double salaireFinal = salaireDeBase;
        switch (type) {
            case Employe.DEVELOPPEUR -> {
                salaireFinal = salaireDeBase * 1.2;
                if (experience > 5) {
                    salaireFinal = salaireFinal * 1.15;
                }
            }
            case Employe.CHEF_PROJET -> {
                salaireFinal = salaireDeBase * 1.5;
                if (experience > 3) {
                    salaireFinal = salaireFinal * 1.1;
                }
            }
            case Employe.STAGIAIRE -> salaireFinal = salaireDeBase * 0.6;
        }
        
        salairesEmployes.put(emp.getId(), salaireFinal);
        
        Logger.addLog(LocalDateTime.now() + " - Ajout de l'employé: " + nom);
    }
    
    public double calculSalaire(String employeId) {
        Employe emp = null;
        for (Employe e : employes) {
            if (e.getId().equals(employeId)) {
                emp = e;
                break;
            }
        }
        if (emp == null) {
            System.out.println("ERREUR: impossible de trouver l'employé");
            return 0;
        }
        
        String type = emp.getType();
        double salaireDeBase = emp.getSalaireBase();
        int experience = emp.getExperience();
        
        double salaireFinal = salaireDeBase;
        if (type.equals(Employe.DEVELOPPEUR)) {
            salaireFinal = salaireDeBase * 1.2;
            if (experience > 5) {
                salaireFinal = salaireFinal * 1.15;
            }
            if (experience > 10) {
                salaireFinal = salaireFinal * 1.05; // bonus
            }
        } else if (type.equals(Employe.CHEF_PROJET)) {
            salaireFinal = salaireDeBase * 1.5;
            if (experience > 3) {
                salaireFinal = salaireFinal * 1.1;
            }
            salaireFinal = salaireFinal + 5000; // bonus
        } else if (type.equals(Employe.STAGIAIRE)) {
            salaireFinal = salaireDeBase * 0.6;
            // Pas de bonus pour les stagiaires
        } else {
            salaireFinal = salaireDeBase;
        }
        return salaireFinal;
    }
    
    public void avancementEmploye(String employeId, String newType) {
        for (Employe emp : employes) {
            if (emp.getId().equals(employeId)) {
                emp.setType(newType);
                
                double baseSalary = emp.getSalaireBase();
                double nouveauSalaire = calculSalaire(employeId);
                salairesEmployes.put(employeId, nouveauSalaire);
                
                Logger.addLog(LocalDateTime.now() + " - Employé promu: " + emp.getNom());
                System.out.println("Employé promu avec succès!");
                return;
            }
        }
        System.out.println("ERREUR: impossible de trouver l'employé");
    }
    
    public ArrayList<Employe> getEmployesParDivision(String division) {
        ArrayList<Employe> resultat = new ArrayList<>();
        for (Employe emp : employes) {
            if (emp.getEquipe().equals(division)) {
                resultat.add(emp); 
            }
        }
        return resultat;
    }
    
    public double calculBonusAnnuel(String employeId) {
        Employe emp = null;
        for (Employe e : employes) {
            if (e.getId().equals(employeId)) {
                emp = e;
                break;
            }
        } 
        if (emp == null) return 0;
        
        String type = emp.getType();
        int experience = emp.getExperience();
        double salaireDeBase = emp.getSalaireBase();
        
        double bonus = 0;
        switch (type) {
            case Employe.DEVELOPPEUR -> {
                bonus = salaireDeBase * 0.1;
                if (experience > 5) {
                    bonus = bonus * 1.5;
                }
            }
            case Employe.CHEF_PROJET -> {
                bonus = salaireDeBase * 0.2;
                if (experience > 3) {
                    bonus = bonus * 1.3;
                }
            }
            case Employe.STAGIAIRE -> bonus = 0; // Pas de bonus
        }
        return bonus;
    }

    public List<Employe> getEmployes(){
        return employes;
    }
}




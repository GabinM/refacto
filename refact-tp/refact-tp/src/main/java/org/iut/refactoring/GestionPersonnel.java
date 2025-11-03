package org.iut.refactoring;

import java.util.*;
import java.time.*;

public class GestionPersonnel {
    
    public ArrayList<Employe> employes = new ArrayList<>();
    public HashMap<String, Double> salairesEmployes = new HashMap<>();
    
    public void ajouteSalarie(String type, String nom, double salaireDeBase, int experience, String equipe) {
        Employe emp = new Employe(UUID.randomUUID().toString(), type, nom, salaireDeBase, experience, equipe);
        
        employes.add(emp);

        switch (type) {
            case Employe.DEVELOPPEUR -> {
                emp.setCalculSalaire(new CalculSalaireDeveloppeur(emp));
            }
            case Employe.CHEF_PROJET -> {
                emp.setCalculSalaire(new CalculSalaireChefProjet(emp));

            }
            case Employe.STAGIAIRE -> emp.setCalculSalaire(new CalculSalaireStagiaire(emp));
        }

        salairesEmployes.put(emp.getId(), emp.getCalculSalaire().calculSalaireIntermediaire());
        
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
        return emp.getCalculSalaire().calculSalaire();//salaireFinal;
    }
    
    public void avancementEmploye(String employeId, String newType) {
        for (Employe emp : employes) {
            if (emp.getId().equals(employeId)) {
                emp.setType(newType);

                double nouveauSalaire = calculSalaire(employeId);
                salairesEmployes.put(employeId, nouveauSalaire);

                switch(emp.getType()){
                    case Employe.DEVELOPPEUR ->
                        emp.setCalculSalaire(new CalculSalaireDeveloppeur(emp));
                    case Employe.CHEF_PROJET ->
                        emp.setCalculSalaire(new CalculSalaireChefProjet(emp));
                    case Employe.STAGIAIRE ->
                        emp.setCalculSalaire(new CalculSalaireStagiaire(emp));
                }

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
        return emp.getCalculSalaire().calculBonusAnnuel();
    }

    public List<Employe> getEmployes(){
        return employes;
    }
}




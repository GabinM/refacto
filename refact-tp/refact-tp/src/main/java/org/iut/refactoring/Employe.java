package org.iut.refactoring;

public class Employe{

    public static final String DEVELOPPEUR = "DEVELOPPEUR";
    public static final String CHEF_PROJET = "CHEF DE PROJET";
    public static final String STAGIAIRE = "STAGIAIRE";

    private final String id;
    private String type;
    private final String nom;
    private final double salaireBase;
    private int experience;
    private final DivisionEmploye equipe;

    public Employe(String id, String type, String nom, double salaireBase, int experience, DivisionEmploye equipe){
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.salaireBase = salaireBase;
        this.experience = experience;
        this.equipe = equipe;
    }

    public String getId(){
        return id;
    }

    public String getType(){
        return type;
    }
    public String getNom(){
        return nom;
    }
    public double getSalaireBase(){
        return salaireBase;
    }
    public int getExperience(){
        return experience;
    }
    public DivisionEmploye getEquipe(){
        return equipe;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setExperience(int experience){
        this.experience = experience;
    }
}

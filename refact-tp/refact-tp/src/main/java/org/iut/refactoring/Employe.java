package org.iut.refactoring;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Employe{
    private final String id;
    @Setter
    private String type;
    private final String nom;
    private final double salaireBase;
    @Setter
    private int experience;
    private final String equipe;

    public Employe(String id, String type, String nom, double salaireBase, int experience, String equipe){
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.salaireBase = salaireBase;
        this.experience = experience;
        this.equipe = equipe;
    }
}

package org.iut.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GestionPersonnelTest {

    @Test
    public void test00_CalculeSalaireDev(){
        GestionPersonnel app = new GestionPersonnel();
        app.ajouteSalarie("DEVELOPPEUR", "Alice", 50000, 6, "IT");
        Assertions.assertEquals( 69000.0, app.calculSalaire(app.getEmployesParDivision("IT").getFirst()[0].toString()));
    }

    @Test
    public void test01_CalculeSalaireChefProjet(){
        GestionPersonnel app = new GestionPersonnel();
        app.ajouteSalarie("CHEF DE PROJET", "Bob", 60000, 4, "RH");
        Assertions.assertEquals(104000.00000000001, app.calculSalaire(app.getEmployesParDivision("RH").getFirst()[0].toString()));
    }

    @Test
    public void test02_CalculeSalaireStagiaire(){
        GestionPersonnel app = new GestionPersonnel();
        app.ajouteSalarie("STAGIAIRE", "Charlie", 20000, 0, "IT");
        //System.out.println(app.calculSalaire(app.getEmployesParDivision("IT").getFirst()[0].toString()));
        Assertions.assertEquals(12000, app.calculSalaire(app.getEmployesParDivision("IT").getFirst()[0].toString()));
    }
}

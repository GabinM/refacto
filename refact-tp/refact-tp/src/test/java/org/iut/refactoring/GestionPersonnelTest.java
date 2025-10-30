package org.iut.refactoring;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GestionPersonnelTest {

    GestionPersonnel app;

    @BeforeEach
    public void init(){
        app = new GestionPersonnel();
    }

    @Test
    public void test00_CalculeSalaireDev(){
        app.ajouteSalarie(Employe.DEVELOPPEUR, "Alice", 50000, 1, Employe.IT);
        Assertions.assertEquals( 60000.0, app.calculSalaire(app.getEmployesParDivision(Employe.IT).getFirst().getId()));
    }

    @Test
    public void test01_CalculeSalaireDev5ansExp(){
        app.ajouteSalarie(Employe.DEVELOPPEUR, "Alice", 50000, 6, Employe.IT);
        Assertions.assertEquals( 69000.0, app.calculSalaire(app.getEmployesParDivision(Employe.IT).getFirst().getId()));
    }

    @Test
    public void test02_CalculeSalaireDev10ansExp(){
        app.ajouteSalarie(Employe.DEVELOPPEUR, "Alice", 50000, 10, Employe.IT);
        Assertions.assertEquals( 69000.0, app.calculSalaire(app.getEmployesParDivision(Employe.IT).getFirst().getId()));
    }

    @Test
    public void test03_CalculeSalaireChefProjet(){
        app.ajouteSalarie(Employe.CHEF_PROJET, "Bob", 60000, 1, Employe.RH);
        Assertions.assertEquals(95000.0, app.calculSalaire(app.getEmployesParDivision(Employe.RH).getFirst().getId()));
    }

    @Test
    public void test04_CalculeSalaireChefProjet3ansExp(){
        app.ajouteSalarie(Employe.CHEF_PROJET, "Bob", 60000, 4, Employe.RH);
        Assertions.assertEquals(104000.00000000001, app.calculSalaire(app.getEmployesParDivision(Employe.RH).getFirst().getId()));
    }

    @Test
    public void test05_CalculeSalaireStagiaire(){
        app.ajouteSalarie(Employe.STAGIAIRE, "Charlie", 20000, 0, Employe.IT);
        Assertions.assertEquals(12000, app.calculSalaire(app.getEmployesParDivision(Employe.IT).getFirst().getId()));
    }

    @Test
    public void test06_CalculeSalairePasTrouve(){
        app.ajouteSalarie(Employe.STAGIAIRE, "Charlie", 20000, 0, Employe.IT);
        boolean error = false;
        try{
            app.calculSalaire("Jean-jérémy sanchez de la mancha");
        } catch (Exception e) {
            error = true;
        }
        if(error){
            throw new RuntimeException("la méthode ne devrait pas renvoyer d'erreur");
        }
    }

    @Test
    public void test07_avancementEmployePasTrouve(){
        app.ajouteSalarie(Employe.STAGIAIRE, "Charlie", 20000, 0, Employe.IT);
        boolean error = false;
        try{
            app.avancementEmploye("Jean-jérémy sanchez de la mancha", Employe.DEVELOPPEUR);
        } catch (Exception e) {
            error = true;
        }
        if(error){
            throw new RuntimeException("la méthode ne devrait pas renvoyer d'erreur");
        }
    }
}

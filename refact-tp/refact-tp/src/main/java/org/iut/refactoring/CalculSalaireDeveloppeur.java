package org.iut.refactoring;

public class CalculSalaireDeveloppeur extends CalculSalaireAbs {

    public CalculSalaireDeveloppeur(Employe emp){
        super(emp);
    }

    @Override
    public double calculSalaire() {
        double salaireFinal = emp.getSalaireBase() * 1.2;
        int experience = emp.getExperience();
        if (experience > 5) {
            salaireFinal = salaireFinal * 1.15;
        }
        if (experience > 10) {
            salaireFinal = salaireFinal * 1.05; // bonus
        }
        return salaireFinal;
    }

    @Override
    public double calculSalaireIntermediaire() {
        double salaireFinal = emp.getSalaireBase() * 1.2;
        if (emp.getExperience() > 5) {
            salaireFinal = salaireFinal * 1.15;
        }
        return salaireFinal;
    }
}

package org.iut.refactoring;

public class CalculSalaireChefProjet extends CalculSalaireAbs {

    public CalculSalaireChefProjet(Employe emp){
        super(emp);
    }

    @Override
    double calculBonusAnnuel() {
        double bonus = emp.getSalaireBase() * 0.2;
        if (emp.getExperience() > 3) {
            bonus = bonus * 1.3;
        }
        return bonus;
    }


    @Override
    public double calculSalaire() {
        double salaireFinal = emp.getSalaireBase() * 1.5;
        if (emp.getExperience() > 3) {
            salaireFinal = salaireFinal * 1.1;
        }
        salaireFinal = salaireFinal + 5000; // bonus

        return salaireFinal;
    }

    @Override
    public double calculSalaireIntermediaire() {
        double salaireFinal = emp.getSalaireBase() * 1.5;
        if (emp.getExperience() > 3) {
            salaireFinal = salaireFinal * 1.1;
        }

        return salaireFinal;
    }
}

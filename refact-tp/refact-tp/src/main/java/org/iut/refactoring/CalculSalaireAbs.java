package org.iut.refactoring;

public abstract class CalculSalaireAbs {

    protected Employe emp;

    public CalculSalaireAbs(Employe emp) {
        this.emp = emp;
    }

    abstract double calculBonusAnnuel();

    abstract double calculSalaire();

    abstract double calculSalaireIntermediaire();

}

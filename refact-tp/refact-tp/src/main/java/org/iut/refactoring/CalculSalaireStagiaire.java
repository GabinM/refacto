package org.iut.refactoring;

public class CalculSalaireStagiaire extends CalculSalaireAbs {

    public CalculSalaireStagiaire(Employe emp) {
        super(emp);
    }

    @Override
    public double calculSalaire() {
        return emp.getSalaireBase() *0.6;
    }

    @Override
    public double calculSalaireIntermediaire() {
        return emp.getSalaireBase() *0.6;
    }
}

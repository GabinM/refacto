package org.iut.refactoring;

import java.util.UUID;

public record Salarie (String id,
                       String type,
                       String nom,
                       double salaireBase,
                       int experience,
                       String equipe){
}

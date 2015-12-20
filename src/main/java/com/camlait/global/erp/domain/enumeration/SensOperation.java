package com.camlait.global.erp.domain.enumeration;

import java.util.stream.Stream;

public enum SensOperation {
                           ENTREE(1, "E"),
                           SORTIE(2, "S"),
                           VIREMENT(3, "V");

    private final int id;

    private final String libelle;

    private SensOperation(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public static SensOperation retrouverSens(String libelle) {
        return Stream.of(values()).filter((p) -> p.getLibelle().equals(libelle)).findFirst().orElse(null);
    }

}

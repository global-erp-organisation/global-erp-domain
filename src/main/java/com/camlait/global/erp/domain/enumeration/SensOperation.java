package com.camlait.global.erp.domain.enumeration;

import java.util.stream.Stream;

public enum SensOperation {
                           ENTREE("E","Entree"),
                           SORTIE("S","Sortie"),
                           VIREMENT("V", "Virement");

    private final String id;

    private final String libelle;

    private SensOperation(String id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public String getId() {
        return id;
    }

    public String getLibelle() {
        return libelle;
    }

    public static SensOperation retrouverSens(String libelle) {
        return Stream.of(values()).filter((p) -> p.getLibelle().equals(libelle)).findFirst().orElse(null);
    }

}

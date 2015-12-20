package com.camlait.global.erp.domain.enumeration;

import java.util.stream.Stream;

public enum Portee {
                    DETAIL(1, "Détail"),
                    TOTAL(2, "Total");

    private final int porteeId;

    private final String descriptionPortee;

    public int getPorteeId() {
        return porteeId;
    }

    public String getDescriptionPortee() {
        return descriptionPortee;
    }

    private Portee(int id, String description) {
        this.porteeId = id;
        this.descriptionPortee = description;
    }

    public static Portee retrouverPortee(String description) {
        return Stream.of(values()).filter((p) -> p.getDescriptionPortee().equals(description)).findFirst()
                .orElse(DETAIL);
    }
}

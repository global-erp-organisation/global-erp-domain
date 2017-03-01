package com.camlait.global.erp.domain.enumeration;

import java.util.stream.Stream;

public enum OperationDirection {
   IN("I","In"),
   OUT("O","Out"),
   STAGING("S", "Staging"),
   UNKNOWN("U", "Unknown");

    private final String id;

    private final String label;

    private OperationDirection(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public static OperationDirection retrouverSens(String label) {
        return Stream.of(values()).filter((p) -> p.getLabel().equals(label)).findFirst().orElse(UNKNOWN);
    }

}

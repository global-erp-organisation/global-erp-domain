package com.camlait.global.erp.domain.helper;

import java.util.UUID;

import lombok.NonNull;

/**
 * Common Entity operations helper.
 * 
 * @author Martin Blaise Signe
 */
public final class EntityHelper {

    /**
     * Generate a random unique identifier if no default key is provided.
     * 
     * @param currentKey default key.
     * @return
     */
    public static String getUidFor(String currentKey) {
        return currentKey == null ? UUID.randomUUID().toString() : currentKey;
    }

    /**
     * Verify if two classes are instance of the same class.
     * 
     * @param first First object.
     * @param second Second object.
     * @return true if the two classes belong to the same class or false otherwise.
     */
    public static Boolean isTypeOf(@NonNull Class<?> first, @NonNull Class<?> second) {
        return first.isAssignableFrom(second);
    }
}

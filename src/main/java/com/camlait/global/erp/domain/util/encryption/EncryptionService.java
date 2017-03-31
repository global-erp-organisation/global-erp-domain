package com.camlait.global.erp.domain.util.encryption;

public interface EncryptionService {

    /**
     * Encrypt the provided input
     * 
     * @param input
     * @return
     */
    String encrypt(String input);

    /**
     * Verify if the plain password match with the encrypted one.
     * 
     * @param plainPassword
     * @param encryptedPassword
     * @return true if the two passwords match or false otherwise.
     */
    boolean check(String plainPassword, String encryptedPassword);
}

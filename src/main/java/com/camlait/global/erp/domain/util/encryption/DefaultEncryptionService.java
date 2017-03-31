package com.camlait.global.erp.domain.util.encryption;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DefaultEncryptionService implements EncryptionService {

    private final StrongPasswordEncryptor strongEncryptor;

    @Autowired
    public DefaultEncryptionService(StrongPasswordEncryptor strongEncryptor) {
        this.strongEncryptor = strongEncryptor;
    }

    @Override
    public String encrypt(String input) {
        return strongEncryptor.encryptPassword(input);
    }

    @Override
    public boolean check(String plainPassword, String encryptedPassword) {
        return strongEncryptor.checkPassword(plainPassword, encryptedPassword);
    }
}

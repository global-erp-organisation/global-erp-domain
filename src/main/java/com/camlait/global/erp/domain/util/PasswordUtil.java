package com.camlait.global.erp.domain.util;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;
import org.apache.commons.codec.binary.Base64;

import com.camlait.global.erp.domain.config.GlobalAppConstants;

/**
 * Source get from.
 * <a href="http://stackoverflow.com/questions/2860943/how-can-i-hash-a-password-in-java"> here </a>
 */

public final class PasswordUtil {
	// The higher the number of ITERATIONS the more
	// expensive computing the hash is for us and
	// also for an attacker.
	private static final int ITERATIONS = 20 * 1000;
	private static final int SALT_LEN = 32;
	private static final int DESIRED_KEY_LEN = 256;

	private PasswordUtil() {
		// non-op.
	}

	/**
	 * Computes a salted PBKDF2 hash of given plain text password suitable for
	 * storing in a database. Empty passwords are not supported.
	 * 
	 * 
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public static String getSaltedHash(String password) throws Exception {
		final byte[] salt = SecureRandom.getInstance(GlobalAppConstants.HASH_ALGORITHM).generateSeed(SALT_LEN);
		// store the salt with the password
		return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
	}

	/**
	 * Checks whether given plaintext password corresponds to a stored salted
	 * hash of the password.
	 * 
	 * @param password
	 *            Incoming password.
	 * @param stored
	 *            Stored password.
	 * @return true if the two passwords match and false otherwise.
	 * @throws Exception
	 */
	public static boolean check(String password, String stored) throws Exception {
		final String[] saltAndPass = stored.split("\\$");
		if (saltAndPass.length != 2) {
			throw new IllegalStateException("The stored password have the form 'salt$hash'");
		}
		final String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
		return hashOfInput.equals(saltAndPass[1]);
	}

	/**
	 * using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt cf.
	 * 
	 * @see http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
	 * @param password
	 * @param salt
	 * @return
	 * @throws Exception
	 */
	private static String hash(String password, byte[] salt) throws Exception {
		if (password == null || password.length() == 0)
			throw new IllegalArgumentException("Empty passwords are not supported.");
		final SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		final SecretKey key = f
				.generateSecret(new PBEKeySpec(password.toCharArray(), salt, ITERATIONS, DESIRED_KEY_LEN));
		return Base64.encodeBase64String(key.getEncoded());
	}
}

package de.miwoe.auth;

import java.security.SecureRandom;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomPasswordEncoder extends BCryptPasswordEncoder {

	private static final String PASSWORD_SALT = "yoursalt";
	
	
	public CustomPasswordEncoder() {
		super(10, new SecureRandom(PASSWORD_SALT.getBytes()));
	}
}

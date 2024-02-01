package DataInfoImpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
	
	
public static String hashpassword(String pass) {
	String hashedpass="";
	
	try {
        // Create MessageDigest instance for SHA-256
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        
        // Update password bytes in the message digest
        md.update(pass.getBytes());
        
        // Generate the hashed password bytes
        byte[] hashedPasswordBytes = md.digest();
        
        // Convert byte array to a hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedPasswordBytes) {
            sb.append(String.format("%02x", b));
        }
        
        hashedpass = sb.toString();
        
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }
	
	return hashedpass;
}
}

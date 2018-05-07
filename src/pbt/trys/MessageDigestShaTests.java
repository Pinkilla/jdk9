package pbt.trys;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.StringJoiner;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class MessageDigestShaTests {

    public static void main(String[] args) {
        // print algorithms
        // Security.getAlgorithms(“MessageDigest”);
        StringJoiner sj = new StringJoiner(", ", "Algorithms: ", "\n");        
        Security.getAlgorithms("MessageDigest")
                .forEach(s -> sj.add(s));
        System.out.print(sj);
        
        String message = "Beautifulmessage";
        MessageDigest md;
        try {
            //md = MessageDigest.getInstance("SHA3-256");
            md = MessageDigest.getInstance("SHA3-512");
            md.update(message.getBytes());
            byte[] bs = md.digest();
            System.out.printf("Message: %s\nDigest:",
                    message);
            for (byte b : bs) {
                System.out.printf("%02X", b);
            }
            System.out.println("");
            System.out.println("Digest:" + new BigInteger(1, bs).toString(16));
        } catch (NoSuchAlgorithmException ex) {
            System.err.println("Algorithm error: " + ex.getMessage());
        }
        
        System.out.println("" + "\u1F975");
    }
    
}

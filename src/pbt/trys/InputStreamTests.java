package pbt.trys;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class InputStreamTests {

    public static void main(String[] args) {
        try (InputStream in = Files.newInputStream(
                Paths.get("/tmp/in"), StandardOpenOption.READ)) {
            byte[] bs = in.readAllBytes();
            // do something with bs
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

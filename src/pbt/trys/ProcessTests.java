package pbt.trys;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class ProcessTests {

    public static void main(String[] args) {
        /*
        try {
            Runtime.getRuntime().exec("/usr/bin/xeyes");
            ProcessBuilder pb = new ProcessBuilder("/usr/bin/xeyes");
            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }*/

        // new jdk9q
        ProcessBuilder pb = new ProcessBuilder("/usr/bin/xeyes");
        Process p;
        try {
            p = pb.start();
            ProcessHandle ph = ProcessHandle.of(p.pid()).get();
            System.out.printf("Process info: %s\n", ph.info());
            System.out.printf("Process parent: %s \n", ph.parent());
            System.out.printf("When you press enter, I kill process %d\n",
                    ph.pid());
            (new Scanner(System.in)).nextLine();
            ph.destroyForcibly();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        
        // kill me
        ProcessHandle me = ProcessHandle.current();
        System.out.printf("My process id: %d\n", me.pid());
        System.out.printf("When you enter key, I kill myself (so sad)");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        //me.destroyForcibly();
        me.destroy();
        System.out.printf("Never here");

    }

}

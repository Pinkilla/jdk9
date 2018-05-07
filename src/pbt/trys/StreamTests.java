package pbt.trys;

import java.io.PrintWriter;
import java.util.stream.Stream;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class StreamTests {

    public static void main(String[] args) {
        
        System.out.print("\nFilter ");
        Stream.of(1,2,3,1,2,3,1,2,3)
                .filter(i -> i<3)
                .forEach(i -> System.out.printf("%d ", i));
        System.out.print("\nTake while ");
        Stream.of(1,2,3,1,2,3,1,2,3)
                .takeWhile(i -> i<3)
                .forEach(i -> System.out.printf("%d ", i));
        
        System.out.println("\nStream iterate (old way)");
        Stream.iterate(1, n -> n+1)
                .limit(9)
                .forEach(i -> System.out.printf("%d ", i));
        System.out.println("\nStream iterate (old way)");
        Stream.iterate(1, n -> n<10, n -> n+1)
                .forEach(i -> System.out.printf("%d ", i));
        
        Stream.ofNullable(null).forEach(e -> System.out.printf(" %s ", e));
        Stream.ofNullable("Plop").forEach(e -> System.out.printf(" %s ", e));
        
        int var = 0;
    }
    
    public void _a(){
        
    }
    
}

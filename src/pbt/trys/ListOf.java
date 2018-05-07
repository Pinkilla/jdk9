package pbt.trys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Pierre Bettens (pbt) <pbettens@he2b.be>
 */
public class ListOf {

    public static void main(String[] args) {
        List<Integer> l = List.of(2,3,-5);
        /*
            l.remove(0);
            l.set(0, 12);
            list.of fournit une liste immutable 
        */        
        System.out.println(l);
        
        List<Integer> l2 = new ArrayList<>(l);
        l2.remove(0);
        l2.set(0, 12);
        System.out.println(l2);
        
        Set<String> s = Set.of("Vicky", "Jenny", "Karine");
        
        Set<String> oldWay = new HashSet(
                Arrays.asList("Vicky", "Jenny", "Karine"));
        oldWay = Collections.unmodifiableSet(oldWay);
    }
    
}

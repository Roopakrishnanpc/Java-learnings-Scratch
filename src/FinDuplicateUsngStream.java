import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FinDuplicateUsngStream {


    public static void main(String[] args) {
        List<Integer> initialList = Arrays.asList(10, 28, 87, 10, 20, 76, 28, 80);
        
        // Iterate through the list and compare each element with the next one
        for (int i = 0; i < initialList.size() - 1; i++) {
            for (int j = i + 1; j < initialList.size(); j++) {
                if (initialList.get(i).equals(initialList.get(j))) {
                    System.out.println("Duplicate found: " + initialList.get(i));
                    break; // To avoid printing the same duplicate more than once
                }
            }
        }
        Set<Integer> seen=new HashSet<>();
        //set doesnot add duplicates if false then goes and add duplicates
        initialList.stream().filter(x->!seen.add(x)).collect(Collectors.toSet()).forEach(x-> System.out.println(x));
       
        Set<Integer> newd=new HashSet<>();
        Set<Integer> newduplicates = new HashSet<>();
        initialList.stream()
        .filter(number -> !newd.add(number)) // If add returns false, the element is a duplicate
        .forEach(newduplicates::add);
        
        Set<Integer> set=new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        
        for (Integer number : initialList) {
            if (!set.add(number)) {
                duplicates.add(number); // If add returns false, the element was already in the set
                //the above statement only adds duplicates
            }
           // System.out.println(set);
        }
        //System.out.println(set);
        System.out.println("Duplicates: " + duplicates);
        
       
    }
}

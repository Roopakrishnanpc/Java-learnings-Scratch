	import java.util.Arrays;
import java.util.Collections;
import java.util.List;
	import java.util.Map;
	import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
public class Countandresult {




	    public static void main(String[] args) {
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 1);
	        int targetSum = 2;
	        System.out.println("count "+Collections.frequency(numbers, 1));
	        
	        Optional<int[]> result = findPairWithSum(numbers, targetSum);

	        result.ifPresent(pair -> 
	            System.out.println("Pair found: (" + pair[0] + ", " + pair[1] + ")")
	        );
	    }

	    public static Optional<int[]> findPairWithSum(List<Integer> numbers, int targetSum) {
	        // Create a map where the key is the number and the value is the count of occurrences
	        Map<Integer, Long> numberCount = numbers.stream()
	            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	        for(Map.Entry<Integer, Long> a:numberCount.entrySet())
	        {
	        System.out.println(Collections.frequency(numbers, a.getKey()));
	        }
	        System.out.println(numberCount);
	        // Check for each number if its complement exists in the map
	        return numbers.stream()
	            .filter(num -> {
	                int complement = targetSum - num;
	                System.out.println(complement + " "+ targetSum +" "+ num);
	                //System.out.println(numberCount);
	                System.out.println(numberCount.get(complement));
	                // Check if the complement exists in the map
	                return numberCount.containsKey(complement) &&
	                    (complement != num || numberCount.get(complement) > 1);
	            })
	            .findFirst()
	            .map(num -> new int[]{num, targetSum - num});
	    }
	}



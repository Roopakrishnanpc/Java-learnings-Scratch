import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequency {
    public static void main(String[] args) {
        String input = "mumbai";
        
        // Step 1: Count frequency of each character
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Step 2: Sort the result by frequency
        List<Map.Entry<Character, Long>> sortedList = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());

        // Step 3: Print sorted frequency
        sortedList.forEach(entry -> System.out.println(entry.getKey() + "=" + entry.getValue()));

        // Step 4: Get the third element
        if (sortedList.size() >= 3) {
            Map.Entry<Character, Long> thirdElement = sortedList.get(2);
            System.out.println("Third one element : " + thirdElement.getKey() + "=" + thirdElement.getValue());
        } else {
            System.out.println("Less than 3 elements in the sorted list.");
        }
    }
}


/*Using Stream Api find the number of occurance/frenquency of each character of String and sort the result 

and get third one element
 
// input is  Mumbai

Sorted Result:

a=1

b=1

i=1

m=2

u=1

Third one element : i=1*/ 
 
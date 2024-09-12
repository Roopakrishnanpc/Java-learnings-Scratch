import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountNoOfOccturences {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String initiaWord= "Welcome to the new Company, Company offers Welcome kit to the Employee. Hope Employee like it";
		List<String> initialList=Arrays.asList(initiaWord.split("[,\\s]+"));
		//forEach(x->System.out.println(x));
		System.out.println(initialList);
		Map<String, Long> map=initialList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(map);
        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : initialList) {
            // Remove punctuation if needed (e.g., periods)
            word = word.replaceAll("[^a-zA-Z0-9]", ""); // Remove non-alphanumeric characters
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        System.out.print("[");
        // Print word counts
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
        	
        	if(entry.getValue()>=2)
        	{
            System.out.print(entry.getKey() + ": " + entry.getValue());
            System.out.println(", ");
        	}
        	
        }
        	System.out.print("]");
        
        	
        	// Count occurrences of each word using streams
            Map<String, Long> wordCountMap1 = initialList.stream()
                .map(word -> word.replaceAll("[^a-zA-Z0-9]", "")) // Remove non-alphanumeric characters
                .filter(word -> !word.isEmpty()) // Remove empty words
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
            
            // Print words with a count of 2 or more
            System.out.println(
                wordCountMap1.entrySet().stream()
                    .filter(entry -> entry.getValue() >= 2)
                    .map(entry -> entry.getKey() + ": " + entry.getValue())
                    .collect(Collectors.joining(", ", "[", "]"))
            );
	}
}

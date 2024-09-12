
	import java.util.*;
	import java.util.stream.Collectors;

	public class CollectNamesCunt {
	    public static void main(String[] args) {
	        // Step 1: Create a List of Employee Names
	        List<String> employeeNames = Arrays.asList(
	            "Roopa",
	            "Roopa Sir",
	            "Ravi Kumar",
	            "Rohan Sharma",
	            "Roopa Rani",
	            "Arun",
	            "Rani Roopa",
	            "Suresh"
	        );
	        // cant b used as split is for string[] employeeNames.stream().filter(e->e.split("\\s+")).collect(Collectors.groupingBy(word->word,Collectors.counting()));
	        
	        // Find the most frequent word and its count
	        Map.Entry<String, Long> mostFrequentWordEntry = findMostFrequentWord(employeeNames);

	        // Print the result
	        if (mostFrequentWordEntry != null) {
	            System.out.println("Most frequent word: " + mostFrequentWordEntry.getKey());
	            System.out.println("Count of \"" + mostFrequentWordEntry.getKey() + "\" in names: " + mostFrequentWordEntry.getValue());
	        } else {
	            System.out.println("No words found.");
	        }
	    }

	    private static Map.Entry<String, Long> findMostFrequentWord(List<String> names) {
	        return names.stream()
	            .flatMap(name -> Arrays.stream(name.split("\\s+"))) // Split each name into words
	            .collect(Collectors.groupingBy(word -> word, Collectors.counting())) // Count occurrences
	            .entrySet().stream()
	            .max(Map.Entry.comparingByValue()) // Find the word with the highest count
	            .orElse(null); // Return null if no words found
	    }
	}


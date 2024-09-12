
 
import java.util.*;

public class TraditionCount {
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

        // Step 2: Find the most frequent word and its count
        Map<String, Integer> wordCounts = countWordOccurrences(employeeNames);
        Map.Entry<String, Integer> mostFrequentWordEntry = findMostFrequentWord(wordCounts);

        // Print the result
        if (mostFrequentWordEntry != null) {
            System.out.println("Most frequent word: " + mostFrequentWordEntry.getKey());
            System.out.println("Count of \"" + mostFrequentWordEntry.getKey() + "\" in names: " + mostFrequentWordEntry.getValue());
        } else {
            System.out.println("No words found.");
        }
    }

    private static Map<String, Integer> countWordOccurrences(List<String> names) {
        Map<String, Integer> wordCounts = new HashMap<>();
        Set<String> allWords = new HashSet<>();

        // Collect all unique words from the names
        for (String name : names) {
            String[] words = name.split("\\s+");
            for (String word : words) {
                allWords.add(word);
            }
        }

        // Count occurrences of each word in the list of names
        for (String word : allWords) {
            int count = 0;
            for (String name : names) {
                if (name.contains(word)) {
                    count++;
                }
            }
            wordCounts.put(word, count);
        }

        return wordCounts;
    }

    private static Map.Entry<String, Integer> findMostFrequentWord(Map<String, Integer> wordCounts) {
        Map.Entry<String, Integer> mostFrequent = null;

        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (mostFrequent == null || entry.getValue() > mostFrequent.getValue()) {
                mostFrequent = entry;
            }
        }

        return mostFrequent;
    }
}

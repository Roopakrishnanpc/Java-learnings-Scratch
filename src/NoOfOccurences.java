import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NoOfOccurences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // Count occurrences of each character using streams
        String text = "This is a test string. Test the string.";
        Map<Character, Long> charCountMap = text.chars()  // Convert string to IntStream
            .mapToObj(c -> (char) c)  // Convert IntStream to Stream<Character>
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
System.out.println(charCountMap);
long totalCharacterOccurrences = charCountMap.values().stream()
.mapToLong(Long::longValue)
.sum();
System.out.println("Total number of character occurrences: " + totalCharacterOccurrences);
        // Print the character counts
        charCountMap.forEach((character, count) -> {
            System.out.println(character + ": " + count);
        });
        
        String substring = "test";

        // Convert both the text and substring to lower case for a case-insensitive search
        text = text.toLowerCase();
        substring = substring.toLowerCase();

        // Use regex to split the text by the substring and count occurrences
//        long count = Pattern.compile(Pattern.quote(substring))
//            .matcher(text);
        Pattern pattern = Pattern.compile(Pattern.quote(substring));
        Matcher matcher = pattern.matcher(text);

        // Count occurrences of the substring
        int count = 0;
        while (matcher.find()) {
            count++;
        }

        // Print the number of occurrences
        System.out.println("The substring \"" + substring + "\" occurs " + count + " times.");
        List<String> strings = Arrays.asList("a", "bb", "ccc");
        List<Integer> lengths = strings.stream()
            .map(String::length)  // Reference to the instance method `length` of `String`
            .collect(Collectors.toList());
        System.out.println(lengths);

	}

}

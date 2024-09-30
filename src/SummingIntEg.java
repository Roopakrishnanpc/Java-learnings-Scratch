import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.lang.Object;

public class SummingIntEg extends Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
List<String> words = Arrays.asList("apple","banana", "banana", "apple", "avocado", "blueberry", "cherry", "date");
Map<String, Integer> wordLength = words.stream()
.collect(Collectors.groupingBy(
    Function.identity(),
    Collectors.summingInt(String::length)
));
Optional<Map.Entry<String, Integer>> maxEntryword = wordLength.entrySet().stream()
.max(Comparator.comparingInt(entry -> entry.getValue()));

// Print the result
maxEntryword.ifPresent(entry -> System.out.println("Entry with maximum length sum: " + entry));

Map<String,Integer> store=new HashMap<String,Integer>();
System.out.println(wordLength);//this is used to count the occurences eg: apple =5
for(Map.Entry<String, Integer> a:wordLength.entrySet()) {
	//System.out.println(a.getValue());
	System.out.println(" this is how it woks using frquency "+a.getKey()+" "+Collections.frequency(words, a.getKey()));
	store.put(a.getKey(),Collections.frequency(words, a.getKey()));
	}
//this will print based on frequency where no apple is there twice
store.entrySet().stream().filter(entry -> entry.getValue()>1).forEach(System.out::println);
//get word and highest word
Map<String, Integer> wordLengthSum = words.stream()
.collect(Collectors.groupingBy(
    word -> word,
    Collectors.summingInt(String::length)
));
System.out.println(wordLengthSum);
//System.out.println(wordLengthSum.entrySet().stream().filter(entry -> entry.getValue()>1).findFirst());
wordLengthSum.entrySet().stream().filter(entry -> entry.getValue()>1).forEach(System.out::println);
Optional<Entry<String, Integer>> len=wordLengthSum.entrySet().stream().max(Comparator.comparingDouble(entry -> entry.getValue()));
len.ifPresent(entry -> System.out.println("Entry with maximum length sum: " + entry));
wordLengthSum.forEach((letter, totalLength) -> 
System.out.println("Total length of words starting with " + letter + ": " + totalLength)
);

Map<String, IntSummaryStatistics> letterLengthSum =words.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.summarizingInt(String::length)));
	System.out.println(letterLengthSum);
	Optional<Entry<String, IntSummaryStatistics>> wordsLengthSum=letterLengthSum.entrySet().stream().max(Comparator.comparingDouble(entry -> entry.getValue().getSum()));
	if(wordsLengthSum.isPresent())
	{
		Map.Entry<String, IntSummaryStatistics> getwords=wordsLengthSum.get();
		String word=getwords.getKey();
		double data=getwords.getValue().getSum();
		System.out.println("Words: " +word+" and the data value is: "+data);
	}
	letterLengthSum.forEach((letter, stats) -> {
    	int totalLength=(int) stats.getSum();
    	System.out.println("Total length of words starting with " + letter + ": " + totalLength);
    });
	System.out.println();
    Map<Character, DoubleSummaryStatistics> letterLengthSummary = words.stream()
            .collect(Collectors.groupingBy(
                word -> word.charAt(0),
                Collectors.summarizingDouble(String::length)
            ));
    
    letterLengthSummary.forEach((letter, stats) -> {
    	double totalLength=stats.getSum();
    	System.out.println("Total length of words starting with " + letter + ": " + totalLength);
    });
    
    Optional<Map.Entry<Character, DoubleSummaryStatistics>> maxEntry =letterLengthSummary.entrySet().stream().max(Comparator.comparingDouble(entry -> entry.getValue().getSum()));
    System.out.println(maxEntry);
    
    if (maxEntry.isPresent()) {
        Map.Entry<Character, DoubleSummaryStatistics> entry = maxEntry.get();
        char maxChar = entry.getKey();
        double maxLength = entry.getValue().getSum();
        System.out.println("The character with the highest total length is '" + maxChar + "' with a total length of " + maxLength);
    } else {
        System.out.println("No words found.");
    }
    
    Map<String, Integer> wordLengthUsingDisntict = words.stream().distinct()//with this appple will be counted as 5
    		.collect(Collectors.groupingBy(
    		    Function.identity(),
    		    Collectors.summingInt(String::length)
    		));
    
    Map<Object, Long> letterLengthCounting = words.stream()
            .collect(Collectors.groupingBy(
                word -> word,
                Collectors.counting()
            ));
    
    System.out.println(letterLengthCounting);
	}
	

}

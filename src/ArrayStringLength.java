import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayStringLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String[] strings= {"Roopa", "SAM","Krishnan","Kittu","Chithra","Ashwin"};
StringArraylength(strings);
	}

	private static void StringArraylength(String[] strings) {
		// TODO Auto-generated method stub
		//Map<String, Long>
		Integer mapdata=Arrays.stream(strings).mapToInt(String::length).max().orElse(0);
		//Arrays.stream(strings).anyMatch(e-> e.indexOf(0)=="Roopa");
		//Arrays.stream(strings).anyMatch(e-> e.indexOf("Roopa"));
		Arrays.stream(strings).anyMatch(e-> e.equals("Roopa"));
		//Integer mapdata=Arrays.stream(strings).mapToInt(String::length).max().orElse(0);
        int index = Arrays.stream(strings)
                .collect(Collectors.toList()) // Convert to List to use indexOf
                .indexOf("Roopa");
        System.out.println("Index of Roopa: "+index);
        String target="Roopa";
        int indexAlternative =IntStream.range(0,strings.length).filter(i->strings[i].equals("Roopa")).findFirst().orElse(0);
if (indexAlternative >= 0) {
  System.out.println("String \"" + target + "\" found at index: " + indexAlternative);
} else {

System.out.println("String \"" + target + "\" not found in the array.");
}
		System.out.println(Arrays.stream(strings).anyMatch(e-> e=="Roopa"));
		System.out.println(mapdata);
	      List<String> maxLengthStrings = Arrays.stream(strings)
                  .filter(s -> s.length() == mapdata)
                  .collect(Collectors.toList());
	      System.out.println(maxLengthStrings);
	        Map<Integer, List<String>> datamap1 = Arrays.stream(strings)
	                .filter(s -> s.length() == mapdata)
	                .collect(Collectors.groupingBy(String::length));

	            // Output the results
	            datamap1.forEach((length, strList) -> 
	                strList.forEach(str -> System.out.println(str + " has length " + length)));
				Integer data=Arrays.stream(strings).mapToInt(x->x.length()).max().orElse(0);
				
				Map<Integer, List<String>> datamap=Arrays.stream(strings).sorted().collect(Collectors.groupingBy(e->e.length()));//.forEach(System.out::print);
				
				System.out.println(datamap);
				System.out.println(datamap.keySet().stream().max(Integer::compareTo).orElse(0));
				Integer maxiLength=datamap.keySet().stream().max(Integer::compareTo).orElse(0);
		        List<String> longestStrings = datamap.get(maxiLength);		
				System.out.println(maxiLength);
				 longestStrings.forEach(str -> System.out.println(str + " has length " + str.length()));
		System.out.println(mapdata);
		int a=strings.length;
		//System.out.println(a);
		Map<String, Long> map=new LinkedHashMap<>();
		Map<String, Long> longestmap=null;
		for(int i=0;i<a;i++)
		{
			String value=String.valueOf(strings[i]);
			map.put(value,(long) value.length());
			//System.out.println(value);
		}
		for(Entry<String, Long> abc:map.entrySet())
		{
		System.out.print(abc.getKey());
		System.out.print(" Has count ");
		System.out.println(abc.getValue());
		}
        Long maxLength = (long) -1;
        for (Long len : map.values()) {
            if (len > maxLength) {
                maxLength = len;
            }
            System.out.println(maxLength);
        }

        // Collect all strings with the maximum length
        System.out.println("Longest string(s):");
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            if (entry.getValue() == maxLength) {
                System.out.println(entry.getKey() + " has count " + maxLength);
            }
        }
	}

}

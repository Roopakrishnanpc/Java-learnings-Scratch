import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Stream {
public static void main(String[] args) {
	List<Integer> a=Arrays.asList(1,2,3,4,5,6,8,10);
	//	Map<Boolean,List<Integer>> map=a.stream().collect(Collectors.partitioningBy(e -> e.getSount()>0));
	Map<Boolean,List<Integer>> map=a.stream().collect(Collectors.partitioningBy(e -> e%2==0));
	System.out.println(map);
	a.stream().filter(e -> e<1000).map(e->e).collect(Collectors.toList()).forEach(System.out::println);
	System.out.println(a.stream().collect(Collectors.counting()));
	System.out.println(a.stream().collect(Collectors.summarizingInt(Integer::intValue)));
	
	List<String> string=Arrays.asList("roops", "ashwin","sam","appa","amma");
	List<Integer> count=string.stream().collect(Collectors.mapping(String::length, Collectors.toList()));
	System.out.println(count);
	System.out.println(string.stream().collect(Collectors.joining(", ","[","]")));
	//beloe Order::getCustomers also can do
	Map<Integer,Long> r=string.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
	System.out.println(r);
	int size=string.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Set::size));
	System.out.println(size);
	//nt size=string.stream().collect(Collectors.collectingAndThen(Collectors.toSet(), set -> set.stream()
	//map(Customer::getmail().collect(Collectors.toList());
	//List<Integer> filter =a.stream().collect(Collectors.filtering(i -> i%2==0,Collectors.toList()));
	//, Collectors.toList()));
	//.forEach(System.out::println);
	System.out.println(string.stream().collect(Collectors.mapping(String::length,Collectors.summingInt(Integer::intValue))));
	Map<String,Integer> cons=string.stream().collect(Collectors.toMap(Function.identity(), String::length));
	//thread safe -> ConcurrentMap
	ConcurrentMap<String,Integer> con=string.stream().collect(Collectors.toConcurrentMap(Function.identity(), String::length));
	int sum=a.stream().collect(Collectors.reducing(0, Integer::sum));
	//a.stream().map(Order::getAmount).collect(Collectors.reducing(0, Integer::sum));
	System.out.println(sum);
	
	List<List<Integer>> list=Arrays.asList(Arrays.asList(1,2,3),
			Arrays.asList(2,4,5),
			Arrays.asList(3,4,5));
	//List<Integer> flatteredMap=list.stream().collect(Collectors.flatMapping(List::stream, Collectors.joining(",","[","]")).collect(Collectors.toList()));
    List<Integer> flattenedList = list.stream()
            .flatMap(List::stream)  // Flatten the stream of lists into a stream of integers
            .collect(Collectors.toList());  // Collect the integers into a list

System.out.println(flattenedList);  // Output: [1, 2, 3, 2, 4, 5, 3, 4, 5]

//Map<String, List<Integer>> map2 = Map.of(
//        "A", Arrays.asList(1, 2, 3),
//        "B", Arrays.asList(4, 5),
//        "C", Arrays.asList(6, 7, 8)
//    );
Map<String, List<Integer>> map2 = new HashMap<>();
map2.put("A", Arrays.asList(1, 2, 3));
map2.put("B", Arrays.asList(4, 5));
map2.put("C", Arrays.asList(6, 7, 8));

    List<Integer> flattenedList1 = map.values().stream()
        .flatMap(List::stream)  // Flatten the list of lists
        .collect(Collectors.toList());

    System.out.println(flattenedList1);  // Output: [1, 2, 3, 4, 5, 6, 7, 8]

}
}

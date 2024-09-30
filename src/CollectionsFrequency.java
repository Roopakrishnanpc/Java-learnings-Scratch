import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsFrequency {
public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("apple");
    list.add("banana");
    list.add("apple");
    list.add("banana");
    list.add("orange");
    list.add("apple");
    System.out.println(Collections.frequency(list, "apple"));
    Map<String, Long> a=list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    System.out.println(a.entrySet().stream().filter(a1-> a1.getValue()>1).findAny());
    System.out.println(a.entrySet().stream().filter(a1-> a1.getValue()>1));
    System.out.println(a.entrySet().stream().filter(a1-> a1.getValue()>1).findFirst());
    List<Entry<String, Long>> vaue=a.entrySet().stream().filter(a1-> a1.getValue()>1).collect(Collectors.toList());
    System.out.println(vaue);
    System.out.println(a);
}
}

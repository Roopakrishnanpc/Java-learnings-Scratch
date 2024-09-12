import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingBYStream {
public static void main(String[] args) {
    List<Coworker> coworkers = new ArrayList<>(); 
    //new Coworker(1, "Alice Johnson", 55000.00);
    coworkers.add(new Coworker(1, "Roopa Sri", 55000.00));
    coworkers.add(new Coworker(2, "Bob Smith", 62000.00));
    coworkers.add(new Coworker(3, "Carol Davis", 48000.00));
    coworkers.add(new Coworker(4, "David Wilson", 72000.00));
    coworkers.add(new Coworker(5, "Roopa Sri", 55000.00));
    coworkers.add(new Coworker(6, "Roopa Sri", 64000.00));
    coworkers.add(new Coworker(7, "Roopa Sri", 55000.00));
    coworkers.add(new Coworker(8, "Roopa", 67000.00));
    coworkers.add(new Coworker(9, "Roopa Sri", 55000.00));
    coworkers.add(new Coworker(10, "Roopa Sri", 71000.00));
    System.out.println(coworkers.stream().collect(Collectors.groupingBy(e->e.getName())));
    System.out.println(coworkers.stream().collect(Collectors.groupingBy(e->e.getSalary())));
    System.out.println(coworkers.stream().collect(Collectors.groupingBy(e->e.getSalary(), Collectors.toSet())));
    System.out.println(coworkers.stream().collect(Collectors.groupingBy(e->e.getSalary(),TreeMap::new, Collectors.toSet())));
    Map<Double, Set<Coworker>> groupedBySalaryDesc = coworkers.stream()
            .collect(Collectors.groupingBy(
                Coworker::getSalary,                // Group by salary
                () -> new TreeMap<>(Comparator.reverseOrder()), // TreeMap with descending order
                Collectors.toSet()                  // Collect into a Set
            ));
    System.out.println(groupedBySalaryDesc);
}
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Coworker {
    // Fields
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Coworker(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // toString method
    @Override
    public String toString() {
        return "Coworker{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", salary=" + salary +
               '}';
    }
}

public class ScenarioJava8Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<Coworker> coworkers = new ArrayList<>(); 
                //new Coworker(1, "Alice Johnson", 55000.00);
                coworkers.add(new Coworker(1, "Alice Johnson", 55000.00));
                coworkers.add(new Coworker(2, "Bob Smith", 62000.00));
                coworkers.add(new Coworker(3, "Carol Davis", 48000.00));
                coworkers.add(new Coworker(4, "David Wilson", 72000.00));
                coworkers.add(new Coworker(5, "Eve Brown", 59000.00));
                coworkers.add(new Coworker(6, "Frank Lee", 64000.00));
                coworkers.add(new Coworker(7, "Grace Kim", 53000.00));
                coworkers.add(new Coworker(8, "Roopa", 67000.00));
                coworkers.add(new Coworker(9, "Roopa Sri", 55000.00));
                coworkers.add(new Coworker(10, "Judy Martinez", 71000.00));
                String searchSubstring="Roopa";
                List<String> listNames=coworkers.stream().map(e->e.getName()).collect(Collectors.toList());
                long count=listNames.stream()
                .filter(name -> name.contains(searchSubstring)) // Filter names containing the substring
                .count();
                System.out.println("Number of employees with \"" + searchSubstring + "\" in their name: " + count);
                List<String> listName=coworkers.stream().map(e->e.getName()).collect(Collectors.toList());
                String names=listName.stream().map(x->x.toUpperCase()).collect(Collectors.joining(", "));
                System.out.print(names);
                List<Double> listsalsort=coworkers.stream().map(e->e.getSalary()).sorted().collect(Collectors.toList());
                System.out.println("Find second and 3rd youngest");
                listsalsort.stream().skip(1).limit(2).forEach(System.out::println);
                System.out.println("Summarystatistics");
                List<Double> listsal=coworkers.stream().map(e->e.getSalary()).collect(Collectors.toList());
                System.out.println(listsal.stream().mapToDouble(x->x).summaryStatistics().getMax());
                System.out.println(listsal.stream().mapToDouble(x->x).summaryStatistics().getMin());
                System.out.println(listsal.stream().mapToDouble(x->x).summaryStatistics().getSum());
                System.out.println(listsal.stream().mapToDouble(x->x).summaryStatistics().getAverage());
                List<Coworker> sortedAscening=coworkers.stream().sorted((o1,o2)->(int)(o1.getSalary()-o2.getSalary())).collect(Collectors.toList());
                System.out.println(sortedAscening);
                sortedAscening.stream().min(Comparator.comparingDouble(Coworker::getSalary)).ifPresent(c -> System.out.println("Minimum Salary Coworker: " + c));
                List<Coworker> sortedDescening=coworkers.stream().sorted((o1,o2)->(int)(o2.getSalary()-o1.getSalary())).collect(Collectors.toList());
                System.out.println(sortedDescening);
                //sortedDescening.stream().filter(e->e.getSalary>(3)
                List<Coworker> sortedDesceningAndLimut=coworkers.stream().sorted((o1,o2)->(int)(o2.getSalary()-o1.getSalary())).limit(3).collect(Collectors.toList());
                System.out.println(sortedDesceningAndLimut);
                List<Coworker> sortedDesceningAndHighest=coworkers.stream().sorted((o1,o2)->(int)(o2.getSalary()-o1.getSalary())).skip(3).collect(Collectors.toList());
                System.out.println(sortedDesceningAndHighest);
                List<Coworker> sortedDescending = coworkers.stream()
                        .sorted((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()))
                        .collect(Collectors.toList());
                    
                    // Print the sorted list
                    sortedDescending.forEach(System.out::println);
                    
                    // Sort the list in descending order based on salary
                    List<Coworker> sortedDescending1 = coworkers.stream()
                        .sorted(Comparator.comparingDouble(Coworker::getSalary).reversed())
                        .collect(Collectors.toList());
                    
                    // Print the sorted list
                    System.out.println("Sorted Descending:");
                    sortedDescending1.forEach(System.out::println);
                    
                    // Reverse the sorted list to get the original order
                    List<Coworker> reversedList = sortedDescending1.stream()
                        .collect(Collectors.collectingAndThen(
                            Collectors.toList(), 
                            list -> {
                                Collections.reverse(list);
                                return list;
                            }
                        ));
                    System.out.println("\nReversed List:");
                    List<Coworker> reversedListAn = coworkers.stream()
                            .collect(Collectors.collectingAndThen(
                                Collectors.toList(), 
                                list -> {
                                    Collections.reverse(list);
                                    return list;
                                }
                            ));
                        
                        // Print the reversed list
                    System.out.println("\nOrginal List:");
                        reversedListAn.forEach(System.out::println);
                        List<Coworker> rorginalListAn= reversedListAn.stream().collect(Collectors.collectingAndThen(Collectors.toList(), list-> {Collections.reverse(list); return list;}));
                        System.out.println("\nOrg List:"+rorginalListAn);
	
                        String mostFrequentSubstring = findMostFrequentSubstring(listNames);

                        // Print the result
                        System.out.println("Most frequent substring: " + mostFrequentSubstring);
                        System.out.println("Count of \"" + mostFrequentSubstring + "\" in names: " +
                                           countOccurrences(listNames, mostFrequentSubstring));	}
    private static String findMostFrequentSubstring(List<String> names) {
        // Flatten all substrings from all names into a single stream
        return names.stream()
            .flatMap(name -> getAllSubstrings(name).stream())
            .collect(Collectors.groupingBy(substring -> substring, Collectors.counting())) // Count occurrences
            .entrySet().stream()
            .max(Map.Entry.comparingByValue()) // Find the entry with the highest count
            .map(Map.Entry::getKey) // Get the substring
            .orElse(""); // Default to empty string if no substrings found
    }

    private static List<String> getAllSubstrings(String name) {
        List<String> substrings = new ArrayList<>();
        for (int start = 0; start < name.length(); start++) {
            for (int end = start + 1; end <= name.length(); end++) {
                substrings.add(name.substring(start, end));
            }
        }
        return substrings;
    }

    private static long countOccurrences(List<String> names, String searchSubstring) {
        return names.stream()
            .filter(name -> name.toLowerCase().contains(searchSubstring.toLowerCase()))
            .count();
    }
}

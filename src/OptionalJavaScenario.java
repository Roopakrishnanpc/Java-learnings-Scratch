import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalJavaScenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    List<Coworker> coworkers = new ArrayList<>(); 
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
	    coworkers.add(new Coworker(11, null,0.00));
	    
	       Optional<Coworker> optionalCoworker = Optional.of(new Coworker(11, null, 0.00));

	        // Extract the name from the Coworker, throwing an exception if the name is null
	        try {
	        	Optional<String> nameOp=Optional.ofNullable(optionalCoworker.get().getName());
	        	System.out.println(nameOp.get());
	        	String nameOporelse=Optional.ofNullable(optionalCoworker.get().getName()).orElse("Anonymoys");
	        	String nameOporelseGet=Optional.ofNullable(optionalCoworker.get().getName()).orElseGet(()->"Anonymoys");
	        	String nameOporelseMethod=Optional.ofNullable(optionalCoworker.get().getName()).orElse(call());
	        	String nameOporelseGetMethod=Optional.ofNullable(optionalCoworker.get().getName()).orElseGet(()->call());
	            String name = Optional.ofNullable(optionalCoworker.get().getName())
	                .orElseThrow(() -> new IllegalArgumentException("Name is null"));
	            System.out.println("Name: " + name);
	        } catch (RuntimeException e) {
	            System.err.println(e.getMessage());
	        }
	    //System.out.println( coworkers.stream().filter(e->e.getId()==11).map(e->e).collect(Collectors.toList()));
	    
	   // Optional<List<Coworker>> optionalCoworkers=Optional.ofNullable(coworkers).orElse("Anonymous");
        Optional<List<Coworker>> optionalCoworkers = Optional.ofNullable(coworkers);

        // Use orElse to provide a default value if the list is null
        List<Coworker> nonNullCoworkers = optionalCoworkers.orElse(new ArrayList<>());
       // List<Coworker> nonNullCoworkersAnon = coworkers.get().getName().orElse("Anonymous");
        // List<Coworker> nonNullCoworkersAnon = coworkers.get().getName().orElseGet(() ->"Anonymous");
        // Print the list of coworkers
        System.out.println("Coworkers List:");
        nonNullCoworkers.forEach(System.out::println);

        // Find and print the coworker with id 11, or print a default message if not found
        Coworker coworkerWithId11 = nonNullCoworkers.stream()
            .filter(e -> e.getId() == 11)
            .findFirst()
            .orElse(new Coworker(-1, "Not Found", 0.00)); // Provide a default Coworker if not found
        Coworker coworkerWithId12 = nonNullCoworkers.stream()
                .filter(e -> e.getId() == 11)
                .findFirst()
                .orElse(new Coworker(-1, "Not Found", 0.00));
        System.out.println("Coworker with ID 11:");
        System.out.println(coworkerWithId11);
	    
        if(optionalCoworkers.isPresent()&&!optionalCoworkers.get().isEmpty())
        {
        	optionalCoworkers.orElse(new ArrayList<>());
        	Map<String, Long> namedasti=coworkers.stream().map(e->e.getName()).filter(Objects::nonNull).collect(Collectors.groupingBy(e->e,Collectors.counting()));
        	Optional<Map.Entry<String, Long>> counting=namedasti.entrySet().stream().max(Map.Entry.comparingByValue());
        	
        	if(counting.isPresent())
        	{
        		counting.get().getKey();
        		counting.get().getValue();
        		
        	}
        }
        if (optionalCoworkers.isPresent() && !optionalCoworkers.get().isEmpty()) {//.get().isEmpty()) {
            // List is not empty, perform operations
            System.out.println("List is not empty");
            
            // Find the most frequent name using a Map
            Map<String, Long> nameCounts = coworkers.stream()
                .map(Coworker::getName).filter(Objects::nonNull) // Extract names
                .collect(Collectors.groupingBy(name -> name, Collectors.counting())); // Count occurrences

            // Find the most frequent name and its count
            Optional<Map.Entry<String, Long>> mostFrequentName = nameCounts.entrySet().stream()
                .max(Map.Entry.comparingByValue()); // Find the entry with the highest count

            if (mostFrequentName.isPresent()) {
                System.out.println("Most frequent name: " + mostFrequentName.get().getKey());
                System.out.println("Count of \"" + mostFrequentName.get().getKey() + "\" in names: " + mostFrequentName.get().getValue());
            } else {
                System.out.println("No names found.");
            }
        } else {
            System.out.println("List is empty");
        }
//    
	}

	private static String call() {
		// TODO Auto-generated method stub
		System.out.println("This methd is called");
		return "Anonymous";
	}

}

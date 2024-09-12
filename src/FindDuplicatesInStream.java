import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + "]";
    }

	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
public class FindDuplicatesInStream {
public static void main(String[] args) {
    List<Employee> emp = new ArrayList<>();
    emp.add(new Employee(1, "Roopa"));
    emp.add(new Employee(2, "Sam"));
    emp.add(new Employee(3, "Roopa"));
    emp.add(new Employee(4, "Roopa Sam"));
    emp.add(new Employee(5, "Roopa"));
    emp.add(new Employee(6, "Krishnan"));
    emp.add(new Employee(7, "Krishnan"));
    emp.add(new Employee(8, "Krishnan"));
    Set<String> set=new HashSet<>();
    

    Map<Employee,Long> mapcount1=emp.stream().collect(Collectors.groupingBy(Function.identity(),(Collectors.counting())));
    System.out.println(mapcount1);
    List<String> list=emp.stream().map(e->e.getName()).collect(Collectors.toList());
    System.out.println("Using Colection.frequency "+list.stream().filter(name-> Collections.frequency(list, name)>1).collect(Collectors.toSet()));
    Map<String,Long> mapcount=list.stream().collect(Collectors.groupingBy(Function.identity(),(Collectors.counting())));
    System.out.println("Using Colection.groupby "+mapcount);
    System.out.println("Using Colection.groupby to get key and value >2"+mapcount.entrySet().stream().filter(entry ->entry.getValue()>1).collect(Collectors.toSet()));
    //filter -> gives you key and value which is greater than two. and also print the same but when you use map and you can just get th ekey and print
    Set<String> setName=mapcount.entrySet().stream().filter(entry ->entry.getValue()>1).map(entry ->entry.getKey()).collect(Collectors.toSet());
    System.out.println("Using Colection.groupby to get only key  >2 using map"+setName);
    //!set.add(e) -> will become true besically if roopa is present twiice then it will return false which is true so it will not add again so while tru it will collect that to set
    list.stream().filter(e-> !set.add(e)).peek(System.out::println).collect(Collectors.toSet()).forEach(x-> System.out.println("Duplicate names"+x));
   //unique list.stream().filter(e-> set.add(e)).peek(System.out::println).collect(Collectors.toSet()).forEach(x-> System.out.print(x));
    System.out.println("Unique Names only just directly print the orginal set"+set);
}
}

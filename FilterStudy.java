import java.util.List;
import java.util.stream.Collectors;
import java.util.SortedSet;
import java.util.TreeSet;
import static java.util.Arrays.asList;

/**
 * Used to filter values in some
 * collection
 */
public class FilterStudy{
    private List<String> names;
    private List<Person> persons;
    
    public FilterStudy(){
        names = asList("Bertha", "Rick", "Morthin", "Adamastor", "It", "Dany", "", "");
        persons = asList(new Person("Damian", 7), new Person("Harry", 17), new Person("Adamastor Castilha", 57));    
        System.out.println(filterName());
        System.out.println(isEmpty()); 
        System.out.println(isOfAge());
        System.out.println(isUnderageSorted());
    }
    
    /**
     * Filtered names starting with A  
     * @return the filterd string
     */
    public List<String> filterName(){
        return names.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
    }

    /**
     * Filtered Empty 
     * @return the non empty values
     */
    public List<String> isEmpty(){
        return names.stream().filter(s->!s.isBlank()).collect(Collectors.toList());
    }

    /**
     * Filtered of age persons
     * @return the of age persons
     */
    public List<Person> isOfAge(){
        return persons.stream().filter(Person::isOfAge).collect(Collectors.toList());
    }

    /**
     * Filtered underage persons
     * @return the underage persons sorted set
     */
    public SortedSet<Person> isUnderageSorted(){
        return persons.stream().filter(Person::isUnderageSorted).collect(Collectors.toCollection(TreeSet::new));
    }

}

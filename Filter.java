import java.util.List;
import java.util.stream.Collectors;
import java.util.SortedSet;
import java.util.TreeSet;
import static java.util.Arrays.asList;

/**
 * Used to filter values in some
 * collection
 */
public class Filter{
    private List<String> names;
    private List<Person> persons;
    
    public Filter(){
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


class Person implements Comparable<Person>{
    String name;
    Integer age;

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public static boolean isOfAge(Person p){
        return p.age >= 18;
    }

    public static boolean isUnderageSorted(Person p){
        return !isOfAge(p);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        return true;
    }

    @Override
    public int compareTo(Person o) {
        return age.compareTo(o.age);
    }

    @Override
    public String toString(){
        return "Name: " + this.name + " Age:" + this.age;
    }
}


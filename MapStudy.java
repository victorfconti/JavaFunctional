import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.Map;

public class MapStudy {

    public MapStudy(){
        System.out.println(convertStringToNumber(Arrays.asList("45","12","25")));
        System.out.println(convertStringToSortedNumber(Arrays.asList("45","12","25")));
        List<Map<String, String>> inputs = Arrays.asList(getPostInput("Adamastor Castilha", "95"), getPostInput("Antilhas Tilhas", "65"));
        System.out.println(inputsToPerson(inputs));
    }

    /**
     * Return a map with the name and the age
     * @param name the name of the person
     * @param age the age of the person
     * @return a map with the name and the age of a person
     */
    private Map<String, String> getPostInput(String name, String age){
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        return map;
    }

    /**
     *  Convert a list of String to a list of number
     * @param numbers A list of numbers in String
     * @return A list of Integers
     */
    public List<Integer> convertStringToNumber(List<String> numbers){
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toList()); 
    }

    /**
     * Convert String list to a number set
     * @param numbers a list of string numbers
     * @return a sorted set with converted numbers
     */
    public SortedSet<Integer> convertStringToSortedNumber(List<String> numbers){
        return numbers.stream().map(Integer::parseInt).collect(Collectors.toCollection(TreeSet::new)); 
    }

    /**
     * Convert a list of map to a List of person
     * @param inputs List of map having the data of person
     * @return a list of person
     */
    public List<Person> inputsToPerson(List<Map<String, String>> inputs){
        return inputs.stream().map(m-> new Person(m.get("name"), Integer.parseInt(m.get("age")))).collect(Collectors.toList());
    }

}
import java.util.Arrays;
import java.util.List;

public class ReduceStudy{


    public ReduceStudy(){
        List<Person> family = Arrays.asList(new Person("Adamastor", 45), new Person("Alamentes", 18));
        System.out.println(sumNumbers(Arrays.asList(1,45,26)));
        System.out.println(family);
    }

    /**
     * Sum all the numbers
     * @param numbers a list with numbers
     * @return the sum of the all numbers inside the list
     */
    public Integer sumNumbers(List<Integer> numbers){
        return numbers.stream().reduce(0, Integer::sum);
    }


    /**
     * Calculate the family age average
     * @param family person
     * @return the age average
     */
    public Integer calcAgeAverage(List<Person> family){
        return family.stream().map(p->p.age).reduce((a, n)->a+n).orElse(0)/family.size();
    }

}
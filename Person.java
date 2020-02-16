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


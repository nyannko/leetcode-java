package ds.hashtable;

import java.util.HashMap;
import java.util.HashSet;

// Show how to rewrite hashcode and equals
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private int id;

    public Person(String firstName, String lastName, int age, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
    }

    @Override
    public int hashCode() {
        int B = 31;
        int hash = 0;
        hash = hash * B + age;
        hash = hash * B + id;
        hash = hash * B + firstName.toLowerCase().hashCode();
        hash = hash * B + lastName.toLowerCase().hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        Person another = (Person) o;
        return this.age == another.age &&
                this.id == another.id &&
                this.firstName.toLowerCase().equals(another.firstName.toLowerCase()) &&
                this.lastName.toLowerCase().equals(another.lastName.toLowerCase());
    }

    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer) a).hashCode()); // 42

        int b = -42;
        System.out.println(((Integer) b).hashCode()); // -42

        double c = 3.1415926;
        System.out.println(((Double) c).hashCode()); // 219937201

        String d = "mei";
        System.out.println(d.hashCode()); // 107985


        Person Mei = new Person("Mei", "Mei", 20, 11);
        Person mei = new Person("mei", "mei", 20, 11);
        System.out.println(Mei.hashCode() + " " + mei.hashCode()); // 4061911 4061911
        System.out.println(Mei.equals(mei)); // true

        HashSet<Person> set = new HashSet<>();
        set.add(Mei);
        set.add(mei);
        System.out.println(set.size()); // 1

        HashMap<Person, Integer> map = new HashMap<>();
        map.put(Mei, 100);
        map.put(mei, 100);
        System.out.println(map.keySet());
    }
}

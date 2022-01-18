package knowledge.lambda.stream.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Weiyan Xiang on 2020/6/19
 */
public class GroupByDemo {

    static class Person {
        private String lastName;
        private String firstName;
        private String city;

        public Person(String firstName, String lastName, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.city = city;
        }

        public String getLastName() {
            return lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getCity() {
            return city;
        }
    }

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "apple", "banana",
                "apple", "orange", "banana", "papaya");

        Map<String, Long> map = fruits.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

        Person p0 = new Person("Tylor", "Smith", "London");
        Person p1 = new Person("Jim", "Smith", "NYC");
        Person p2 = new Person("Tom", "Burgess", "Beijing");
        Person p3 = new Person("Bruce", "Byski", "London");
        Person p4 = new Person("Oliver", "Stones", "NYC");

        List<Person> people = Arrays.asList(p0, p1, p2, p3, p4);
        Map<String, List<String>> collect = people.stream().collect(Collectors.groupingBy(
                Person::getCity,
                Collectors.mapping(p -> new StringBuilder().append(p.getFirstName()).append(".").append(p.getLastName()).toString(),
                        Collectors.toList())));

        System.out.println(collect);

    }


}

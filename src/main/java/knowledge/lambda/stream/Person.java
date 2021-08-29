package knowledge.lambda.stream;/**
 * @author Weiyan Xiang on 2021/8/26
 */

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Person {
    private int id;
    private int score;
    private String city;

    public Person(int id, int score, String city) {
        this.id = id;
        this.score = score;
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();

        // find each city's highest score
//        Map<String, List<Person>> collect = list.stream().collect(Collectors.groupingBy(p -> p.city));
        Map<String, Person> collect = list.stream().collect(Collectors.toMap(p -> p.city, p->p,
                BinaryOperator.maxBy(Comparator.comparing(p -> p.score))));
    }
}
package knowledge.lambda.stream.practice;/**
 * @author Weiyan Xiang on 2021/8/26
 */

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;
public class Person {
    private int id;
    private int score;
    private String city;

    public Person(int id, int score, String city) {
        this.id = id;
        this.score = score;
        this.city = city;
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person(4, 10, "london"));
        list.add(new Person(1, 1, "london"));
        list.add(new Person(5, 10, "Sydney"));
        list.add(new Person(2, 2, "Sydney"));
        list.add(new Person(6, 10, "Manchester"));
        list.add(new Person(3, 3, "Manchester"));

        // find each city's highest score with optional only
        Map<String, Optional<Person>> citiesWithMaxScoreOptional = list.stream()
                .collect(groupingBy(p -> p.city, maxBy(comparingInt(c -> c.score))));
        System.out.println(citiesWithMaxScoreOptional.entrySet().stream().map(e -> e.getValue().get()).collect(toList()));

        // need to us toMap with unwrapped concrete values
        Map<String, Person> citiesWithMaxScore = list.stream().collect(Collectors.toMap(p -> p.city, p -> p,
                BinaryOperator.maxBy(comparingInt(p -> p.score))));
        System.out.println(citiesWithMaxScore.values());
        // set of person ids per city where city names are sorted
        TreeMap<String, List<Integer>> personIdsPerCityInOrder = list.stream().collect(groupingBy(c -> c.city,
                () -> new TreeMap<>(), mapping(e -> e.id, toList())));
        System.out.println(personIdsPerCityInOrder);
        // partition into 2 sets
        Map<Boolean, List<String>> personWithScoreGreaterThan5 = list.stream().collect(
                partitioningBy(s -> s.id > 5, mapping(e -> e.toString(), toList())));
        System.out.println(personWithScoreGreaterThan5);

        String allCities = list.stream().map(e -> e.city).distinct().collect(joining(" | ", "All cities are: [", "]"));
        System.out.println(allCities);

        List<Person> newList = new ArrayList<>(list);
        newList.sort(Comparator.comparingInt(Person::getScore).reversed().thenComparing(Person::getId));
        System.out.println("sorting by highest score and then lowest id for all persons:");
        System.out.println(newList);
        List<Person> sortedByHighestScoreAndThenLowestId = list.stream().sorted(comparingInt(Person::getScore).reversed().thenComparing(Person::getId)).collect(toList());
        System.out.println(sortedByHighestScoreAndThenLowestId);
        System.out.println();

        Integer minus = Stream.of(1, 10, 17, 29).collect(reducing((i1, i2) -> {
            System.out.println("i2=" + i2 + ", i1=" + i1 + ", i2-i1=" + (i2 - i1));
            return i2 - i1;
        })).orElse(-1);
        System.out.println(minus);
    }

    public int getId() {
        return id;
    }

    public int getScore() {
        return score;
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

    public String getCity() {
        return city;
    }

    public boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(n -> n % 2 == 0);
    }

    public List<Integer> generateTenRandomNumbers() {
        return new Random().ints().limit(10).boxed().collect(Collectors.toList());
    }

    public List<Integer> generateFirstTenPrimeNums() {
        return IntStream.iterate(1, i -> i + 1).filter(this::isPrime).limit(10).boxed().collect(toList());
    }


    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", score=" + score +
                ", city='" + city + '\'' +
                '}';
    }


}

package knowledge.lambda.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Weiyan Xiang on 2018/8/6
 */

/**
 * You can build more of them as an when needed. So far so good. Far using above methods I have included above 3 methods
 * in this class
 */
public class EmployeePredicate {

    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > 21 && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > 18 && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate) {
        return employees.stream().filter(predicate).collect(Collectors.toList());
    }
}

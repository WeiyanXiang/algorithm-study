package knowledge.lambda.predicate;

/**
 * @author Weiyan Xiang
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static knowledge.lambda.predicate.EmployeePredicate.*;

/**
 * https://howtodoinjava.com/java8/how-to-use-predicate-in-java-8/
 * <p>
 * In java 8, Predicate a functional interface and can therefore be used as the assignment target for a lambda
 * expression or method reference. So, where you think, you can use these true/false returning functions in day to day
 * programming? I will say you can use them anywhere where you need to evaluate a condition on group/collection of
 * similar objects such that evaluation can result either in true or false e.g. 1) Find all children borned after a
 * particular date 2) Pizzas ordered a specific time 3) Employees greater than certain age and so on..
 */
public class EmployeePredicateDemo {


    public static void main(String args[]) {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(new Employee[]{e1, e2, e3, e4, e5, e6, e7, e8, e9, e10}));

        System.out.println(filterEmployees(employees, isAdultMale()));

        System.out.println(filterEmployees(employees, isAdultFemale()));

        System.out.println(filterEmployees(employees, isAgeMoreThan(35)));

        // Employees other than above collection of "isAgeMoreThan(35)" can be get using negate()
        System.out.println(filterEmployees(employees, isAgeMoreThan(35).negate()));
    }
}

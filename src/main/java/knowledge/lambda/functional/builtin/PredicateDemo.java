package knowledge.lambda.functional.builtin;

import knowledge.lambda.predicate.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static knowledge.lambda.predicate.EmployeePredicate.*;
import static knowledge.lambda.predicate.EmployeePredicate.filterEmployees;
import static knowledge.lambda.predicate.EmployeePredicate.isAgeMoreThan;

/**
 * @author Weiyan Xiang on 2018/8/6 http://eherrera.net/ocpj8-notes/04-lambda-built-in-functional-interfaces
 */
public class PredicateDemo {

    /**
     * A predicate is a statement that may be true or false depending on the values of its variables. It can be thought
     * of as a function that returns a value that is either true or false.
     */
    private static Predicate<Employee> predicate = p -> p.getGender().equalsIgnoreCase("M");

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

        System.out.println(employees.stream().filter(e -> e.age > 50).collect(Collectors.toList()));
        System.out.println(employees.stream().filter(predicate).collect(Collectors.toList()));

    }
}

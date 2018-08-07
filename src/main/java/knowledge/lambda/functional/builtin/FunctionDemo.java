package knowledge.lambda.functional.builtin;

import knowledge.lambda.predicate.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Weiyan Xiang on 2018/8/6
 * <p>
 * http://eherrera.net/ocpj8-notes/04-lambda-built-in-functional-interfaces
 */
public class FunctionDemo {
    /**
     * accepts one argument and produces a result
     */
    private static Function<Employee, Employee> function1 = e -> {
        e.id *= 999;
        return e;
    };

    private static Function<Employee, Integer> getAges = e -> e.age;

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

        Employee employee = function1.apply(e1);
        System.out.println(employee);

        List<Integer> ages = employees.stream().map(Employee::getAge).collect(Collectors.toList());
        System.out.println(ages);

    }
}

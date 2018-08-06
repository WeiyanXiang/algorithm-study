package knowledge.lambda.predicate;

import java.util.function.Predicate;

/**
 * @author Weiyan Xiang on 2018/8/6
 */
public class Employee {
    private Integer id;
    private Integer age;
    private String gender;
    private String firstName;
    private String lastName;

    public Employee(Integer id, Integer age, String gender, String fName, String lName) {
        this.id = id;
        this.age = age;
        this.gender = gender;
        this.firstName = fName;
        this.lastName = lName;
    }

    protected int getAge() {
        return this.age;
    }

    public String getGender() {
        return this.gender;
    }

    //Please generate Getter and Setters
    @Override
    public String toString() {
        return this.id.toString() + " - " + this.age.toString() + " - " + this.gender; //To change body of generated methods, choose Tools | Templates.
    }
}

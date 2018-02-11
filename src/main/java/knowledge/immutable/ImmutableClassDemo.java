/**
 * 
 */
package knowledge.immutable;

import java.util.Date;

/**
 * @author weiyan.xiang
 * @date 11 Feb 2018
 */
public final class ImmutableClassDemo {

    /**
     * o Declare the class as final so it can’t be extended. o Make all fields
     * private so that direct access is not allowed. o Don’t provide setter
     * methods for variables o Make all mutable fields final so that it’s value
     * can be assigned only once. o Initialize all the fields via a constructor
     * performing deep copy. o Perform cloning of objects in the getter methods
     * to return a copy rather than returning the actual object reference.
     * 
     */
    private final Date date;
    private final String name;
    private final User user;

    /**
     * @param date
     * @param name
     * @param user
     */
    public ImmutableClassDemo(Date date, String name, User user) {
        this.date = (Date) date.clone();
        this.name = name;
        User tempUser = new User(user.getUsername(), user.getAge());
        this.user = tempUser;
    }

    public Date getDate() {
        return (Date) date.clone();
    }

    public String getName() {
        return name;
    }

    public User getUser() {
        User tempUser = new User(user.getUsername(), user.getAge());
        return tempUser;
    }

    public static void main(String[] args) {
        User newUser = new User("username", 28);
        ImmutableClassDemo instance = new ImmutableClassDemo(new Date(), "demo 1", newUser);
        System.out.println(instance.getUser().getUsername() + ", " + instance.getUser().getAge());
        instance.getUser().setAge(55);
        instance.getUser().setUsername("another username");
        System.out.println(instance.getUser().getUsername() + ", " + instance.getUser().getAge());
    }

}

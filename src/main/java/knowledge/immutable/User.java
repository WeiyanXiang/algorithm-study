/**
 * 
 */
package knowledge.immutable;

/**
 * @author weiyan.xiang
 * @date 11 Feb 2018
 */
public class User {
    private String username;
    private int age;

    /**
     * @param username
     * @param age
     */
    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

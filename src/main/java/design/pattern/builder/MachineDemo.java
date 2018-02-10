/**
 * 
 */
package design.pattern.builder;

import java.util.Arrays;

/**
 * @author weiyan.xiang
 * @date 10 Feb 2018
 */
public class MachineDemo {

    public static void main(String[] args) {
        MachineBuilder builder = new MachineBuilder();
        Machine machine = builder.name("name").capacity(1).color("red").history("No History")
                .materials(Arrays.asList("metal", "cotton")).build();
        System.out.println(machine);
    }
}

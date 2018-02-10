/**
 * 
 */
package design.pattern.builder;

import java.util.List;

/**
 * @author weiyan.xiang
 * @date 10 Feb 2018
 */
public class MachineBuilder {
    protected String name;
    protected String color;
    protected int capacity;
    protected int price;
    protected List<String> materials;
    protected String history;

    public Machine build() {
        return new Machine(name, color, capacity, price, materials, history);
    }

    public MachineBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MachineBuilder color(String color) {
        this.color = color;
        return this;
    }

    public MachineBuilder capacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public MachineBuilder price(int price) {
        this.price = price;
        return this;
    }

    public MachineBuilder materials(List<String> materials) {
        this.materials = materials;
        return this;
    }

    public MachineBuilder history(String history) {
        this.history = history;
        return this;
    }

}

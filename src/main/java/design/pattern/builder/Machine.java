/**
 * 
 */
package design.pattern.builder;

import java.util.List;

/**
 * @author weiyan.xiang
 * @date 10 Feb 2018
 */
public class Machine {

    private String name;
    private String color;
    private int capacity;
    private int price;
    private List<String> materials;
    private String history;

    /**
     * @param name
     * @param color
     * @param capacity
     * @param price
     * @param materials
     * @param history
     */
    protected Machine(String name, String color, int capacity, int price, List<String> materials, String history) {
        this.name = name;
        this.color = color;
        this.capacity = capacity;
        this.price = price;
        this.materials = materials;
        this.history = history;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public String getHistory() {
        return history;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Machine [name=").append(name).append(", color=").append(color).append(", capacity=")
                .append(capacity).append(", price=").append(price).append(", materials=").append(materials)
                .append(", history=").append(history).append("]");
        return builder.toString();
    }

}

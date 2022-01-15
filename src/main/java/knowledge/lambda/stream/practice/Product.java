package knowledge.lambda.stream.practice;/**
 * @author Weiyan Xiang on 2022/1/15
 */

import java.util.Set;

public class Product {
    private Long id;
    private String name;
    private String category;
    private Double price;
    private Set<Order> orders;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Order> getOrders() {
        return orders;
    }
}

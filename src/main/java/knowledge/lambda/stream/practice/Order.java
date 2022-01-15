package knowledge.lambda.stream.practice;/**
 * @author Weiyan Xiang on 2022/1/15
 */

import java.time.LocalDate;
import java.util.Set;

public class Order {
    Set<Product> products;
    private Long id;

    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private String status;
    private Customer customer;

    public Long getId() {
        return id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public String getStatus() {
        return status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", status='" + status + '\'' +
                ", customer=" + customer +
                ", products=" + products +
                '}';
    }
}

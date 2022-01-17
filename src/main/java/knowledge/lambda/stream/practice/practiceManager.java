package knowledge.lambda.stream.practice;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

/**
 * @author Weiyan Xiang on 2022/1/15
 */

public class practiceManager {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(new Product(), new Product(), new Product());
        List<Order> orders = Arrays.asList(new Order(), new Order(), new Order());
        List<Customer> customers = Arrays.asList(new Customer(), new Customer(), new Customer());
        // Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
        products.stream().filter(p -> "book".equalsIgnoreCase(p.getCategory()) && p.getPrice() > 100)
                .collect(Collectors.toList());

        // Exercise 2 — Obtain a list of order with products belong to category “Baby”
        orders.stream().filter(o -> o.products.stream().anyMatch(p -> "baby".equalsIgnoreCase(p.getCategory())))
                .collect(Collectors.toList());

        // Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
        products.stream().filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
                .peek(p -> p.setPrice(p.getPrice() * 0.9)).collect(Collectors.toList());

        // Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        List<Product> expectedProducts = orders.stream().filter(o -> o.getCustomer().getTier() == 2 &&
                o.getOrderDate().isAfter(LocalDate.of(2021, 2, 1)) &&
                o.getOrderDate().isBefore(LocalDate.of(2021, 4, 1))
        ).flatMap(o -> o.getProducts().stream()).collect(Collectors.toList());

        // Exercise 5 — Get the cheapest products of “Books” category
        products.stream().filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .collect(Collectors.minBy(Comparator.comparingDouble(p -> p.getPrice())));
        products.stream().filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .min(Comparator.comparingDouble(p -> p.getPrice())).orElse(null);

        // Exercise 6 — Get the 3 most recent placed order
        List<Order> recentOrders = orders.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3).collect(Collectors.toList());

        // Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
        List<Product> productList = orders.stream().filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .peek(System.out::println)
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

        // Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
        orders.stream().filter(o -> o.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)) && o.getOrderDate().isBefore(LocalDate.of(2021, 3, 1)))
                .flatMap(o -> o.getProducts().stream()).mapToDouble(Product::getPrice).sum();

        // Exercise 9 — Calculate order average payment placed on 14-Mar-2021
        Double collect = orders.stream().filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 14)))
                .flatMap(o -> o.getProducts().stream()).collect(Collectors.averagingDouble(Product::getPrice));

        // Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
        products.stream().filter(p -> p.getCategory().equalsIgnoreCase("Books"))
                .collect(Collectors.summarizingDouble(Product::getPrice));

        // Exercise 11 — Obtain a data map with order id and order’s product count
        Map<Long, Long> orderIdWithCountOfProducts = orders.stream()
                .collect(groupingBy(Order::getId, Collectors.mapping(o -> o.getProducts(), Collectors.counting())));
        Map<Long, Integer> orderIdWithCountOfProductsAnother = orders.stream().collect(toMap(Order::getId, p -> p.getProducts().size()));
        // Exercise 12 — Produce a data map with order records grouped by customer
        Map<Customer, List<Order>> collect1 = orders.stream().collect(groupingBy(Order::getCustomer));
        // Exercise 13 — Produce a data map with order record and product total sum
        Map<Order, Double> collect2 = orders.stream().collect(toMap(Function.identity(), o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum()));
        // Exercise 14 — Obtain a data map with list of product name by category
        Map<String, List<String>> productNamesByCategory = products.stream()
                .collect(groupingBy(Product::getCategory, mapping(Product::getName, toList())));
        // Exercise 15 — Get the most expensive product by category
        Map<String, Optional<Product>> pricyProductsByCategory = products.stream()
                .collect(groupingBy(Product::getCategory, maxBy(Comparator.comparingDouble(Product::getPrice))));

    }
}

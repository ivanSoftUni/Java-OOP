package Encapsulation._03ShoppingSpree;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {

    private String name;
    private double money;
    private List<Product> products = new ArrayList<>();


    public Person(String name, double money) {
        setName(name);
        setMoney(money);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void buyProduct(Product product) {
        if (money >= product.getCost()) {
            setMoney(money - product.getCost());
            products.add(product);
        } else {
            throw new IllegalArgumentException(String.format("%s can't afford %s", name, product.getName()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " - ");
        String productList = products.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        sb.append(productList);
        return sb.toString();
    }
}

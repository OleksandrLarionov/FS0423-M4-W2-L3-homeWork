package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Product {
    private Long id;
    private String name;
    private final Category category;
    private double price;
    public static List<Product> order = new ArrayList<>();


    public  Product(String name, Category category, double price) {
        this.id = randomId();
        this.name = name;
        this.category = category;
        if (price < 0) {
            throw new IllegalArgumentException("Il prezzo deve essere positivo.");
        }
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public List<Product> getOrder() {
        return order;
    }

    private Long randomId () {
        Random rndm = new Random();
        return rndm.nextLong();
    }



}

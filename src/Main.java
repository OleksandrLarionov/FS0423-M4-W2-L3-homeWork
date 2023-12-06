import entities.Category;
import entities.Product;

import java.util.List;
import java.util.function.Predicate;

import static entities.Category.*;

public class Main {
    public static void main(String[] args) {
//        *******************Creazione del Prodotto**************
        Product bookOne = new Product("Signore degli annelli", Books, 15.99);
        Product bookTwo = new Product("Batman il Cavaliere oscuro", Books, 9.99);
        Product bookThree = new Product("Spiderman", Books, 23.99);
        Product baby = new Product("Pannolone", Category.Baby, 14.50);
        Product boys = new Product("Lego", Category.Boys, 500.99);
        Product bookthree = new Product("Principessa", Books, 100.99);


        Product.order.add(bookOne);
        Product.order.add(baby);
        Product.order.add(bookThree);
        Product.order.add(boys);
        Product.order.add(bookthree);


        System.out.println("****************Books*********************");
//        Predicate<Product> product = category -> category.getCategory() == Books;
//
//        List<Product> books = Product.order.stream().filter(product).toList();
//        books.stream().filter(books2 -> books2.getPrice() > 100).forEach(System.out::println);

        //**********************metodo 2******************
        List<Product> books = Product.order.stream().filter(product -> product.getCategory() == Books && product.getPrice() > 100).toList();
        System.out.println(books);

        System.out.println("****************Baby*********************");

        Predicate<Product> product2 = category -> category.getCategory() == Baby;

        List<Product> babyProducts = Product.order.stream().filter(product2).toList();
        System.out.println(babyProducts);

        System.out.println("****************Boys*********************");

        Predicate<Product> product3 = category -> category.getCategory() == Boys;

        List<Product> boysProduct = Product.order.stream().filter(product3).toList();
        boysProduct.stream().map(productBoys -> {
            productBoys.setPrice(productBoys.getPrice() * 0.90);
            return productBoys;
        }).forEach(System.out::println);

    }
}
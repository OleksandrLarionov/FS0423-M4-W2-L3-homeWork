import entities.Category;
import entities.Product;

import java.util.function.Predicate;

import static entities.Category.Books;

public class Main {
    public static void main(String[] args) {
//        *******************Creazione del Prodotto**************
        Product bookOne = new Product("Signore degli annelli", Books, 15.99);
        Product bookTwo = new Product("Batman il Cavaliere oscuro", Books, 9.99);
        Product bookThree = new Product("Spiderman", Books, 23.99);
        Product baby = new Product("Pannolone",Category.Baby, 14.50);
        Product boys = new Product("Lego", Category.Boys, 500.99);

        Product.order.add(bookOne);
        Product.order.add(baby);
        Product.order.add(bookThree);
        Product.order.add(boys);


        Predicate<Product> product = category -> category.getCategory() == Books;
        
        Product.order.stream().filter(product).forEach(book -> System.out.println(book.getPrice()));
    }
}
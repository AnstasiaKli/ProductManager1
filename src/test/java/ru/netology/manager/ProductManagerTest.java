package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product Book = new Book(1, "Harry Potter and the Goblet of Fire", 1500, "Joanne Rowling");
    Product Book1 = new Book(2, "Misery", 1000, "Stephen King");
    Product Book2 = new Book(3, "The Picture of Dorian Gray", 1200, "Oscar Wilde");
    Product Smartphone = new Smartphone(4, "Samsung Galaxy S22", 55000, "Samsung");
    Product Smartphone1 = new Smartphone(5, "Iphone 14 Pro", 95000, "Apple");
    Product Smartphone2 = new Smartphone(6, "Xiaomi 12", 57000, "Xiaomi");
    Product Smartphone3 = new Smartphone(7, "Iphone 13", 60000, "Apple");

    @Test
    public void shouldSearchOneProduct() {

        manager.add(Book);
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Smartphone);
        manager.add(Smartphone1);
        manager.add(Smartphone2);
        manager.add(Smartphone3);

        String name = "Harry Potter and the Goblet of Fire";

        Product[] expected = {Book};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchSeveralProducts() {
        manager.add(Book);
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Smartphone);
        manager.add(Smartphone1);
        manager.add(Smartphone2);
        manager.add(Smartphone3);

        String name = "Iphone";


        Product[] expected = {Smartphone1, Smartphone3};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchWhenNoOneProductFits() {
        manager.add(Book);
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Smartphone);
        manager.add(Smartphone1);
        manager.add(Smartphone2);
        manager.add(Smartphone3);

        String name = "Honor 10";

        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddProduct() {
        manager.add(Smartphone);
        Product[] expected = {Smartphone};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAllProducts() {
        manager.add(Book);
        manager.add(Book1);
        manager.add(Book2);
        manager.add(Smartphone);
        manager.add(Smartphone1);
        manager.add(Smartphone2);
        manager.add(Smartphone3);

        Product[] expected = {Book, Book1, Book2, Smartphone, Smartphone1, Smartphone2, Smartphone3};
        Product[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}

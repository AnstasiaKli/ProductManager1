package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.exception.NotFoundException;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product Book = new Book(1, "Harry Potter and the Goblet of Fire", 1500, "Joanne Rowling");
    Product Book1 = new Book(2, "Misery", 1000, "Stephen King");
    Product Book2 = new Book(3, "The Picture of Dorian Gray", 1200, "Oscar Wilde");
    Product Smartphone = new Smartphone(4, "Samsung Galaxy S22", 55000, "Samsung");
    Product Smartphone1 = new Smartphone(5, "Iphone 14 Pro", 95000, "Apple");
    Product Smartphone2 = new Smartphone(6, "Xiaomi 12", 57000, "Xiaomi");
    Product Smartphone3 = new Smartphone(7, "Iphone 13", 60000, "Apple");


    @Test
    public void shouldSaveAll() {

        repository.save(Book);
        repository.save(Book1);
        repository.save(Book2);
        repository.save(Smartphone);
        repository.save(Smartphone1);
        repository.save(Smartphone2);
        repository.save(Smartphone3);

        Product[] expected = {Book, Book1, Book2, Smartphone, Smartphone1, Smartphone2, Smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveFewProduct() {

        repository.save(Book);
        repository.save(Book1);
        repository.save(Book2);

        Product[] expected = {Book, Book1, Book2};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWhenProductExist() {

        repository.save(Book);
        repository.save(Book1);
        repository.save(Book2);
        repository.save(Smartphone);
        repository.save(Smartphone1);
        repository.save(Smartphone2);
        repository.save(Smartphone3);
        repository.removeById(4);

        Product[] expected = {Book, Book1, Book2, Smartphone1, Smartphone2, Smartphone3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveWhenProductNotExist() {

        repository.save(Book);
        repository.save(Book1);
        repository.save(Book2);
        repository.save(Smartphone);
        repository.save(Smartphone1);
        repository.save(Smartphone2);
        repository.save(Smartphone3);


        Assertions.assertThrows(NotFoundException.class, () -> repository.removeById(8));
    }
}
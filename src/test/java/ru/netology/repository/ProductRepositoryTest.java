package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();

     Product first = new Book(1, "Непобедимое солнце", 1000, "Пелевин");
     Product second = new Book(2, "Музыка мозга", 1500, "Прен");
     Product third = new TShirt(3, "throw", 500, "green", "m");
     Product fourth = new TShirt(4, "back", 700, "yellow", "l");



    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
    }

    @Test
    void shouldRemoveById() {
        repository.removeById(3);


        Product[] actual = repository.getAll();
        Product[] expected = new Product[] {first,second,fourth};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdNotExist() {

        assertThrows(NotFoundException.class, () -> repository.removeById(5));
    }




}
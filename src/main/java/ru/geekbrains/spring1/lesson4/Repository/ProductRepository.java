package ru.geekbrains.spring1.lesson4.Repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson4.Entities.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Bread", 10),
                new Product(2l, "Milk", 20),
                new Product(3l, "Water", 30),
                new Product(4l, "Cheese", 10),
                new Product(5l, "Orange", 100)
        ));
    }

    public List<Product> getAllProducts(){
        return Collections.unmodifiableList(products);
    }

    public Product findProductByID(Long id){
        for (Product p : products){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }
}

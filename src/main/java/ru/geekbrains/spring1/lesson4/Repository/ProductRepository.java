package ru.geekbrains.spring1.lesson4.Repository;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson4.Entities.Product;

import javax.annotation.PostConstruct;
import java.util.*;

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

    public Product findById(Long id) {
        for (Product p : products){
            if (p.getId() == id){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

    public void deleteProductById(Long id){
        Iterator<Product> iter = products.iterator();
        while (iter.hasNext()){
            Product p = iter.next();
            if (p.getId() == id){
                iter.remove();
            }
        }
    }
}

package week15.product;

import java.util.List;

public interface ProductDAO {

    void create(Product product);

    void delete(String productCode);

    List<Product> findAll();

    List<Product> findAllByProductName(int quantityInStock);

    void update(String productCode, Product product);
}

package it.academy.data;

import java.util.List;

public interface ProductSpecDao {

    void create(ProductSpec productSpec);

    ProductSpec read(int id);

    List<ProductSpec> readAll();

    void update(ProductSpec productSpec);

    void delete(ProductSpec productSpec);

}

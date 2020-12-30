package it.academy.data;

import java.util.List;

public interface ProductSpecPriceDao {

    void create(ProductSpecPrice productSpecPrice);

    ProductSpecPrice read(int id);

    List<ProductSpecPrice> readAll();

    void update(ProductSpecPrice productSpecPrice);

    void delete(ProductSpecPrice productSpecPrice);
}

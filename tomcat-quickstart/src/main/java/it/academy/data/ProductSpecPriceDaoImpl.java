package it.academy.data;

import java.sql.Connection;
import java.util.List;

public class ProductSpecPriceDaoImpl implements ProductSpecPriceDao {

    private final Connection connection;

    public ProductSpecPriceDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ProductSpecPrice productSpecPrice) {

    }

    @Override
    public ProductSpecPrice read(int id) {
        return null;
    }

    @Override
    public List<ProductSpecPrice> readAll() {
        return null;
    }

    @Override
    public void update(ProductSpecPrice productSpecPrice) {

    }

    @Override
    public void delete(ProductSpecPrice productSpecPrice) {

    }
}

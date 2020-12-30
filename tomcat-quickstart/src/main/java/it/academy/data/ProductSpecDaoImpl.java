package it.academy.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSpecDaoImpl implements ProductSpecDao {

    private final Connection connection;

    public ProductSpecDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ProductSpec productSpec) {
        try (PreparedStatement preparedStatement= connection.prepareStatement("insert into product.product_spec (id, prod_name, product_details, product_date)\n" +
                "            values (?, ?,?, ?)")){
            preparedStatement.setInt(1, productSpec.getId());
            preparedStatement.setString(2,productSpec.getProductName());
            preparedStatement.setString(3,productSpec.getProductDetails());
            preparedStatement.setDate(4,productSpec.getProductDate());
            System.out.println(preparedStatement.executeUpdate());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        }

    }

    @Override
    public ProductSpec read(int id) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from product_spec where id =" + id)) {
            resultSet.next();
            ProductSpec product = new ProductSpec();
            product.setId(resultSet.getInt("id"));
            product.setProductDate(resultSet.getDate("product_date"));
            product.setProductName(resultSet.getString("prod_name"));
            product.setProductDetails(resultSet.getString("product_details"));
            return product;
        } catch (SQLException e) {
            e.printStackTrace();}

            return null;
        }

        @Override
        public List<ProductSpec> readAll () {
            List<ProductSpec> productSpecs = new ArrayList<>();
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery("select * from product_spec")) {
                while (resultSet.next()) {
                    ProductSpec product = new ProductSpec();
                    product.setId(resultSet.getInt("id"));
                    product.setProductDate(resultSet.getDate("product_date"));
                    product.setProductName(resultSet.getString("prod_name"));
                    product.setProductDetails(resultSet.getString("product_details"));
                    productSpecs.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return productSpecs;
        }

        @Override
        public void update (ProductSpec productSpec){

        }

        @Override
        public void delete (ProductSpec productSpec){

        }
    }

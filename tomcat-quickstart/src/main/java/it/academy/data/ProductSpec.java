package it.academy.data;

import java.io.Serializable;
import java.sql.Date;

public class ProductSpec implements Serializable {

    private int id;
    private String productName;
    private String productDetails;
    private Date productDate;

    public ProductSpec() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(String productDetails) {
        this.productDetails = productDetails;
    }

    public Date getProductDate() {
        return productDate;
    }

    public void setProductDate(Date productDate) {
        this.productDate = productDate;
    }

    @Override
    public String toString() {
        return "ProductSpec{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productDetails='" + productDetails + '\'' +
                ", productDate=" + productDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSpec that = (ProductSpec) o;

        if (id != that.id) return false;
        if (productName != null ? !productName.equals(that.productName) : that.productName != null) return false;
        if (productDetails != null ? !productDetails.equals(that.productDetails) : that.productDetails != null)
            return false;
        return productDate != null ? productDate.equals(that.productDate) : that.productDate == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productDetails != null ? productDetails.hashCode() : 0);
        result = 31 * result + (productDate != null ? productDate.hashCode() : 0);
        return result;
    }
}

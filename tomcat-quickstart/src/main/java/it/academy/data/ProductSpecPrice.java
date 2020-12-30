package it.academy.data;

import java.io.Serializable;
import java.sql.Date;

public class ProductSpecPrice implements Serializable {

    private long id;
    private float productSpecPrice;
    private Date priceStartDate;
    private Date priceEndDate;
    private int productSpecId;

    public ProductSpecPrice() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getProductSpecPrice() {
        return productSpecPrice;
    }

    public void setProductSpecPrice(float productSpecPrice) {
        this.productSpecPrice = productSpecPrice;
    }

    public Date getPriceStartDate() {
        return priceStartDate;
    }

    public void setPriceStartDate(Date priceStartDate) {
        this.priceStartDate = priceStartDate;
    }

    public Date getPriceEndDate() {
        return priceEndDate;
    }

    public void setPriceEndDate(Date priceEndDate) {
        this.priceEndDate = priceEndDate;
    }

    public int getProductSpecId() {
        return productSpecId;
    }

    public void setProductSpecId(int productSpecId) {
        this.productSpecId = productSpecId;
    }

    @Override
    public String toString() {
        return "ProductSpecPrice{" +
                "id=" + id +
                ", productSpecPrice=" + productSpecPrice +
                ", priceStartDate=" + priceStartDate +
                ", priceEndDate=" + priceEndDate +
                ", productSpecId=" + productSpecId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductSpecPrice that = (ProductSpecPrice) o;

        if (id != that.id) return false;
        if (Float.compare(that.productSpecPrice, productSpecPrice) != 0) return false;
        if (productSpecId != that.productSpecId) return false;
        if (priceStartDate != null ? !priceStartDate.equals(that.priceStartDate) : that.priceStartDate != null)
            return false;
        return priceEndDate != null ? priceEndDate.equals(that.priceEndDate) : that.priceEndDate == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (productSpecPrice != +0.0f ? Float.floatToIntBits(productSpecPrice) : 0);
        result = 31 * result + (priceStartDate != null ? priceStartDate.hashCode() : 0);
        result = 31 * result + (priceEndDate != null ? priceEndDate.hashCode() : 0);
        result = 31 * result + productSpecId;
        return result;
    }
}

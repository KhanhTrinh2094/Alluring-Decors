
package entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Carts implements Serializable{

    private String title, image;
    private int code;
    private BigDecimal price;
    public int quantity = 1;

    public Carts() {
    }

    public Carts(String title, String image, int code, BigDecimal price) {
        this.title = title;
        this.image = image;
        this.code = code;
        this.price = price;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}

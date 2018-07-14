
public class Product {
    private String productID;
    private float price;
    private String brand;
    private String fabricationYear;
    private int warranty; // in months
    private String category;
    private String countryOfMaking;
    private int stock;
    
    public Product(String productID) {
        this.productID = productID;
    }
    
    public String getCategory() {
        return category;
    }
    
    public void setCategory(String cat) {
        this.category = cat;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String code) {
        this.productID = code;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFabricationYear() {
        return fabricationYear;
    }

    public void setFabricationYear(String fabricationYear) {
        this.fabricationYear = fabricationYear;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int garantie) {
        this.warranty = garantie;
    }

    public String getCountryOfMaking() {
        return countryOfMaking;
    }

    public void setCountryOfMaking(String countryOfMaking) {
        this.countryOfMaking = countryOfMaking;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return productID + ", price=" + price +", "+ category+","+brand +", "+fabricationYear + ", country=" + countryOfMaking + ", stock=" + stock + '}';
    }
    
}

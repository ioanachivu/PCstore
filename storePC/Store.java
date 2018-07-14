
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Store {
    
    Set<Product> productList = new HashSet<>();
    
    // loading the products from file
    public void fileReading() {
        
    File file = new File("C:\\Users\\ChivuIoanaAlexandra\\git\\PCstore\\storePC\\fisierMagazinPC.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String string;
        
        while((string = br.readLine()) != null) {
            String[] v = string.split(",");
            Product product = new Product(v[0]); 
            product.setPrice(Float.parseFloat(v[1]));
            product.setBrand(v[2]);
            product.setFabricationYear(v[3]);
            product.setWarranty(Integer.parseInt(v[4]));
            product.setCategory(v[5]);
            product.setCountryOfMaking(v[6]);
            product.setStock(Integer.parseInt(v[7]));

            productList.add(product);
            }     System.out.println("The products have been loaded into the system");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        } catch (IOException ex) {
            System.out.println("can't read file");
        } 
        
    }
    
    // loading products list
    public void showProducts() {
        for(Product p: productList) {
                System.out.println(p.toString());
            }
        }
           
    
    // adding a new product from keyboard
    public void addProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the product code:");
        Product produs = new Product(input.nextLine());
        
        System.out.println("Insert the price:");
        produs.setPrice(input.nextFloat());
        
        System.out.println("Insert the category:");
        produs.setCategory(input.next());
        
        System.out.println("Insert the brand:");
        produs.setBrand(input.next());
        
        System.out.println("Insert the year of fabrication:");
        produs.setFabricationYear(input.next());
        
        System.out.println("How much warranty? (months)");
        produs.setWarranty(input.nextInt());
        
        System.out.println("Country:");
        produs.setCountryOfMaking(input.next());
        
        System.out.println("Stock");
        produs.setStock(input.nextInt());
        
        productList.add(produs);
        System.out.println("Product "+produs.toString()+" has been added");
    }
    
    // selling method
    public void sellProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the product that has been sold:");
        String s = input.next();
        for(Product p: productList) {
            if(p.getProductID().equals(s) && p.getStock() > 0) {
                p.setStock(p.getStock()-1);
                System.out.println("Product: "+p.getBrand()+" "+p.getCategory()+" has been sold");
                break;
            }
        }
    }
    
    // deleting a product using the code
    public void deleteProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Insert the code of the product you want to delete:");
        String s = input.nextLine();
        for(Product p: productList) {
            if(p.getProductID().equals(s)) {
                System.out.println("Product: "+p.getBrand()+" "+p.getCategory()+" has been deleted");
                productList.remove(p);
                break;
            }
        }
    }
    
    // refreshing the stock method
    public void refreshStock() {

        Scanner input = new Scanner(System.in);
        System.out.println("Insert the code of the product you want to check:");
        String s = input.nextLine();
            for(Product p: productList) {
                if(p.getProductID().equals(s))
                    
                    if(p.getStock()<3) {
                    System.out.println("10 new products will be sent from the warehouse");
                    p.setStock(p.getStock()+10);
                    System.out.println("Product stock "+p+" has been refreshed");
                    break;
                    }   else {System.out.println("There are enought products in stock"); }
                }     
            }     
        
    
    // total in $ for a category
    public void calculateTotal(String s) {
        for(Product p: productList) {
            if(p.getBrand().equals(s)) {
                float t= p.getStock()*p.getPrice();
                System.out.println("Total stock is: "+t);
            }
        }
    }
    
    // showing the price by brand
    public void priceByBrand(String s) {
        for(Product p: productList) {
            if(p.getBrand().equals(s)) {
                System.out.println("Price is: "+p.getPrice());
            }
            }
        }
    
    public void test()
    {
        // MySQL driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            System.out.print(
                    e.getMessage()
            );
        }

        String url = "jdbc:mysql://33.33.33.10:3306/infotrip";
        String username = "ioanachivu";
        String password = "ICP@ssword";
        
        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }

}
  

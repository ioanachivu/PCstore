
public class Main {
    public static void main(String[] args) {
        
        Store store = new Store();
        
        store.fileReading();
        
        // show list of products
        store.showProducts();
        
        // adding a new product from keyboard
        store.addProduct();
        System.out.println("New listing of products:");
        store.showProducts();;
        
        // selling a product
        store.sellProduct();;
        
        // deleting a product
        store.deleteProduct();;
        //System.out.println("Afisare noua lista de produse:");
        store.showProducts();;
        
        // reactualizare stoc
        store.refreshStock();
        
        // totalul in lei pentru o categorie
        store.calculateTotal("Kingston");
        
        // afisare pret pt anumite produse cautate dupa marca
        store.priceByBrand("Kingston");
    }
}

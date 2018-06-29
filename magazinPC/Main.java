package magazinPC;

public class Main {
    public static void main(String[] args) {
        
        Magazin magazin = new Magazin();
        
        magazin.citireFisier();
        
        // afisare lista produse
        magazin.afisareProduse();
        
        // adaugare produs nou la o anumita componenta introdusa de la tastatura
        //magazin.adaugareProdus();
        //System.out.println("Afisare noua lista de produse:");
        //magazin.afisareProduse();
        
        // vanzare produs
        //magazin.vanzareProdus();
        
        /// stergere produs
        //magazin.stergereProdus();
        //System.out.println("Afisare noua lista de produse:");
        //magazin.afisareProduse();
        
        // reactualizare stoc
        magazin.incarcareStoc();
        
        // totalul in lei pentru o categorie
        //magazin.calculareTotal("Kingston");
        
        // afisare pret pt anumite produse cautate dupa marca
        //magazin.pretDupaMarca("Kingston");
    }
}

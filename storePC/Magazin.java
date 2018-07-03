package magazinPC;

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

public class Magazin {
    
    Set<Produs> listaProduse = new HashSet<>();
    
    // incarcare din fisier a componentelor magazinului
    public void citireFisier() {
        
    File fisier = new File("fisierMagazinPC.txt");
    try (BufferedReader br = new BufferedReader(new FileReader(fisier))) {
        String string;
        
        while((string = br.readLine()) != null) {
            String[] v = string.split(",");
            Produs produs = new Produs(v[0]); 
            produs.setPret(Float.parseFloat(v[1]));
            produs.setMarca(v[2]);
            produs.setAn_fabricatie(v[3]);
            produs.setGarantie(Integer.parseInt(v[4]));
            produs.setCategorie(v[5]);
            produs.setTara_provenienta(v[6]);
            produs.setStoc(Integer.parseInt(v[7]));

            listaProduse.add(produs);
            }     System.out.println("Produsele au fost incarcate cu succes in sistem");
        } catch (FileNotFoundException ex) {
            System.out.println("fisierul nu e gasit");
        } catch (IOException ex) {
            System.out.println("can't read file");
        } 
        
    }
    
    // afisare lista produse
    public void afisareProduse() {
        for(Produs p: listaProduse) {
                System.out.println(p.toString());
            }
        }
           
    
    // adaugare produs nou la o anumita componenta introdusa de la tastatura
    public void adaugareProdus() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti codul produsului pe care vreti sa il adaugati in baza de date:");
        Produs produs = new Produs(input.nextLine());
        
        System.out.println("Introduceti pretul produsului:");
        produs.setPret(input.nextFloat());
        
        System.out.println("Introduceti categoria produsului:");
        produs.setCategorie(input.next());
        
        System.out.println("Introduceti marca:");
        produs.setMarca(input.next());
        
        System.out.println("Introduceti anul fabricatiei:");
        produs.setAn_fabricatie(input.next());
        
        System.out.println("Ce garantie va avea produsul? (luni)");
        produs.setGarantie(input.nextInt());
        
        System.out.println("Tara de provenienta:");
        produs.setTara_provenienta(input.next());
        
        System.out.println("Introduceti stocul");
        produs.setStoc(input.nextInt());
        
        listaProduse.add(produs);
        System.out.println("Produsul "+produs.toString()+" a fost adaugat cu succes");
    }
    
    // vanzare produs
    public void vanzareProdus() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti codul produsului care s-a vandut:");
        String s = input.next();
        for(Produs p: listaProduse) {
            if(p.getCod_produs().equals(s) && p.getStoc() > 0) {
                p.setStoc(p.getStoc()-1);
                System.out.println("Produsul: "+p.getMarca()+" "+p.getCategorie()+" a fost vandut");
                break;
            }
        }
    }
    
    // stergere un produs dupa cod produs
    public void stergereProdus() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti codul produsului pe care vreti sa il stergeti:");
        String s = input.nextLine();
        for(Produs p: listaProduse) {
            if(p.getCod_produs().equals(s)) {
                System.out.println("Produsul: "+p.getMarca()+" "+p.getCategorie()+" a fost sters");
                listaProduse.remove(p);
                break;
            }
        }
    }
    
    // reintregire stoc
    public void incarcareStoc() {

        Scanner input = new Scanner(System.in);
        System.out.println("Introduceti codul produsului al carui stoc vreti sa il verificati:");
        String s = input.nextLine();
            for(Produs p: listaProduse) {
                if(p.getCod_produs().equals(s))
                    
                    if(p.getStoc()<3) {
                    System.out.println("Se vor aduce din depozit inca 10 produse");
                    p.setStoc(p.getStoc()+10);
                    System.out.println("Stocul produsului "+p+" a fost refacut");
                    break;
                    }   else {System.out.println("Sunt suficiente produse in stoc"); }
                }     
            }     
        
    
    // totalul in lei pentru o categorie
    public void calculareTotal(String s) {
        for(Produs p: listaProduse) {
            if(p.getMarca().equals(s)) {
                float t= p.getStoc()*p.getPret();
                System.out.println("Totalul stocului este: "+t);
            }
        }
    }
    
    // afisare pret pt anumite produse cautate dupa marca
    public void pretDupaMarca(String s) {
        for(Produs p: listaProduse) {
            if(p.getMarca().equals(s)) {
                System.out.println("Pretul este: "+p.getPret());
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
        String username = "mpanait";
        String password = "MPP@ssword";
        
        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }

}
  

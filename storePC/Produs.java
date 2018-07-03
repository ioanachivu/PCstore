package magazinPC;

public class Produs {
    private String cod_produs;
    private float pret;
    private String marca;
    private String an_fabricatie;
    private int garantie; // in months
    private String categorie;
    private String tara_provenienta;
    private int stoc;
    
    public String getCategorie() {
        return categorie;
    }
    
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Produs(String cod_produs) {
        this.cod_produs = cod_produs;
    }

    @Override
    public String toString() {
        return cod_produs + ", pret=" + pret +", "+ categorie+","+marca +", "+an_fabricatie + ", tara_provenienta=" + tara_provenienta + ", stoc=" + stoc + '}';
    }

    public String getCod_produs() {
        return cod_produs;
    }

    public void setCod_produs(String cod_produs) {
        this.cod_produs = cod_produs;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAn_fabricatie() {
        return an_fabricatie;
    }

    public void setAn_fabricatie(String an_fabricatie) {
        this.an_fabricatie = an_fabricatie;
    }

    public int getGarantie() {
        return garantie;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    public String getTara_provenienta() {
        return tara_provenienta;
    }

    public void setTara_provenienta(String tara_provenienta) {
        this.tara_provenienta = tara_provenienta;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
    
    
    
}

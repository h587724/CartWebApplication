package DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Product {

    private int pno;
    private String pName;
    private double priceInEuro;
    private String imageFile;

    public Product (int pno, String pName, double price, String image) {
        this.pno = pno;
        this.pName = pName;
        this.priceInEuro = price;
        this.imageFile = image;
    }

    public double convertCurrencyToLb(){
        return Math.round(priceInEuro * 100 * 0.85)/100;
    }

    public double convertCurrencyToNok(){
        return Math.round(priceInEuro * 100 * 10)/100;
    }

    public double convertCurrencyToEur(){
        return Math.round(priceInEuro * 100)/100;
    }

    public String getpName() { return pName; }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public double getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(double priceInEuro) {
        this.priceInEuro = priceInEuro;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public int getPno() {
        return pno;
    }
}

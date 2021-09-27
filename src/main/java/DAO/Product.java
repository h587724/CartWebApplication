package DAO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int pno;
    private String pName;
    private float priceInEuro;
    private String imageFile;

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public float getPriceInEuro() {
        return priceInEuro;
    }

    public void setPriceInEuro(float priceInEuro) {
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

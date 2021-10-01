package DAO;

import java.util.Random;

public class Database {
    private Product[] products;

    private Description[] descriptionEng;

    private Description[] descriptionEs;

    private Description[] descriptionNo;


    private final String image = "image";

    public Database (int size) {
        Product[] products = new Product[size];
        Description[] descriptionEng = new Description[size];
        Description[] descriptionEs = new Description[size];
        Description[] descriptionNo = new Description[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            products[i] = new Product(i, random.ints(97, 123).limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString(),
                    5 + random.nextDouble() * (995), image);        //EUR
            descriptionEng[i] = new Description(i, "en", "English description" + random.ints(97, 123).limit(100)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            descriptionEs[i] = new Description(i, "es", "Spanish desc" + random.ints(97, 123).limit(100)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
            descriptionNo[i] = new Description(i, "no", "Norsk beskrivelse" + random.ints(97, 123).limit(100)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
        }
        this.products = products;
        this.descriptionEng = descriptionEng;
        this.descriptionNo = descriptionNo;
        this.descriptionEs = descriptionEs;
    }

    public Product[] getProducts() {
        return products;
    }

    public Description[] getDescription(String code) {
        if ((descriptionEng[0] != null) && (descriptionEs[0] != null) && (descriptionNo[0] != null)){
            if (code.equals("no")) {
                return descriptionNo;
            } else if (code.equals("es")) {
                return descriptionEs;
            } else {
                return descriptionEng;      //default
            }
        } else {
            return null;
        }
    }

    public Description[] getDescriptionEs() {
        return descriptionEs;
    }

    public Description[] getDescriptionNo() {
        return descriptionNo;
    }

    public String getImage() {
        return image;
    }

}

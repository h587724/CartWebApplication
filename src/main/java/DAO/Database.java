package DAO;

import java.util.Random;

public class Database {
    private Product[] products;
    private Description[] description;
    private final String image = "image";

    public Database (int size){
        Product[] products = new Product[size];
        Description[] description = new Description[size];
        Random random = new Random();
        for (int i = 0; i < size; i++){
            products[i] = new Product(i, random.ints(97, 123).limit(10)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString(),
                    5 + random.nextFloat() * (995), image);
            description[i] = new Description(i, "", random.ints(97, 123).limit(100)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
        }
    }
}

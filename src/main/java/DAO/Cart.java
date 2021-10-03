package DAO;

import java.util.ArrayList;

public class Cart {

    private ArrayList<Product> products;

    public Cart () {
        this.products = new ArrayList<Product>();
    }

    public void addItem (int pno, Database db){
        products.add(db.findProduct(pno));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean isEmpty(){
        return products.size() == 0;
    }

    public double calculateTotal(){
        double total = 0.0;
        for (Product p : products){
            total += p.getPriceInEuro();
        }
        return total;
    }


}

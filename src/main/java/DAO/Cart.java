package DAO;

import java.util.HashMap;

public class Cart {

    private HashMap<Product, Integer> products;

    public Cart () {
        this.products = new HashMap<Product, Integer>();
    }

    public void addItem (int pno, Database db){
        if (isPresent(pno)){
            for (Product p : products.keySet()) {
                if (p.getPno() == pno) {
                    products.put(p, products.get(p) + 1);
                }
            }
        } else {
            products.put(db.findProduct(pno), 1);
        }
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public boolean isEmpty(){
        return products.size() == 0;
    }

    public double calculateTotal(){
        double total = 0.0;
        for (Product p : products.keySet()){
            total += p.getPriceInEuro();
        }
        return total;
    }

    public int quantity(int pno){
        Long quantity = products.keySet().stream().filter(a -> a.getPno() == pno).count();
        return quantity.intValue();
    }

    public boolean isPresent (int pno){
        if (findProduct(pno) == null){
            return false;
        } else {
            return true;
        }
    }

    public Product findProduct (int pno){
        Product product = null;
        for (Product e : products.keySet()){
            if (pno == e.getPno()){
                product = e;
                break;
            }
        }
        return product;
    }


    public double calculateTotalForProduct (int pno){
        return findProduct(pno).getPriceInEuro() * quantity(pno);
    }

}

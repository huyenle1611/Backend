package oop_final;

import java.util.HashMap;
import java.util.LinkedList;

public class InventorySystem {
    private HashMap<String,Product> products = new HashMap<>();
    private int orderCount = 0; 

    //lvl 1: addProduct
    public void addProduct(String name, double price){
        
        if(name == null || price <= 0){
            System.out.println("Invalid product!");
            return;
        }
        if(products.containsKey(name)){
            System.out.println("Product already existed!");
            return;
        }
        Product product = new Product(name,price);
        products.put(name,product);
    }
    //updateStock
    public void updateStock(String name, int stock){
        Product p = products.get(name);
        if(p == null){
            System.out.println("Product does not exist");
            return;
        }
        if(p.getStock() + stock < 0){
            System.out.println("Can't update, stock must be greater than 0");
            return;
        }
        p.setStock(p.getStock() + stock);  
        System.out.println("Update stock successfully, new stock of " + name + " is: " + p.getStock());
    }
    //lvl 2: customer can buy many products in the same order
    public void buy(LinkedList<Item> items){
        // check if item valid, quantity valid? stock enough?
        for(Item item : items){
            Product p = products.get(item.getProductName());
            if(p == null){
                System.out.println("Product does not exist!");
                return;
            }
            if(item.getQuantity() <= 0){
                System.out.println("Invalid quantity!");
                return;
            }
            if(p.getStock() < item.getQuantity()){
                System.out.println("Not enough stock for this product " + item.getProductName());
                return;
            }
        }
        // if all item valid >> create ordercode + update stock 
        orderCount++;
        String orderCode = String.format("ORD-%03d", orderCount);
        double total = 0.0;
        System.out.println("Order Code: " + orderCode);
        System.out.println("Items:");
        for(Item item : items){
            Product p = products.get(item.getProductName());

            //update stock of p 
            p.setStock(p.getStock() - item.getQuantity());

            total += p.getPrice() * item.getQuantity();

            System.out.println(p.getName() + " x " + item.getQuantity() + " $" + p.getPrice());
        }
        System.out.println("Total: $" + total);
    }

    // test
    public static void main(String[] args) {
        InventorySystem is = new InventorySystem();
        is.addProduct("Iphone", 1000.0);
        is.addProduct("Samsung", 800.0);
        is.addProduct(null, -100.0);

        is.updateStock("Hello",100);
        is.updateStock("Iphone", 1000);
        is.updateStock("Samsung", 10);
        is.updateStock("Iphone", -1005);
        is.updateStock("Iphone", -10);

        // test lvl 2: 
        LinkedList<Item> items = new LinkedList<>();
        items.add(new Item("Iphone", 3));
        items.add(new Item("Samsung", 2));
        is.buy(items);
    }
}

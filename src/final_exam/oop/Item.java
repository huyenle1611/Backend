package oop_final;

public class Item {
    private String productName;
    private int quantity;

    public Item(String productName, int quantity){
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }
}

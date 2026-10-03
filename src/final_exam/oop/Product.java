package oop_final;

public class Product {
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        this.stock = 0;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

}

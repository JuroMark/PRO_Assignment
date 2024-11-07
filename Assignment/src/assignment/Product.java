/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author admin
 */
public class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;

    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public boolean updateQuantity(int amount) {
        int newQuantity = this.quantity - amount;
        if (newQuantity >= 0) {
            this.quantity = newQuantity;
            return true;
        } else {
            System.out.println("Not enough quantity in stock. Available: " + this.quantity);
            return false;
        }
    }

     public String getInfo() {
        return String.format("Product ID: %d, Name: %s, Price: %.2f, Quantity: %d", 
                              productId, name, price, quantity);
    }

    
    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getProductId() {
        return productId;
    }
    
    
    
}

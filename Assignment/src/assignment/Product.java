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
    private int productId; // Mã sản phẩm
    private String name; // Tên sản phẩm
    private double price; // Giá sản phẩm
    private int quantity; // Số lượng sản phẩm

    // Constructor để khởi tạo đối tượng Product
    public Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Phương thức cập nhật số lượng sản phẩm
    public boolean updateQuantity(int amount) {
        int newQuantity = this.quantity - amount; // Tính toán số lượng mới
        if (newQuantity >= 0) { // Kiểm tra nếu số lượng mới không âm
            this.quantity = newQuantity; // Cập nhật số lượng
            return true; // Trả về true nếu cập nhật thành công
        } else {
            System.out.println("Not enough quantity in stock. Available: " + this.quantity); // Thông báo nếu không đủ số lượng
            return false; // Trả về false nếu cập nhật thất bại
        }
    }

    // Phương thức lấy thông tin sản phẩm
    public String getInfo() {
        return String.format("Product ID: %d, Name: %s, Price: %.2f, Quantity: %d", 
                              productId, name, price, quantity); // Trả về chuỗi thông tin sản phẩm
    }

    // Phương thức lấy giá sản phẩm
    public double getPrice() {
        return price;
    }

    // Phương thức lấy số lượng sản phẩm
    public int getQuantity() {
        return quantity;
    }

    // Phương thức lấy mã sản phẩm
    public int getProductId() {
        return productId;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 * Lớp này đại diện cho một Khách hàng với ID, tên và email.
 * Nó cung cấp một constructor để khởi tạo các trường này và một phương thức để lấy thông tin khách hàng.
 * 
 * @author admin
 */
public class Customer {
    // Các trường riêng tư để lưu trữ thông tin khách hàng
    private int customerId;
    private String name;
    private String email;

    /**
     * Constructor để khởi tạo đối tượng Customer với ID, tên và email.
     * 
     * @param customerId ID của khách hàng
     * @param name Tên của khách hàng
     * @param email Email của khách hàng
     */
    public Customer(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    /**
     * Phương thức để lấy thông tin khách hàng dưới dạng chuỗi.
     * 
     * @return Thông tin khách hàng bao gồm ID, tên và email
     */
    public String getInfo(){
        return "Customer ID: " + customerId + ", Name: " + name + ", Email: " + email;
    }
}
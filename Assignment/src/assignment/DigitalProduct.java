/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author admin
 */

class DigitalProduct extends Product {
    private double fileSize; // Kích thước tệp

    // Hàm khởi tạo cho DigitalProduct
    public DigitalProduct(int productId, String name, double price, int quantity, double fileSize) {
        super(productId, name, price, quantity); // Gọi hàm khởi tạo của lớp cha (Product)
        this.fileSize = fileSize; // Gán giá trị kích thước tệp
    }

    // Hàm thiết lập kích thước tệp
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    // Hàm lấy kích thước tệp
    public double getFileSize() {
        return fileSize;
    }

    @Override
    public boolean updateQuantity(int amount) {
        return super.updateQuantity(amount); // Gọi hàm updateQuantity của lớp cha (Product)
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", File Size: " + fileSize + " MB"; // Gọi hàm getInfo của lớp cha và thêm thông tin kích thước tệp
    }
}
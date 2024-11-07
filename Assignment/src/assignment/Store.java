package assignment;

import java.util.List;

public interface Store {
    void addProduct(Product product); // Phương thức thêm sản phẩm vào cửa hàng
    Order createOrder(Customer customer); // Phương thức tạo đơn hàng mới cho khách hàng
    List<Order> getAllOrders(); // Phương thức lấy danh sách tất cả các đơn hàng
    List<Product> getProducts(); // Phương thức lấy danh sách tất cả các sản phẩm
}
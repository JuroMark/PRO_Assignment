package assignment;


   import java.util.List;

public interface Store {
    void addProduct(Product product);
    Order createOrder(Customer customer);
    List<Order> getAllOrders();
    List<Product> getProducts();
}


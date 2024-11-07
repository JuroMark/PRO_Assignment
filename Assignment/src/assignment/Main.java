package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Main implements Store {
    private List<Product> products = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Main store = new Main(); 
        Scanner scanner = new Scanner(System.in);

        // Thêm sản phẩm vào cửa hàng
        store.addProduct(new Product(1, "Laptop", 1000.0, 10));
        store.addProduct(new Product(2, "Smartphone", 500.0, 20));
        store.addProduct(new Product(3, "Tablet", 300.0, 15));
        store.addProduct(new DigitalProduct(4, "E-book",20.0,49,1.5));

        boolean exit = false;
        while (!exit) {
            printMenu(); // In menu chính
            int choice = getChoice(scanner); // Lấy lựa chọn từ người dùng

            switch (choice) {
                case 1:
                    createNewOrder(store, scanner); // Tạo đơn hàng mới
                    break;
                case 2:
                    printOrders(store); // In danh sách đơn hàng
                    break;
                case 3:
                    saveOrdersToFile(store, scanner); // Ghi đơn hàng vào file
                    break;
                case 4:
                    System.out.println("Chương trình kết thúc. Hẹn gặp lại!");
                    exit = true; // Thoát chương trình
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }

        scanner.close(); // Đóng scanner
    }

    private static void printMenu() {
        System.out.println("\n====== MENU CHÍNH ======");
        System.out.println("1. Tạo mới đơn hàng");
        System.out.println("2. In danh sách đơn hàng của cửa hàng");
        System.out.println("3. Ghi đơn hàng vào file");
        System.out.println("4. Thoát");
        System.out.println("========================");
        System.out.print("Xin mời chọn chức năng: ");
    }

    private static int getChoice(Scanner scanner) {
        int choice = -1;
        try {
            choice = Integer.parseInt(scanner.nextLine()); // Lấy lựa chọn từ người dùng
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số hợp lệ.");
        }
        return choice;
    }

    private static void createNewOrder(Store store, Scanner scanner) {
        System.out.println("\n*** TẠO ĐƠN HÀNG MỚI ***");

        // Lấy thông tin khách hàng
        System.out.print("Nhập tên khách hàng: ");
        String name = scanner.nextLine();
        System.out.print("Nhập email khách hàng: ");
        String email = scanner.nextLine();
        Customer customer = new Customer(store.getAllOrders().size() + 1, name, email); // Tạo khách hàng mới
        Order order = store.createOrder(customer); // Tạo đơn hàng mới

        // Thêm sản phẩm vào đơn hàng
        while (true) {
            System.out.println("\nDanh sách sản phẩm có trong cửa hàng:");
            for (Product product : store.getProducts()) {
                System.out.println(product.getInfo());
            }

            System.out.print("Nhập ID sản phẩm (hoặc 0 để hoàn thành đơn hàng): ");
            int productId = Integer.parseInt(scanner.nextLine());
            if (productId == 0) {
                break;
            }

            System.out.print("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Product selectedProduct = null;
            for (Product product : store.getProducts()) {
                if (product.getProductId() == productId) {
                    selectedProduct = product;
                    break;
                }
            }

            if (selectedProduct != null) {
                order.addProduct(selectedProduct, quantity); // Thêm sản phẩm vào đơn hàng
            } else {
                System.out.println("Không tìm thấy sản phẩm.");
            }
        }

        System.out.println("\nĐơn hàng đã được tạo thành công.");
    }

    private static void printOrders(Store store) {
        System.out.println("\n*** DANH SÁCH ĐƠN HÀNG ***");
        for (Order order : store.getAllOrders()) {
            System.out.println(order.getOrderDetails());
            System.out.println("-----------------------------");
        }
    }

    private static void saveOrdersToFile(Store store, Scanner scanner) {
        System.out.print("\nNhập tên file để lưu danh sách đơn hàng: ");
        String filename = scanner.nextLine();
        for (Order order : store.getAllOrders()) {
            order.saveToFile(filename); // Ghi đơn hàng vào file
        }
    }


    @Override
    public Order createOrder(Customer customer) {
        Order newOrder = new Order(orders.size() + 1, customer); // Tạo đơn hàng mới
        orders.add(newOrder); // Thêm đơn hàng vào danh sách
        return newOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        return orders; // Trả về danh sách đơn hàng
    }

    @Override
    public List<Product> getProducts() {
        return products; // Trả về danh sách sản phẩm
    }

    @Override
    public void addProduct(Product product) {
        products.add(product); // Thêm sản phẩm vào danh sách
    }
}
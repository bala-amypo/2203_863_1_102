// UserService.java
public interface UserService {
    User register(User user);
    User findByEmail(String email);
}

// ProductService.java
public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();
}

// WarrantyService.java
public interface WarrantyService {
    Warranty registerWarranty(Long userId, Long productId, Warranty warranty);
    Warranty getWarranty(Long warrantyId);
    List<Warranty> getUserWarranties(Long userId);
}

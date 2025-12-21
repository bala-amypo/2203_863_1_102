@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    
    public Product addProduct(Product product) {
        if (product.getModelNumber() == null || product.getModelNumber().isBlank()) {
            throw new IllegalArgumentException("Model number required");
        }
        if (product.getCategory() == null || product.getCategory().isBlank()) {
            throw new IllegalArgumentException("Category required");
        }
        return productRepository.save(product);
    }
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}


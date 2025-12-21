@Service
public class WarrantyServiceImpl implements WarrantyService {
    private final WarrantyRepository warrantyRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    
    public Warranty registerWarranty(Long userId, Long productId, Warranty warranty) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        
        if (warranty.getExpiryDate().isBefore(warranty.getPurchaseDate()) || 
            warranty.getExpiryDate().isEqual(warranty.getPurchaseDate())) {
            throw new IllegalArgumentException("Expiry date must be after purchase date");
        }
        
        if (warrantyRepository.existsBySerialNumber(warranty.getSerialNumber())) {
            throw new IllegalArgumentException("Serial number must be unique");
        }
        
        warranty.setUser(user);
        warranty.setProduct(product);
        return warrantyRepository.save(warranty);
    }
    
    public Warranty getWarranty(Long warrantyId) {
        return warrantyRepository.findById(warrantyId)
            .orElseThrow(() -> new ResourceNotFoundException("Warranty not found"));
    }
    
    public List<Warranty> getUserWarranties(Long userId) {
        return warrantyRepository.findByUserId(userId);
    }
}

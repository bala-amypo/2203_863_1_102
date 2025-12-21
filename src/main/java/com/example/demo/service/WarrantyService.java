public interface WarrantyService {
    Warranty registerWarranty(Long userId, Long productId, Warranty warranty);
    Warranty getWarranty(Long warrantyId);
    List<Warranty> getUserWarranties(Long userId);
}

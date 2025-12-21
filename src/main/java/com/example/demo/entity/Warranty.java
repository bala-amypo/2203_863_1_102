package com.example.demo.entity;

public class Warranty {
    private Long id;
    private Long userId;
    private Long productId;
    private String warrantyNumber;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }

    public String getWarrantyNumber() { return warrantyNumber; }
    public void setWarrantyNumber(String warrantyNumber) { this.warrantyNumber = warrantyNumber; }
}

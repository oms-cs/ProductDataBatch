package com.ecom.airy.batch.model;

import java.time.LocalDateTime;

public class Product {
    // uniq_id,crawl_timestamp,product_url,product_name,product_category_tree,pid,retail_price,discounted_price
// ,image,is_FK_Advantage_product,description,product_rating,overall_rating,brand,product_specifications
    private String uniqId;
    private String timestamp;
    private String productUrl;
    private String productName;

    private String productCategoryTree;

    private String productId;

    private Double retailPrice;

    private Double discountedPrice;

    private String image;

    private String isFKAdvantageProduct;

    private String description;

    private String productRating;

    private String overallRating;

    private String brand;

    private String productSpecifications;

    public Product(String uniqId, String timestamp, String productUrl, String productName, String productCategoryTree, String productId, Double retailPrice, Double discountedPrice, String image, String isFKAdvantageProduct, String description, String productRating, String overallRating, String brand, String productSpecifications) {
        this.uniqId = uniqId;
        this.timestamp = timestamp;
        this.productUrl = productUrl;
        this.productName = productName;
        this.productCategoryTree = productCategoryTree;
        this.productId = productId;
        this.retailPrice = retailPrice;
        this.discountedPrice = discountedPrice;
        this.image = image;
        this.isFKAdvantageProduct = isFKAdvantageProduct;
        this.description = description;
        this.productRating = productRating;
        this.overallRating = overallRating;
        this.brand = brand;
        this.productSpecifications = productSpecifications;
    }

    public String getUniqId() {
        return uniqId;
    }

    public void setUniqId(String uniqId) {
        this.uniqId = uniqId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategoryTree() {
        return productCategoryTree;
    }

    public void setProductCategoryTree(String productCategoryTree) {
        this.productCategoryTree = productCategoryTree;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Double getDiscountedPrice() {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice) {
        this.discountedPrice = discountedPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIsFKAdvantageProduct() {
        return isFKAdvantageProduct;
    }

    public void setIsFKAdvantageProduct(String isFKAdvantageProduct) {
        this.isFKAdvantageProduct = isFKAdvantageProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    public String getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(String overallRating) {
        this.overallRating = overallRating;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductSpecifications() {
        return productSpecifications;
    }

    public void setProductSpecifications(String productSpecifications) {
        this.productSpecifications = productSpecifications;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "uniqId='" + uniqId + '\'' +
                ", productName='" + productName + '\'' +
                ", timestamp=" + timestamp +
                ", productUrl='" + productUrl + '\'' +
                ", productCategoryTree='" + productCategoryTree + '\'' +
                ", productId='" + productId + '\'' +
                ", retailPrice=" + retailPrice +
                ", discountedPrice=" + discountedPrice +
                ", productRating=" + productRating +
                ", overallRating=" + overallRating +
                ", brand='" + brand + '\'' +
                ", productSpecifications='" + productSpecifications + '\'' +
                ", image='" + image + '\'' +
                ", isFKAdvantageProduct=" + isFKAdvantageProduct +
                ", description='" + description + '\'' +
                '}';
    }
}

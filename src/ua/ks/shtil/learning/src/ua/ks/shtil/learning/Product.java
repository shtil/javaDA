package ua.ks.shtil.learning.src.ua.ks.shtil.learning;

import java.util.UUID;

/**
 * Created by shtil on 04.06.14.
 */
public class Product {

    private UUID id;
    private String name;
    private String description;
    private int price;
    private int warranty;
    private String url;
    private ClassifierWeightsType classifierWeightsType;
    private Category category;


    public UUID getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWarranty() {
        return warranty;
    }

    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ClassifierWeightsType getClassifierWeightsType() {
        return classifierWeightsType;
    }

    public void setClassifierWeightsType(ClassifierWeightsType classifierWeightsType) {
        this.classifierWeightsType = classifierWeightsType;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
        id = UUID.randomUUID();
    }


    @Override
    public String toString() {
        return "Product{" +
                " id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", warranty=" + warranty +
                ", url='" + url + '\'' +
                ", classifierWeightsType=" + classifierWeightsType +
                ", category=" + category +
                "}\n";
    }


}

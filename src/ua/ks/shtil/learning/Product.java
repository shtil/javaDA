package ua.ks.shtil.learning;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by shtil on 04.06.14.
 */
public class Product implements Serializable{

    private UUID id;
    private String name;
    private String description;
    private int price;
    private int warranty;
    private String url;
    private ClassifierWeightsType classifierWeightsType;
    private Category category;

    private static List<Product> productList = new ArrayList<>();


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

    public Product( String name, String description, int price, int warranty, String url, ClassifierWeightsType classifierWeightsType, Category category) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.warranty = warranty;
        this.url = url;
        this.classifierWeightsType = classifierWeightsType;
        this.category = category;

        this.productList.add(this);
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

    public static void showAllProducts(){
        for (Product product:productList){
            System.out.println(product);
        }
    }

    public static void saveToFile(){

        String path = getFilePath();

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(path))) {
            for (Product product:productList) {
                bufferedWriter.write(String.valueOf(product));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromFile(){
        String path = getFilePath();

        try (BufferedReader ois =
                     new BufferedReader(
                             new FileReader(path))) {
            //productList = (List<Product>) ois.readObject();
            while (true){

             //   productList.add((Product)ois.readLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        showAllProducts();

    }


    private static String getFilePath() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("settings.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties.getProperty("product.file");
    }



}

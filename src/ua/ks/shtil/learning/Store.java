package ua.ks.shtil.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by shtil on 04.06.14.
 */
public class Store {

    private final  static  Integer DEFAULT_COUNT = 10;

    private UUID id;
    private String address;
    private List<Product> products;
    private HashMap<String, Integer> hashMap;


    public Store(String address) {
        this.id = UUID.randomUUID();
        this.address = address;
        this.products = new ArrayList<Product>();
        this.hashMap = new HashMap<String, Integer>();
       // System.out.println("with parameter");
    }

    public String getAddress() {
        return address;
    }

    public void addProduct (Product product){
        products.add(product);

        updateHashMap (product, null);
    }
    public void addProduct (Product product, Integer count){
        products.add(product);

        updateHashMap (product, count);
    }

    private void updateHashMap(Product product, Integer count) {

        if (!hashMap.containsKey(product.getName())){
             if (count!=null){
                 hashMap.put(product.getName(), count);
             } else {
                 hashMap.put(product.getName(), DEFAULT_COUNT);
             }
        } else {
            Integer pCount = hashMap.get(product.getName());
            hashMap.put(product.getName(), pCount+1);
        }
    }

    public  void removeFromStore(Product product){

        if (hashMap.containsKey(product.getName())){
            Integer pCount = hashMap.get(product.getName());
            if(pCount>1) {
                hashMap.put(product.getName(), pCount - 1);
            } else {
                if (pCount==1) {
                    hashMap.remove(product.getName());
                }
            }
        } else {
            //обработка исключения, нет такого продукта на складе
        }

    }

    public  int getProductsCount (Product product){
        int count = 0;
        if (hashMap.containsKey(product.getName())){
           count =  hashMap.get(product.getName());
        }
        return count;
    }

    public  int getProductsCount(Category category){
        int count = 0;

        for (Product product: products){
            if(product.getCategory().equals(category)){
                count = count +1;
            }
        }
        return count;
    }

    @Override
    public String toString() {

        StringBuilder productsName = new StringBuilder();
        StringBuilder productsCategory = new StringBuilder();

        for (Product product: products){
            productsName.append(product.getName() + ", ");
            productsCategory.append(product.getCategory() + ", ");
        }

        return "Store{\n" +
                "id=" + id +
                "\naddress= '" + address + "\'" +
                "\nproducts= " + productsName +
                "\ncategory= " + productsCategory +
                "\n}";
    }
}

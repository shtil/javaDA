package ua.ks.shtil.learning;

import java.io.*;
import java.util.*;
import java.io.FileOutputStream;

/**
 * Created by shtil on 04.06.14.
 */
public class Store {

    private final  static  Integer DEFAULT_COUNT = 10;

    private UUID id;
    private String address;
    private List<Product> products;
    private HashMap<String, Integer> hashMap;

    private static  List<Store> storeList = new ArrayList<>();

    public Store(String address) {
        this.id = UUID.randomUUID();
        this.address = address;
        this.products = new ArrayList<Product>();
        this.hashMap = new HashMap<String, Integer>();
        System.out.println("with parameter");

        storeList.add(this);
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

    public  void removeFromStore(Product product) throws Exception{

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
            throw new Exception("No products on store");
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
        return "Store{" +
                "id=" + id +
                ", address='" + address + "\'\n" +
                ", products=" + products + "\n"+
                ", hashMap=" + hashMap +
                "} \n";
    }

    public String showStore(){

        StringBuilder productsName = new StringBuilder();
        StringBuilder productsCategory = new StringBuilder();

        for (Product product: products){
            if (product.getName()!=null) {
                productsName.append(product.getName() + ", ");
            }
            if (product.getCategory()!=null) {
                productsCategory.append(product.getCategory() + ", ");
            }
        }

        return "Store{\n" +
                "id=" + id +
                "\naddress= '" + address + "\'" +
                "\nproducts= " + productsName +
                "\ncategory= " + productsCategory +
                "\n}";
    }

    public static void showAllStores(){

        System.out.println(" Details from all stores");

    }

    public void saveStore(){

        try (
                FileOutputStream fout = new FileOutputStream("Stores.txt");
                DataOutputStream dout = new DataOutputStream(fout);
        ){
            dout.writeUTF(String.valueOf(id));
            dout.writeUTF(address);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void loadAllStores(){

    }

    public static void saveToFileAsText() {

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("settings.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String path = properties.getProperty("store.file");

        try (OutputStreamWriter fw =
                     new OutputStreamWriter(
                             new FileOutputStream(path))) {
            fw.write("");
            storeList.size();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}

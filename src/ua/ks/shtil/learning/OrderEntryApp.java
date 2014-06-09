package ua.ks.shtil.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static ua.ks.shtil.learning.Product.saveToFile;
import static ua.ks.shtil.learning.Product.showAllProducts;
import static ua.ks.shtil.learning.Store.showAllStores;

public class OrderEntryApp {
	public static void main(String[] args) {
		System.out.println("Order Entry Application");

		Customer client = new Customer();
        client.setName("pupkin vasay");
        /*
        Customer c1 = new Customer();
        c1.setName("sdfsdfsdf");
		System.out.println("Customer: " + c);
        System.out.println("Customer2: " + c1);
		//TODO create company and individual customer, display them in console.

        Customer c3 = new Individual();
        c3.setName("333333333333");
        System.out.println("Customer: " + c3);*/

        Category cars = new Category("cars");
     /*   Category moto = new Category("moto");

        Category carOpel = new Category("opel",cars);
        Category carNissan = new Category("nissan");

        Category motoSuzuki = new Category("suzuki", moto);
        moto.addSubCategory( new Category("kawasaki"));
        Category cat3 = new Category("honda", moto);

        System.out.println(cars);
        System.out.println(moto);

*/
        Product product1 = new Product("TV","Description", 12, 24,"http://shop.ua/1.php",ClassifierWeightsType.BIG, cars);
/*        product1.setName("TV");
        product1.setDescription("Sale for all tv");
        product1.setPrice(1200);
        product1.setWarranty(12);
        product1.setUrl("http://shop.ua/1.php");
        product1.setClassifierWeightsType(ClassifierWeightsType.BIG);
        product1.setCategory(cars);*/



/*        Product product2 = new Product();
        product2.setName("Car");*/

        Product product2 = new Product("Car","Description od car", 1, 36,"http://shop.ua/2.php",ClassifierWeightsType.BIG, cars);

/*        Product product3 = new Product();
        product3.setName("Moto");*/

        Product product3 = new Product("MOTO","Description of moto", 1, 24,"http://shop.ua/3.php",ClassifierWeightsType.STANDARD, cars);
/*

        Product product4 = new Product();
        product4.setName("Moto");*/

        Product product4 = new Product("Suzuki","Description of suzuki", 1, 24,"http://shop.ua/4.php",ClassifierWeightsType.BIG, cars);



        System.out.println("======= Products ==========");
        System.out.println(product1);
        System.out.println(product2);
        System.out.println(product3);
        System.out.println(product4);


        OrderPosition op1 = new OrderPosition(product1,12, 1);
        OrderPosition op2 = new OrderPosition(product2,13, 2);
        OrderPosition op3 = new OrderPosition(product3,14, 3);
        OrderPosition op4 = new OrderPosition(product4,15, 4);

        System.out.println("======= OrderPosition ==========");

        System.out.println(op1);
        System.out.println(op2);
        System.out.println(op3);
        System.out.println(op4);


        Order order = new Order();
        order.setClient(client);
        order.setDeliveryType(DeliveryType.GROUND);
        order.setOrderStatus(OrderStatus.NEW);

        try {
            order.setOrderPosition(op1);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        try {
            order.setOrderPosition(op2);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        try {
            order.setOrderPosition(op3);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        try {
            order.setOrderPosition(op4);
        }catch (Exception e){
            System.out.println(e.toString());
        }




        System.out.println("======= Order ==========");
        System.out.println(order);

        order.saveToFileAsText();



     /*   Store store = new Store("kherson");
        store.addProduct(product1);
        store.addProduct(product2, 50);
        store.addProduct(product3);
        store.addProduct(product4);

        Store store1 = new Store("ZP");
        store1.addProduct(product1);
        store.addProduct(product4);

         System.out.println(store);

        System.out.println("#-----------------------------#");
        System.out.println(store.showStore());
        System.out.println("#-----------------------------#");

        System.out.println(store.getProductsCount(product1));
        System.out.println(store.getProductsCount(product2));
        System.out.println(store.getProductsCount(product3));
        System.out.println(store.getProductsCount(product4));

        for (int i = 0; i < 60; i++) {
            store.removeFromStore(product2);
        }

        System.out.println("--------------------------");

        System.out.println(store.getProductsCount(product1));
        System.out.println(store.getProductsCount(product2));
        System.out.println(store.getProductsCount(product3));
        System.out.println(store.getProductsCount(product4));


        System.out.println("##########################");

       store.showAllStores();
*/

        mainMenu();


    }

    private static void mainMenu() {
        System.out.println("#=======Welcome=========#");

        System.out.println("Choice type for work:\n" +
                "1- Store\n" +
                "2- Category\n" +
                "3- Product\n" +
                "4- OrderPosition\n" +
                "5- Order\n" +
                "9- exit\n");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        int i = 0;
        try {
             i = Integer.parseInt(br.readLine());
        } catch (IOException|NumberFormatException e) {
           // e.printStackTrace();
            System.out.println("Write correct choice!");
            mainMenu();
        }

        switch (i){
            case 1:
                    storeMenu();
                break;
            case 2:
                    categoryMenu();
                break;
            case 3:
                    productMenu();
                break;
            case 4:
                break;
            case 5:
                break;
            case 9:
                    System.exit(0);
                break;
            default:
                break;
        }
    }

    private static void productMenu() {
        System.out.println( "1- Show all products\n" +
                "2- New product\n" +
                "3- Save product\n" +
                "4- Remove product\n" +
                "8- Main menu" +
                "9- exit\n");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        int i = 0;
        try {
            i = Integer.parseInt(br.readLine());
        } catch (IOException|NumberFormatException e) {
            // e.printStackTrace();
            System.out.println("Write correct choice!");
            storeMenu();
        }

        switch (i){
            case 1:
                showAllProducts();
                break;
            case 2:
                break;
            case 3:
                saveToFile();
                break;
            case 4:
                break;
            case 8:
                mainMenu();
                break;
            case 9:
                System.exit(0);
                break;
            default:
                break;
        }

        productMenu();
    }



    private static void categoryMenu() {

    }

    private static void storeMenu() {
        System.out.println( "1- Show all stores\n" +
                "2- New store\n" +
                "3- Change store\n" +
                "4- Remove store\n" +
                "8- Main menu" +
                "9- exit\n");


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = null;

        int i = 0;
        try {
            i = Integer.parseInt(br.readLine());
        } catch (IOException|NumberFormatException e) {
            // e.printStackTrace();
            System.out.println("Write correct choice!");
            storeMenu();
        }

        switch (i){
            case 1:
                showAllStores();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 8:
                break;
            case 9:
                System.exit(0);
                break;
            default:
                break;
        }
    }
}

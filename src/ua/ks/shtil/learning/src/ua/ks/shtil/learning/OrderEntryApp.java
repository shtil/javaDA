package ua.ks.shtil.learning.src.ua.ks.shtil.learning;

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
        Product product1 = new Product();
        product1.setName("TV");
        product1.setDescription("Sale for all tv");
        product1.setPrice(1200);
        product1.setWarranty(12);
        product1.setUrl("http://shop.ua/1.php");
        product1.setClassifierWeightsType(ClassifierWeightsType.BIG);
        product1.setCategory(cars);



        Product product2 = new Product();
        product2.setName("Car");

        Product product3 = new Product();
        product3.setName("Moto");

        Product product4 = new Product();
        product4.setName("Moto");

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


	}
}

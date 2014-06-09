package ua.ks.shtil.learning;

public class OrderEntryApp {
	public static void main(String[] args) {
		System.out.println("Order Entry Application");

	/*	Customer c = new Customer();
        c.setName("pupkin vasay");
        Customer c1 = new Customer();
        c1.setName("sdfsdfsdf");
		System.out.println("Customer: " + c);
        System.out.println("Customer2: " + c1);
		//TODO create company and individual customer, display them in console.

        Customer c3 = new Individual();
        c3.setName("333333333333");
        System.out.println("Customer: " + c3);*/

        Category cars = new Category("cars");
        Category moto = new Category("moto");

        Category carOpel = new Category("opel",cars);
        Category carNissan = new Category("nissan");

        Category motoSuzuki = new Category("suzuki", moto);
        moto.addSubCategory(new Category("kawasaki"));
        Category cat3 = new Category("honda", moto);

        System.out.println(cars);
        System.out.println(moto);


        Product product1 = new Product();
        product1.setName("TV");
        product1.setDescription("Sale for all tv");
        product1.setPrice(1200);
        product1.setCategory(moto);

        Product product2 = new Product();
        product2.setName("Car");

        Product product3 = new Product();
        product3.setName("Moto");

        Product product4 = new Product();
        product4.setName("Moto");



        Store store = new Store("kherson");
        store.addProduct(product1);
        store.addProduct(product2, 50);
        store.addProduct(product3);
        store.addProduct(product4);

         System.out.println(store);

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

	}
}

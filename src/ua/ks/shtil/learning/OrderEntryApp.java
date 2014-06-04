package ua.ks.shtil.learning;

public class OrderEntryApp {
	public static void main(String[] args) {
		System.out.println("Order Entry Application");

		Customer c = new Customer();
        c.setName("pupkin vasay");
        Customer c1 = new Customer();
        c1.setName("sdfsdfsdf");
		System.out.println("Customer: " + c);
        System.out.println("Customer2: " + c1);
		//TODO create company and individual customer, display them in console.

        Customer c3 = new Individual();
        c3.setName("333333333333");
        System.out.println("Customer: " + c3);
	}
}

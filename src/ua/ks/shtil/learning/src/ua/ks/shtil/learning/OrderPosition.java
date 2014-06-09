package ua.ks.shtil.learning.src.ua.ks.shtil.learning;

import java.util.UUID;

/**
 * Каждая позиция заказа содержит товар, цену, количество и категорию товара. Категория может быть составной –
 * то есть состоять из подкатегорий, либо может быть атомарной.
 */
public class OrderPosition {

	private int lineNo;
	private float price;
	private int qty;

    private Product product;
    private UUID id;

    public UUID getId() {
        return id;
    }

    //TODO Add reference to category
   // private  Category category;

	public OrderPosition( Product product, float price, int qty) {
		this.product = product;
		this.price = price;
		this.qty = qty;
        this.id = UUID.randomUUID();
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQty(int qty) {
		this.qty = qty;
	}

    @Override
    public String toString() {
        return "OrderPosition{" +
                "id ="+ id +
                "price=" + price +
                ", qty=" + qty +
                ", product=" + product +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        OrderPosition op = (OrderPosition)obj;
        return this.getProduct() == op.getProduct();
    }
}

package ua.ks.shtil.learning;

/**
 * Каждая позиция заказа содержит товар, цену, количество и категорию товара. Категория может быть составной –
 * то есть состоять из подкатегорий, либо может быть атомарной.
 */
public class OrderPosition {

	private int lineNo;
	private float price;
	private int qty;
	//TODO Add reference to category

	public OrderPosition(int lineNo, float price, int qty) {
		this.lineNo = lineNo;
		this.price = price;
		this.qty = qty;
	}

	public int getLineNo() {
		return lineNo;
	}

	public void setLineNo(int lineNo) {
		this.lineNo = lineNo;
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

	public void setQty(int qty) {
		this.qty = qty;
	}
}

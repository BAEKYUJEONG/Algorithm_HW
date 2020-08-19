import java.io.Serializable;

public  class Product implements Serializable{
	private String serial;
	private String name;
	private int price;
	private int stock;
	public Product(String serial, String name, int price, int stock) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String toString() {
		return "제품번호 = " + serial + "\t| 제품명 = " + name + "|\t 가격 = " + price + "|\t 재고수량 = " + stock;
	}
	
}

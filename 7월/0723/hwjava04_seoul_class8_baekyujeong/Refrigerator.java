package hwjava04_seoul_class8_baekyujeong;

public class Refrigerator {
	private String num;
	private String name;
	private int price;
	private int stock;
	private int capacity;
	
	public Refrigerator(String num, String name, int price, int stock, int capacity) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.capacity = capacity;
	}
	
	public String getNum() {
		return num;
	}
	
	public void setNum(String num) {
		this.num = num;
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
	
	public int getCapacity() {
		return capacity;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		String str = num+"\t|"+name+"\t|"+price+"\t|"+stock+"\t|"+capacity+"L";
		return str;
	}
}

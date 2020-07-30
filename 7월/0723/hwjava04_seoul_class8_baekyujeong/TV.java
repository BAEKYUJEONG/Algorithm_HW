package hwjava04_seoul_class8_baekyujeong;

public class TV {
	private String num;
	private String name;
	private int price;
	private int stock;
	private int inch;
	private String display;
	
	public TV(String num, String name, int price, int stock, int inch, String display) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.inch = inch;
		this.display = display;
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
	
	public int getInch() {
		return inch;
	}
	
	public void setInch(int inch) {
		this.inch = inch;
	}
	
	public String getDisplay() {
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}
	
	@Override
	public String toString() {
		String str = num+"\t|"+name+"\t|"+price+"\t|"+stock+"\t|"+inch+"ÀÎÄ¡"+"\t|"+display;
		return str;
	}
}

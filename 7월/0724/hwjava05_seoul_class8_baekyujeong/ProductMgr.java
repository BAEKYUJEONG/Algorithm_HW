package hwjava05_seoul_class8_baekyujeong;

public class ProductMgr {
	
	private Product [] products = new Product[100];
	private int index;
	
	private static ProductMgr instance;
	
	private ProductMgr() {}
	
	public static ProductMgr getInstance() {
		if(instance == null) {
			instance = new ProductMgr();
		}
		return instance;
	}
	
	public void add(Product p) {
		this.products[index] = p;
		index++;
	}
	
	public Product[] list() {
		return products;
	}
	
	public Product[] list(int num) {
		Product[] temp;
		int size = 0;
		int midx = 0;
		for(int i=0; i<index; ++i) {
			if(products[i].getNum() == num) {
				size++;
			}
		}
		temp = new Product[size];
		for(int i=0; i<index; ++i) {
			if(products[i].getNum() == num) {
				temp[midx] = products[i];
				midx++;
			}
		}
		return temp;
	}
	
	public void delete(int num) {
		for(int i=0; i<index; ++i) {
			if(products[i].getNum() == num) {
				products[i] = products[index-1];
				index--;
				break;
			}
		}
	}
	
	public Product[] priceList(int price) {
		Product [] temp;
		int size = 0;
		int midx = 0;
		for(int i=0; i<index; ++i) {
			if(products[i].getPrice()<=price) {
				size++;
			}
		}
		temp = new Product[size];
		for(int i=0; i<index; ++i) {
			if(products[i].getPrice()<=price) {
				temp[midx] = products[i];
				midx++;
			}
		}
		return temp;
	}

	public int getSize() {
		return this.index;
	}

}
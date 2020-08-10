import java.util.Arrays;

public class ProductMgr {
	private Product [] products  = new Product[100];
	private int index;
	
	public void add(Product p) {
		products[index] = p;
		index++;
	}
	
	public Product[] searchAll() {
		Product [] temp = Arrays.copyOf(products, index);
		return temp;
	}
	
	public Product searchNum(int num) {
		for(Product p : products) {
			if(p.getNum()==num) {
				return p;
			}
		}
		return null;
	}
	
	public Product [] searchName(String name) {
		int cnt = 0;
		for(int i=0; i<index; i++) {
			if(products[i].getName().contains(name)) {
				cnt++;
			}
		}
		Product [] temp = new Product[cnt];
		cnt = 0;
		for(int i=0; i<index; i++) {
			if(products[i].getName().contains(name)) {
				temp[cnt++] = products[i];
			}
		}
		return temp;
	}
	
	public Product [] searchTV() {
		int cnt = 0;
		for(int i=0; i<index; i++) {
			if(products[i] instanceof TV) {
				cnt++;
			}
		}
		Product [] temp = new Product[cnt];
		cnt = 0;
		for(int i=0; i<index; i++) {
			if(products[i] instanceof TV) {
				temp[cnt++] = products[i];
			}
		}
		return temp;
	}
	
	public Product [] searchRefrigerator() {
		int cnt = 0;
		for(int i=0; i<index; i++) {
			if(products[i] instanceof Refrigerator) {
				cnt++;
			}
		}
		Product [] temp = new Product[cnt];
		cnt = 0;
		for(int i=0; i<index; i++) {
			if(products[i] instanceof Refrigerator) {
				temp[cnt++] = products[i];
			}
		}
		return temp;
	}

	public boolean delete(int num) {
		for(int i=0; i<index; i++) {
			if(products[i].getNum()==num) {
				products[i] = products[index-1];
				index--;
				return true;
			}
		}
		return false;
	}
	
	public int searchTotalPrice() {
		int total = 0;
		for(int i=0; i<index; i++) {
			total += products[i].getPrice()*products[i].getStock();
		}
		return total;
	}
}

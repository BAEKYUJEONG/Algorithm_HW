import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	ArrayList<Product> products = new ArrayList<>();
	ArrayList<Refrigerator> refrigerator = new ArrayList<>();
	ArrayList<TV> TV = new ArrayList<>();
	
	public void add(Product p) {
		products.add(p);
	}
	
	public ArrayList<Product> searchAll() {
		return products;
	}
	
	public Product searchNum(int num) {
		for(Product p : products) {
			if(p.getNum()==num) {
				return p;
			}
		}
		return null;
	}
	
	public ArrayList<Product> searchName(String name) {
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getName().contains(name)) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Product> searchTV() {
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i) instanceof TV) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Product> searchRefrigerator() {
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i) instanceof Refrigerator) {
				temp.add(products.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Product> search400capacity() {
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0; i<refrigerator.size(); i++) {
			if(refrigerator.get(i).getCapacity() >= 400) {
				temp.add(refrigerator.get(i));
			}
		}
		return temp;
	}
	
	public ArrayList<Product> search50inch() {
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0; i<TV.size(); i++) {
			if(TV.get(i).getInch() >= 50) {
				temp.add(TV.get(i));
			}
		}
		return temp;
	}
	
	public boolean modifyPrice(int num, int price) {
		Product p = searchNum(num);
		if(p != null) {
			p.setPrice(price);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean delete(int num) {
		ArrayList<Product> temp = new ArrayList<>();
		for(int i=0; i<products.size(); i++) {
			if(products.get(i).getNum() != num) {
				temp.add(products.get(i));
				products = temp;
				return true;
			}
		}
		return false;
	}
	
	public int searchTotalPrice() {
		int total = 0;
		for(int i=0; i<products.size(); i++) {
			total += products.get(i).getPrice()*products.get(i).getStock();
		}
		return total;
	}
}

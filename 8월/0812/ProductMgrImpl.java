import java.util.ArrayList;

public class ProductMgrImpl implements IProductMgr {
	ArrayList<Product> products = new ArrayList<>();
	ArrayList<Refrigerator> refrigerator = new ArrayList<>();
	ArrayList<TV> TV = new ArrayList<>();
	
	public void add(Product p) throws DuplicateException{
		boolean flag = false;
		products.add(p);
		if(!flag) throw new DuplicateException();
		
	}
	
	public ArrayList<Product> searchAll() {
		return products;
	}
	
	public Product searchNum(int num) throws CodeNotFoundException {
		boolean flag = false;
		for(Product p : products) {
			if(p.getNum()==num) {
				flag = true;
				return p;
			}
			if(!flag) throw new CodeNotFoundException();
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
	
	public ArrayList<Product> search400capacity() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<>();
		boolean flag = false;
		for(int i=0; i<refrigerator.size(); i++) {
			if(refrigerator.get(i).getCapacity() >= 400) {
				flag = true;
				temp.add(refrigerator.get(i));
			}
			if(!flag) throw new ProductNotFoundException();
		}
		return temp;
	}
	
	public ArrayList<Product> search50inch() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<>();
		boolean flag = false;
		for(int i=0; i<TV.size(); i++) {
			if(TV.get(i).getInch() >= 50) {
				flag = true;
				temp.add(TV.get(i));
			}
			if(!flag) throw new ProductNotFoundException();
		}
		return temp;
	}
	
	public boolean modifyPrice(int num, int price) throws CodeNotFoundException {
		boolean flag = false;
		Product p = searchNum(num);
		if(p != null) {
			flag = true;
			p.setPrice(price);
			return flag;
		}else {
			if(!flag) throw new CodeNotFoundException();
			return flag;
		}
	}
	
	public boolean delete(int num) {
		ArrayList<Product> temp = new ArrayList<>();
		{
			for(int i=0; i<products.size(); i++) {
				if(products.get(i).getNum() != num) {
					temp.add(products.get(i));
					products = temp;
				}
			}
			return true;
		}
	}
	
	public int searchTotalPrice() {
		int total = 0;
		for(int i=0; i<products.size(); i++) {
			total += products.get(i).getPrice()*products.get(i).getStock();
		}
		return total;
	}
}

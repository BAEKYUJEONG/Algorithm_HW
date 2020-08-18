import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p) throws DuplicateException;
	public ArrayList<Product> searchAll();
	public Product searchNum(int num) throws CodeNotFoundException;
	public ArrayList<Product> searchName(String name);
	public ArrayList<Product> searchTV();
	public ArrayList<Product> searchRefrigerator();
	public ArrayList<Product> search400capacity() throws ProductNotFoundException;
	public ArrayList<Product> search50inch() throws ProductNotFoundException;
	public boolean modifyPrice(int num, int price) throws CodeNotFoundException;
	public boolean delete(int num);
	public int searchTotalPrice();

}

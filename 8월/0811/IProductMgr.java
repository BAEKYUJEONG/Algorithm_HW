import java.util.ArrayList;

public interface IProductMgr {
	public void add(Product p);
	public ArrayList<Product> searchAll();
	public Product searchNum(int num);
	public ArrayList<Product> searchName(String name);
	public ArrayList<Product> searchTV();
	public ArrayList<Product> searchRefrigerator();
	public ArrayList<Product> search400capacity();
	public ArrayList<Product> search50inch();
	public boolean modifyPrice(int num, int price);
	public boolean delete(int num);
	public int searchTotalPrice();

}

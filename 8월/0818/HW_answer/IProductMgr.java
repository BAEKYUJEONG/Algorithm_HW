import java.util.ArrayList;

public interface IProductMgr {
	void add(Product p) throws DuplicateException;
	ArrayList<Product> total();
	Product FindBySerial(String serial) throws CodeNotFoundException;
	ArrayList<Product> FindByName(String name);
	ArrayList<Product> FindTV();
	ArrayList<Product> FindRefri();
	ArrayList<Product> FindRefriWith400vol() throws ProductNotFoundException;
	ArrayList<Product> FindTVWith50size() throws ProductNotFoundException;
	void change(String serial, int price) throws CodeNotFoundException;
	void delete(String serial) throws CodeNotFoundException;
	long sum();
	void close();
	void open();
}

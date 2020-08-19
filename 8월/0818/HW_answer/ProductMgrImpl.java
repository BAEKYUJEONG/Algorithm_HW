import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
class DuplicateException extends Exception{
//	public String toString() {
//		return "중복 발생!";
//	}
	public DuplicateException() {
		super("중복 발생!");
	}
}
class CodeNotFoundException extends Exception{
	public String toString() {
		return "코드를 찾을 수 없습니다.";
	}
}
class ProductNotFoundException extends Exception{
	public String toString() {
		return "제품을 찾을 수 없습니다!";
	}
}

class ProductMgrImpl implements IProductMgr{
	private static ArrayList<Product> list;
	private static ProductMgrImpl p1;
	
	class Save extends Thread{
		public void run() {
			try {
				FileOutputStream fos = new FileOutputStream("product.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				for(Product p : list) {
					oos.writeObject(p);
				}
				
				System.out.println("저장성공");
				oos.close();
				fos.close();
			}catch(FileNotFoundException e) {
				System.out.println("파일을 읽어 올 수 없습니다.");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	class ProductClient extends Thread{
		Socket s = null;
		OutputStream s1out;
		ObjectOutputStream oos;
		public void run() {
			try {
				s= new Socket("localhost" ,8888);
				s1out = s.getOutputStream();
				oos = new ObjectOutputStream(s1out);
				for(Product p : FindTV()) {
					oos.writeObject(p);
				}
				for(Product p : FindRefri()) {
					oos.writeObject(p);
				}
				
				oos.close();
				s1out.close();
				s.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void send() {
		new ProductClient().start();
	}
	public void close() {
		new Save().start();
	}
	private ProductMgrImpl(){
		list = new ArrayList<Product>();
	}
	public static ProductMgrImpl getInstance() {
		if(p1 == null) {
			p1 = new ProductMgrImpl();
		}
		p1.open();
		return p1;
	}
	@Override
	public void add(Product p) throws DuplicateException {
		if(list.size() == 0) {
			list.add(p);
		}else {
			
		for(Product p1 : list) {
			if(p1.getSerial().equals(p.getSerial())) {
				throw new DuplicateException();
			}
		}}
		list.add(p);
	}

	@Override
	public ArrayList<Product> total() {
		return list;
	}

	@Override
	public Product FindBySerial(String serial) throws CodeNotFoundException {
		for(Product p: list) {
			if(p.getSerial().equals(serial)) {
				return p;
			}
		}
		throw new CodeNotFoundException();
	}

	@Override
	public ArrayList<Product> FindByName(String name) {
		ArrayList<Product> temp = new ArrayList<>();
		for(Product p:list) {
			if(p.getName().contains(name)) {
				temp.add(p);
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Product> FindTV() {
		ArrayList<Product> temp = new ArrayList<>();
		for(Product p:list) {
			if(p instanceof TV) {
				temp.add(p);
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Product> FindRefri() {
		ArrayList<Product> temp = new ArrayList<>();
		for(Product p:list) {
			if(p instanceof Refrigerator) {
				temp.add(p);
			}
		}
		return temp;
	}

	@Override
	public ArrayList<Product> FindRefriWith400vol() throws ProductNotFoundException {
		
		ArrayList<Product> temp = new ArrayList<Product>();
		ArrayList<Product> re= FindRefri();
		for(Product p : re) {
			Refrigerator pre = (Refrigerator)p;
			if(pre.getVolume() >= 400.0) {
				temp.add(p);
			}
		}
		if(temp.size() == 0) throw new ProductNotFoundException();
		else return temp;
	}

	@Override
	public ArrayList<Product> FindTVWith50size() throws ProductNotFoundException {
		ArrayList<Product> temp = new ArrayList<Product>();
		ArrayList<Product> re= FindTV();
		for(Product p : re) {
			TV pre = (TV)p;
			if(pre.getSize() >= 50) {
				temp.add(p);
			}
		}
		if(temp.size() == 0) throw new ProductNotFoundException();
		else return temp;
	}

	@Override
	public void change(String serial, int price) throws CodeNotFoundException {
		Product p = FindBySerial(serial);
		p.setPrice(price);
	}

	@Override
	public void delete(String serial) throws CodeNotFoundException {
		list.remove(FindBySerial(serial));
	}

	@Override
	public long sum() {
		long su = 0;
		for(Product p: list) {
			su += p.getPrice() * p.getStock();
		}
		return su;
	}


	@Override
	public void open()  {
		FileInputStream fis =null; 
		ObjectInputStream ois =null; 
		try {
			fis= new FileInputStream("product.dat");
			ois= new ObjectInputStream(fis);
			Object obj;
			while(true) {
				obj = (Product)ois.readObject();
				if(obj != null)
					list.add((Product)obj);
			}
		}catch(FileNotFoundException e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}catch(EOFException e) {
			System.out.println("파일 읽기 성공");
		}catch(Exception e) {
		e.printStackTrace();
		}finally {
			try {
				if(ois!=null) {
					ois.close();
					fis.close();
					System.out.println("닫앗당");
				}
			}
			catch(Exception e) {
				
			}
		}
		
		
	}
	public void printProduct(Product p) {
		if(p == null) {
			return;
		}
		System.out.println(p.toString());
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
	}
	public void printProduct(ArrayList<Product> p) {
		if(p==null) {
			return;
		}
		else {
			for(int i = 0; i < p.size(); i++) {
				System.out.println(p.get(i).toString());
			}
			System.out.println("---------------------------------------------------------------------------------------------------------------");
		}
	}
	public void printProduct(long sum) {
		if(sum <= 0) {
			System.out.println("제품이 등록되어 있지 않습니다.");
			System.out.println("---------------------------------------------------------------------------------------------------------------");
		}
		else {
			System.out.println("제품 재고의 총 금액은 : " +sum+"원 입니다." );
			System.out.println("---------------------------------------------------------------------------------------------------------------");
		}
	}
	
}

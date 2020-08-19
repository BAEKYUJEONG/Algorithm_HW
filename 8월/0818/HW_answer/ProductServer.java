import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ProductServer {

	public static void main(String[] args) throws Exception {
		ServerSocket sck = null;
		Socket s;
		InputStream s1in;
		ObjectInputStream ois;
		ArrayList<Product> receive = new ArrayList<>();
		sck = new ServerSocket(8888);
		while(true) {
			System.out.println("매니저 기다리는 중");
			s =sck.accept();
			System.out.println("접속!");
			s1in = s.getInputStream();
			ois = new ObjectInputStream(s1in);
			
			try {
				Object obj;
				while(true) {
					obj = (Product)ois.readObject();
					if(obj != null)
						receive.add((Product)obj);
				}
			}catch(EOFException e) {
				System.out.println("다 받았다!");
			}catch(Exception e) {
			e.printStackTrace();
			}
			for(int i = 0; i < receive.size();i++) {
				System.out.println(receive.get(i).toString());
			}
			receive.clear();
			ois.close();
			s1in.close();
			s.close();
		}
	}

}

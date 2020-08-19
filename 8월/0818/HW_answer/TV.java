import java.io.Serializable;

public class TV extends Product implements Serializable{
	private int size;
	private String type;
	public TV(String serial, String name, int price, int stock, int size, String type) {
		super(serial, name, price, stock);
		this.size = size;
		this.type = type;
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String toString() {
		return super.toString() + "|\t 인치 = " + size + "|\t 디스플레이 타입 = " + type ;
	}
	
}
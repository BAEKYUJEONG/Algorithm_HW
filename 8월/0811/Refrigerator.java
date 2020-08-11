
public class Refrigerator extends Product{

	private int capacity;
	
	public Refrigerator() {
		// TODO Auto-generated constructor stub
	}

	public Refrigerator(int num, String name, int price, int stock, int capacity) {
		super(num, name, price, stock);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [capacity=");
		builder.append(capacity);
		builder.append(", ");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}

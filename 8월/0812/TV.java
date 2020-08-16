
public class TV extends Product{
	
	private int inch;
	private String display;
	
	public TV() {
		// TODO Auto-generated constructor stub
	}
	
	public TV(int num, String name, int price, int stock, int inch, String display) {
		super(num, name, price, stock);
		this.inch = inch;
		this.display = display;
	}

	public int getInch() {
		return inch;
	}

	public void setInch(int inch) {
		this.inch = inch;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TV [inch=");
		builder.append(inch);
		builder.append(", display=");
		builder.append(display);
		builder.append("]");
		return builder.toString();
	}
	
}

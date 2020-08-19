public class Refrigerator extends Product {

		private double volume;
		public double getVolume() {
			return volume;
		}

		public void setVolume(double volume) {
			this.volume = volume;
		}

		public Refrigerator(String serial, String name, int price, int stock, double volume) {
			super(serial, name, price, stock);
			this.volume = volume;
		}
		
		public String toString() {
			return super.toString() + "|\t 용량 = "+ volume;
		}
		
	
}

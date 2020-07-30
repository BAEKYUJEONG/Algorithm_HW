package hwjava04_seoul_class8_baekyujeong;

public class ProductTest {
	public static void main(String[] args) { 
		
		TV tv = new TV("KQ65QT950SFXKR","QLED 8K 163cm Infinity Screen",9280000,9999,65,"QLED");
		Refrigerator rf = new Refrigerator("RF10T9965APS","셰프컬렉션 900 L 다크 크롬 프레임",11980000,9999,900);
		
		System.out.println(tv);
		System.out.println(rf);
	}

}

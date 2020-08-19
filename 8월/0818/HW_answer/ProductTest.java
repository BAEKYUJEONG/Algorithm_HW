import java.util.Scanner;

public class ProductTest {
	public static boolean menu(ProductMgrImpl p , int menu) {
		String serial;
		String name;
		int price;
		int stock;
		int size;
		String type;
		double volume;
		Scanner sc = new Scanner(System.in);
		try {
			switch(menu) {
				case 0:
					System.out.println("프로그램을 종료합니다.");
					p.send();					p.close();
					return false;
				case 1:
					System.out.println("TV를 추가합니다.");
					System.out.print("제품번호를 입력해주세요 : ");
					serial = sc.nextLine();
					System.out.print("제품이름을 입력해주세요 : ");
					name = sc.nextLine();
					System.out.print("제품가격을 입력해주세요 : ");
					price = Integer.parseInt(sc.nextLine());
					System.out.print("제품재고를 입력해주세요 : ");
					stock = Integer.parseInt(sc.nextLine());
					System.out.print("제품의 인치수를 입력해주세요 : ");
					size = Integer.parseInt(sc.nextLine());
					System.out.print("제품의 패널 종류를 입력해주세요 : ");
					type = sc.nextLine();
					p.add(new TV(serial,name,price,stock,size,type));
					return true;
				case 2:
					System.out.println("냉장고를 추가합니다.");
					System.out.print("제품번호를 입력해주세요 : ");
					serial = sc.nextLine();
					System.out.print("제품이름을 입력해주세요 : ");
					name = sc.nextLine();
					System.out.print("제품가격을 입력해주세요 : ");
					price = Integer.parseInt(sc.nextLine());
					System.out.print("제품재고를 입력해주세요 : ");
					stock = Integer.parseInt(sc.nextLine());
					System.out.print("제품의 용량을 입력해주세요 : ");
					volume = Double.parseDouble(sc.nextLine());
					p.add(new Refrigerator(serial,name,price,stock,volume));
					return true;
				
				case 3:
					System.out.print("검색할 제품번호를 입력해주세요 : ");
					serial = sc.nextLine();
					p.printProduct(p.FindBySerial(serial));
					return true;
				case 4:
					System.out.println("검색할 제품명을 입력해주세요 : ");
					serial = sc.nextLine();
					p.printProduct(p.FindByName(serial));
					return true;
				case 5:
					System.out.println("전체 TV 목록 입니다.");
					p.printProduct(p.FindTV());
					return true;
				case 6:
					System.out.println("전체 냉장고 목록입니다.");
					p.printProduct(p.FindRefri());
					return true;
				case 7:
					System.out.println("400리터 이상 냉장고 목록입니다.");
					p.printProduct(p.FindRefriWith400vol());
					return true;
				case 8:
					System.out.println("50인치 이상 TV 목록입니다.");
					p.printProduct(p.FindTVWith50size());
					return true;
				case 9:
					System.out.print("가격을 변경할 제품의 제품번호를 입력하세요 : ");
					serial = sc.nextLine();
					System.out.println("변경할 가격을 입력해주세요");
					price = Integer.parseInt(sc.nextLine());
					p.change(serial, price);
					return true;
				case 10:
					System.out.print("삭제하고 싶은 제품의 제품번호를 입력하세요 : ");
					serial = sc.nextLine();
					p.delete(serial);
					return true;
				case 11:
					System.out.println("제품 재고 합계 금액은 " + p.sum() + "원 입니다. ");
					return true;
				case 12:
					p.printProduct(p.total());
					return true;
				default:
					System.out.println("올바른 메뉴 번호를 입력헤주세요");
					return true;
			}
		}catch(DuplicateException d) {
				System.out.println(d);
		}catch(CodeNotFoundException c) {
				System.out.println(c);
		}catch(ProductNotFoundException e) {
			System.out.println(e);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	static void menubar() {
		System.out.println("1. TV 추가하기");
		System.out.println("2. 냉장고 추가하기");
		System.out.println("3. 제품번호로 검색하기");
		System.out.println("4. 제품이름으로 검색하기");
		System.out.println("5. 전체 TV목록");
		System.out.println("6. 전체 냉장고목록");
		System.out.println("7. 400리터 이상 냉장고 목록");
		System.out.println("8. 50인치 이상 TV 목록");
		System.out.println("9. 제품 가격 변경");
		System.out.println("10. 제품 삭제");
		System.out.println("11. 제품 재고 합계 금액");
		System.out.println("12. 제품전체목록");
		System.out.println("0. 종료");
	}
	public static void main(String[] args) throws Exception {
		
		ProductMgrImpl p1 = ProductMgrImpl.getInstance();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		int menunum;
		while(flag) {
			menubar();
			System.out.print("명령을 입력하세요 : ");
			menunum = Integer.parseInt(sc.nextLine());
			flag = menu(p1,menunum);
			System.out.println("엔터를 입력해주세요");
			sc.nextLine();
		}
		/*TV t1 = new TV("UN49NU7150FXKR", "UltraUHDTV", 700000, 7, 50, "OLED");
		TV t2 = new TV("UN49NU7150FDKR", "UHDTV", 350000, 5, 35, "OLED");
		Refrigerator r1 = new Refrigerator("F9WK", "LG 트롬", 59000, 10, 350 );
		Refrigerator r2 = new Refrigerator("F9WS", "LG 트롬", 69000, 15, 450 );
		Refrigerator r3 = new Refrigerator("F9LS", "LG 통 세탁기", 69000, 15, 550 );
		p1.add(t1);
		p1.add(t2);
		p1.add(r1);
		p1.add(r2);
		p1.add(r3);*/
				
		/*System.out.println("---------------------------------------------------------------------------------------------------------------");
		System.out.println("전체 목록");
		p1.printProduct(p1.total());
		System.out.println("상품 번호 검색(F9LS)");
		p1.printProduct(p1.FindBySerial("F9LS"));
		System.out.println("상품 명 검색(트롬)");
		p1.printProduct(p1.FindByName("트롬"));
		System.out.println("TV정보만 검색");
		p1.printProduct(p1.FindTV());
		System.out.println("냉장고정보만 검색");
		p1.printProduct(p1.FindRefri());
		System.out.println("400L 이상 냉장고정보만 검색");
		p1.printProduct(p1.FindRefriWith400vol());
		
		System.out.println("50인치 이상 TV정보만 검색");
		p1.printProduct(p1.FindTVWith50size());
		System.out.println("상품 가격 변경 F9LS , 3900");
		p1.change("F9LS", 39000);
		p1.printProduct(p1.FindBySerial("F9LS"));
		System.out.println("상품 삭제 (F9LS)");
		p1.delete("F9LS");
		p1.printProduct(p1.total());
		System.out.println("상품 재고 전체 금액");
		p1.printProduct(p1.sum());*/
		
	}

}

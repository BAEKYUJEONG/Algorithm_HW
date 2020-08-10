import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductMgr mgr = new ProductMgr();
		
		int no;
		do {
			System.out.println("<<Product 메뉴>>");
			 System.out.println("1.데이터 입력  2.데이터검색(전체)  3.데이터 검색(num)  4.데이터 검색(name)  5.데이터 검색(TV)");
		     System.out.println("6.데이터 검색(Refrigerator)  7.데이터 삭제(num)  8.전체 재고 상품 금액   9.종료");

			 System.out.print("\n번호선택==> ");
			 no = sc.nextInt();
			 System.out.println();
			 switch(no) {
			 case 1 : 
			 {
				 System.out.println("1.TV  2.Refrigerator");
				 System.out.print("\n번호선택==> ");
				 int kind = sc.nextInt();
				 System.out.print("num : "); int num = sc.nextInt();
				 System.out.print("name : "); String name = sc.next();
				 System.out.print("price: "); int price = sc.nextInt();
				 System.out.print("stock : "); int stock = sc.nextInt();
				 
				 Product product = null;
				 if(kind==1) {
					 System.out.print("inch : "); int inch = sc.nextInt();
					 System.out.print("diplay : "); String display = sc.next();
					 product = new TV(num, name, price, stock, inch, display);
				 }else if(kind==2) {
					 System.out.print("capacity : "); int capacity = sc.nextInt();
					 product = new Refrigerator(num, name, price, stock, capacity);
				 }
				 if(product!=null)
					 mgr.add(product);
			 }
			 	break;
			 case 2 :
				 System.out.println("### 전체검색 ###");
				 print(mgr.searchAll());
				 break;
			 case 3 :
				 System.out.print("num : "); int num = sc.nextInt();
				 System.out.println("### num 검색 ###");
				 print(mgr.searchNum(num));
				 break;
			 case 4 :
				 System.out.print("name : "); String name = sc.next();
				 System.out.println("### name 검색 ###");
				 print(mgr.searchName(name));
				 break;
			 case 5 :
				 System.out.println("### TV 검색 ###");
				 print(mgr.searchTV());
				 break;
			 case 6 :
				 System.out.println("### 냉장고 검색 ###");
				 print(mgr.searchRefrigerator());
				 break;
			 case 7 :
				 System.out.print("num : "); int del_num = sc.nextInt();
				 boolean flag = mgr.delete(del_num);
				 if(flag)
					 System.out.println("정상적으로 삭제되었습니다.");
				 else
					 System.out.println("삭제 실패! 번호를 확인하세요.");
				 break;
			 case 8 :
				 System.out.println("### 전체 재고 상품 금액의 합계 ###");
				 System.out.println("합계 : "+mgr.searchTotalPrice());
				 break;
			 }
			 System.out.println();
		}while(no!=9);
		
		sc.close();
	}

	private static void print(Product[] products) {
		for(Product p : products) {
			System.out.println(p);
		}
	}
	
	private static void print(Product product) {
		System.out.println(product);
	}
}

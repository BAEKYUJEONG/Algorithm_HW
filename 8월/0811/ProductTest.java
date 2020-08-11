import java.util.ArrayList;
import java.util.Scanner;

public class ProductTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IProductMgr mgr = new ProductMgrImpl();
		
		int no;
		do {
			System.out.println("<<Product 메뉴>>");
			System.out.println("1.데이터 입력  2.데이터 검색(전체)  3.데이터 검색(Num)  4.데이터 검색(Name)  5.데이터 검색(TV)  6.데이터 검색(Refrigerator)");
		    System.out.println("7.데이터 검색(400L이상 Refrigerator)  8.데이터 검색(50inch이상 TV)  9.데이터 수정(Price)  10.데이터 삭제(Num)  11.전체 재고 상품 금액  12.종료");

			System.out.print("\n번호선택==> ");
			no = sc.nextInt();
			 
			System.out.println();
			switch(no) {
			case 1 :
			{
				System.out.println("1.TV  2.Refrigerator");
				System.out.print("번호선택==> ");
				int kind= sc.nextInt();
				System.out.print("num : "); int num = sc.nextInt();
				System.out.print("name : "); String name = sc.next();
				System.out.print("price: "); int price = sc.nextInt();
				System.out.print("stock : "); int stock = sc.nextInt();
				
				Product product = null;
				if(kind==1) {
					System.out.print("inch : "); int inch = sc.nextInt();
					System.out.print("display : "); String display = sc.next();
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
				System.out.println("### 번호 검색 ###");
				System.out.print("num : "); int num = sc.nextInt();
				print(mgr.searchNum(num));
				break;
			case 4 :
				System.out.println("### 상품명 검색 ###"); 
				System.out.print("name : "); String name = sc.next();
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
				System.out.println("### 400L이상 냉장고 검색 ###");
				print(mgr.search400capacity());
				break;
			case 8 :
				System.out.println("### 50인치 이상 TV 검색 ###");
				print(mgr.search50inch());
				break;
			case 9 :
				System.out.println("### 상품 가격 수정 ###"); 
				System.out.println("수정할 상품의 번호를 입력히세요.");
				System.out.print("num : "); int modify_num = sc.nextInt();
				System.out.println("수정할 가격을 입력하세요.");
				System.out.print("price : "); int modify_price = sc.nextInt();
				boolean flag1 = mgr.modifyPrice(modify_num, modify_price);
				if(flag1)
					System.out.println("정상적으로 수정되었습니다.");
				else
					System.out.println("수정 실패! 번호를 확인하세요.");
				break;
			case 10 :
				System.out.println("### 상품 삭제 ###");
				System.out.print("num : "); int del_num = sc.nextInt();
				boolean flag2 = mgr.delete(del_num);
				 if(flag2)
					 System.out.println("정상적으로 삭제되었습니다.");
				 else
					 System.out.println("삭제 실패! 번호를 확인하세요.");
				 break;
			case 11 :
				System.out.println("### 전체 재고 상품 금액의 합계 ###");
				System.out.println("합계 : "+mgr.searchTotalPrice());
				break;
			}
		}while(no!=12);
		
		sc.close();
	}

	private static void print(Product product) {
		System.out.println(product);
	}

	private static void print(ArrayList<Product> products) {
		for(Product p : products) {
			System.out.println(p);
		}
	}
}

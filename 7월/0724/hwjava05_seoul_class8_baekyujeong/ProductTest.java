package hwjava05_seoul_class8_baekyujeong;

import java.util.Scanner;

public class ProductTest {
	
	static ProductMgr list  = ProductMgr.getInstance();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int n = 1;
		while(n != 0) {
			System.out.println();
			System.out.println("<<< 재고 관리 프로그램 >>>");
			System.out.println("1. 상품 정보 입력"); 
			System.out.println("2. 상품 정보 전체 검색");
			System.out.println("3. 상품 번호 검색");
			System.out.println("4. 상품 정보 삭제");
			System.out.println("5. 특정 가격 이하 상품 검색");
			System.out.println("0. 종료");
			System.out.println("원하는 번호를 선택하세요.");
			n = sc.nextInt();
			sc.nextLine();
			switch(n) {
			case 0:
				System.out.println("종료합니다.");
				break;
			case 1:
				add_product();
				break;
			case 2:
				print_all();
				break;
			case 3:
				print_num();
				break;
			case 4:
				System.out.println("삭제하고자 하는 상품번호 : ");
				int num = sc.nextInt();
				list.delete(num);
				break;
			case 5:
				print_lowprice();
				break;
			default:
				System.out.println("Unavailable Choice");
				break;
			}
		}
	}
	
	public static void add_product() {
		System.out.println("1. 상품 정보 입력");
		System.out.print("상품번호 : ");
		int num = sc.nextInt();
		sc.nextLine();
		System.out.print("상품이름 : ");
		String name = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		System.out.print("수량 : ");
		int stock = sc.nextInt();
		sc.nextLine();
		
		Product p = new Product(num, name, price, stock);
		list.add(p);
	}
	
	public static void print_all() {
		System.out.println();
		Product [] products = new Product[100];
		products = list.list();
		for(int i=0; i<list.getSize(); ++i) {
			System.out.println(products[i]);
		}
	}
	
	public static void print_num() {
		System.out.println("3. 상품 번호 검색");
		System.out.println("상품번호 : ");
		int num = sc.nextInt();
		int size = list.list(num).length;
		System.out.println(size);
		Product [] products;
		products = list.list(num);
		for(int i=0; i<size; ++i) {
			System.out.println(products[i]);
		}
	}
	
	public static void print_lowprice() {
		System.out.println("5. 특정 가격 이하 상품 검색");
		System.out.println("가격 : ");
		int price = sc.nextInt();
		int size = list.priceList(price).length;
		Product [] products;
		products = list.priceList(price);
		for(int i=0; i<size; ++i) {
			System.out.println(products[i]);
		}
	}

}

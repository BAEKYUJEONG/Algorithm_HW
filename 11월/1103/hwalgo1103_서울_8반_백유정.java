import java.util.ArrayList;
import java.util.Scanner;

public class hwalgo1103_서울_8반_백유정 {
//Main_BOJ_2564_경비원 

	static class Point {
		int direction;
		int y;
		int x;

		Point(int direction, int distance, int c, int r) {
			this.direction = direction;

			if (direction == 1) {
				this.y = 0;
				this.x = distance;
			} else if (direction == 2) {
				this.y = c;
				this.x = distance;
			} else if (direction == 3) {
				this.y = distance;
				this.x = 0;
			} else {
				this.y = distance;
				this.x = r;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		가로 세로 길이 입력
		int r = sc.nextInt();
		int c = sc.nextInt();
		
//		상점의 갯수 입력		
		int n = sc.nextInt();
		ArrayList<Point> list = new ArrayList<Point>();

		for (int i = 0; i < n; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();
			Point market = new Point(dir, dis, c, r);
			list.add(market);
		}
//		경비원 위치 입력
		int d = sc.nextInt();
		int v = sc.nextInt();
		Point dong = new Point(d, v, c, r);
		
		int temp = 0;  // 경비원의 맞은편 위치
		int result = 0;
		
//		경비원의 맞은편 계산하기 구해 놓기 : 1은 블록의 북쪽, 2는 블록의 남쪽, 3은 블록의 서쪽, 4는 블록의 동쪽 
		if (d == 1) {
			temp = 2;
		} else if (d == 2) {
			temp = 1;
		} else if (d == 3) {
			temp = 4;
		} else {
			temp = 3;
		}
		
//		모든 마켓 검사하기
		for(Point p : list) {
//			경비원의 맞은편에 있으면 양쪽 모두 구해서 작은값으로 설정하기
			if (p.direction == temp) {
//				상가가 남북에 있는 경우 계산하기
				if (p.direction == 1 || p.direction == 2) {
					result += Math.min(dong.y + p.y + dong.x + p.x, dong.y + p.y + r - dong.x + r - p.x);
//				상가가 동서에 있는 경우 계산하기
				} else {
					result += Math.min(c - dong.y + c - p.y + dong.x + p.x, dong.y + p.y + dong.x + p.x);
				}
//			그렇지 않으면 X축 차이값과 Y축 차이값을 구해서 비용으로 계산하기
			} else {
				result += Math.abs(dong.y - p.y) + Math.abs(dong.x - p.x);
			}
		}
		System.out.println(result);
	}


}
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class hwalgo1029_서울_8반_백유정 {
	
	static int[][] a;
	static Map<Integer, String> map = new HashMap<>();
	static Deque<Loc> q = new LinkedList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		a = new int[N + 1][N + 1];
		int K = sc.nextInt();
		while (K-- > 0) {
			a[sc.nextInt()][sc.nextInt()] = -1;
		}
		
		int L = sc.nextInt();
		while (L-- > 0) {
			map.put(sc.nextInt(), sc.next());
		}
		

		int i = 0;
		
		q.add(new Loc(1, 1));
		int dx = 0, dy = 1;
		
		while (true) {
			++i;
			
			Loc loc = q.getFirst();

			Loc top = new Loc(loc.x + dx, loc.y + dy);

			// 격자 밖으로 나갔는지 체크
			if (top.x > N || top.y > N || top.x <= 0 || top.y <= 0) break;

			// 같은 좌표가 있는 경우 : 기존 큐의 좌표와 같은 정보가 있는지
			if (q.size() > 1 && check(top)) break;

			// 사과인지 체크
			if (a[top.x][top.y] == -1) {
				a[top.x][top.y] = 0;
			} else {				
				q.removeLast();
			}
			
			// 없다면 추가
			q.addFirst(top);
			
			if (map.size() > 0) {
				String dir = map.remove(i);
				if (dir != null) {
					if (dir.equals("D")) {
						if (dx > dy) {
							dx--;
							dy--;
						} else {
							dx++;
							dy++;
						}
					} else if (dir.equals("L")) {
						if (dx > dy) {
							dx++;
							dy++;
						} else {
							dx--;
							dy--;
						}
					}
					if (dx == 2 || dx == -2) dx = 0;
					if (dy == 2 || dy == -2) dy = 0;
				} 
			}
			
		}
		System.out.println(i);
		sc.close();
	}//main
	
	static boolean check(Loc loc) {
		for (Loc l : q) {
			if (loc.x == l.x && loc.y == l.y) return true;
		}
		return false;
	}

	static class Loc {
		int x, y;
		Loc(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Loc [x=" + x + ", y=" + y + "]";
		}
	}
}
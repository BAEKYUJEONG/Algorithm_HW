import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class hwalgo1102_서울_8반_백유정 {
//Solution_M5656_벽돌깨기_BFS 
	static class Point{
		int r,c,cnt;
		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	private static int N,W,H,min;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		for (int t = 1; t <= T; ++t) {
				//// #1, N = 3, W = 10, H = 10
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken()); // 시간
			W = Integer.parseInt(st.nextToken()); // 열크기
			H = Integer.parseInt(st.nextToken()); // 행크기
			int[][] map = new int[H][W];
			for (int r = 0; r < H; ++r) {
				st = new StringTokenizer(in.readLine());
				for (int c = 0; c < W; ++c) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}			
			min = Integer.MAX_VALUE;
			go(0,map);
			System.out.println("#" + t + " "+min);
		}
	}

	private static boolean go(int count,int[][] map) {
		int result = getRemain(map);
		if(result == 0) {
			min = 0;
			return true;
		}
		if(count == N) {
			min = Math.min(min, result);
			return false;
		}
		int[][] newMap = new int[H][W];
		for (int c = 0; c < W; ++c) { // 매열마다 구슬 떨어드리는 시도.			
			// 구슬을 떨어뜨리면 맞는 벽돌이 있는 행 찾기
			int r=0;
			while(r<H && map[r][c]==0)r++;
			if(r==H) continue; // 모두 빈칸이면 다음 열로 시도
			
			// 터트리는 시도하기 전에 직전 count횟수까지의 맵 상태를 이용하여 배열 복사하여 초기화 
			copy(map,newMap);
			
			boom(newMap,r,c);
			down(newMap);
			if(go(count+1,newMap)) return true;
		}	
		return false;
	}
	private static void boom(int[][] map,int r,int c) {
		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c]>1) { // 주변 영향 미치는 벽돌이면 터지는 시작점으로 큐에 넣기
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0; // 자신은 제거 처리
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for (int d = 0; d < 4; ++d) {
				int nr = p.r,nc=p.c;
				for (int k = 1; k < p.cnt; ++k) {// 자신의 숫자-1만큼 제거처리할 벽돌 큐에 넣기
					nr += dr[d];
					nc += dc[d];
					if(nr>=0 && nr<H && nc>=0 && nc<W && map[nr][nc]!=0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr,nc,map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}
	}
	private static void down(int[][] map) {
		for (int c = 0; c < W; ++c) {
			int r = H-1;
			while(r>0) {// 윗행은 내릴행이 없으므로 1행까지만 돌면 됨.
				if(map[r][c]==0) {// 빈칸이면 가장 가까운 빈칸이 아닌 칸 찾기
					int nr = r-1; // 직전행부터
					while(nr>0 && map[nr][c]==0) --nr; // 빈칸이면 계속 윗행으로
					map[r][c] = map[nr][c];// 현재행에 남은 벽돌이나 결국 맨윗행의 0이 채워짐.
					map[nr][c] = 0; // 찾은 윗행은 벽돌이 떨어졌으므로 빈칸 처리
				}
				--r;
			}
		}
	}
	private static int getRemain(int[][] map) {
		int count = 0;
		for (int i = 0; i < H; ++i) {
			for (int j = 0; j < W; ++j) {
				if(map[i][j]>0) count++;
			}
		}
		return count;
	}
	private static void copy(int[][] map,int[][] newMap) {
		for (int r = 0; r < H; r++) {
			for (int c = 0; c < W; c++) {
				newMap[r][c] = map[r][c];
			}
		}
	}
}
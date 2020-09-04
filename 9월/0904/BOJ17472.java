import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17472 {

	final static int[][] direction = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M, map[][];
	static boolean[][] visited;
	static int[] parents;
	static PriorityQueue<int[]> distances = new PriorityQueue<>(new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			return o1[2] - o2[2];
		}
	});
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int islandsNum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					setIslands(i, j, islandsNum);
					++islandsNum;
				}
			}
		}
		
		parents = new int[islandsNum + 1];
		for(int i = 0; i < islandsNum + 1; i++) parents[i] = i;
		
		//visited 재활용
		visited = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					findRoad(i, j);
				}
			}
		}
		
		//크루스칼 만들어야함
		int answer = 0;
		int cnt = 0;
		while(!distances.isEmpty()) {
			if(cnt == islandsNum - 1) break;
			int[] d = distances.poll();
			int i1 = d[0];
			int i2 = d[1];
			int distance = d[2];
			if(distance < 2) continue;
			if(find(i1) != find(i2)) {
				union(i1, i2);
				answer += distance;
				++cnt;
			}
		}
		
		if(cnt == islandsNum - 1)
			System.out.println(answer);
		else
			System.out.println(-1);
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		parents[y] = x;
	}
	
	static int find(int x) {
		if(parents[x] == x) 
			return x;
		
		return parents[x] = find(parents[x]);
	}
	
	
	//섬 번호 부여
	private static void setIslands(int row, int col, int num) {
		if(visited[row][col]) return;
		visited[row][col] = true;
		
		map[row][col] += num;
		
		for(int[] d: direction) {
			int newRow = row + d[0];
			int newCol = col + d[1];
			if(newRow < 0 || newRow >= N || 
			   newCol < 0 || newCol >= M || map[newRow][newCol] != 1) continue;
			setIslands(newRow, newCol, num);
		}
	}
	
	private static void findRoad(int row, int col) {
		if(visited[row][col]) return;
		visited[row][col] = true;

		buildBridge(row, col);
		
		for(int[] d: direction) {
			int newRow = row + d[0];
			int newCol = col + d[1];
			if(newRow < 0 || newRow >= N || 
			   newCol < 0 || newCol >= M || map[newRow][newCol] == 0) continue;
			// 다리깔기
			findRoad(newRow, newCol);
		}
	}
	
	//섬사이에 깐 다리 거리 찾기
	private static void buildBridge(int row, int col) {
		int cnt;
		
		for(int[] d: direction) {
			cnt = 0;
			int newRow = row + d[0];
			int newCol = col + d[1];
			//바다를 찾았을때 다리를 쭉 깔아본다.
			if(newRow >= 0 && newRow < N && 
			   newCol >= 0 && newCol < M && map[newRow][newCol] == 0) {
				do {
					++cnt; // 하나 세고
					if(map[newRow][newCol] != 0) { // 다리가 어떤 섬까지 이어졌을때 
						if(map[row][col] != map[newRow][newCol]){ // 다른섬에 다리를 이었을 때
							int i1 = map[row][col];
							int i2 = map[newRow][newCol];
							distances.add(new int[] { i1, i2, cnt - 1});
						}
						break;
					}
					newRow += d[0];
					newCol += d[1];
				} while(newRow >= 0 && newRow < N && 
						newCol >= 0 && newCol < M);
			}
		}
	}
	
}
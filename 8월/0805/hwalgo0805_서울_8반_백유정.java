import java.util.Arrays;
import java.util.Scanner;

public class hwalgo0805_서울_8반_백유정 {
	static int [][] map;
	static int dx[] = {0, 0, 1, -1};
	static int dy[] = {1, -1, 0, 0};
	static int N;
	static int n=0;
	
	static void dfs(int x, int y) {
		map[x][y] = 0;
		
		for(int i=0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if( nx<0 || ny<0  || nx>=N ||  ny>= N ) 
				continue;
			
			if( nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(map[nx][ny] == 1) {
					dfs(nx, ny);
					n++;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int [N][N];
		int cnt = 0;
		int arr[] = new int [625];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					cnt++;
					dfs(i,j);
					arr[cnt] = n;
					n=0;
				}
			}
		}
		
		System.out.println(cnt);
		Arrays.sort(arr);
		
		for(int i=0; i<cnt; i++)
			System.out.println(arr[i]);
		
		sc.close();
	}
}

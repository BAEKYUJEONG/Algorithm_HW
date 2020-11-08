import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 인접행렬 + BFS
public class hwalgo1104_서울_8반_백유정 { 
//Solution_D4_5643_키순서_BFS

	static int N,M;
	static int adj[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		for(int t=1; t<=T; ++t) {
			N = Integer.parseInt(in.readLine().trim());
			M = Integer.parseInt(in.readLine().trim());
			adj = new int[N+1][N+1];
			StringTokenizer st = null;
			int i,j;
			for(int m=0; m<M; ++m) {
				st = new StringTokenizer(in.readLine(), " ");
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1;
			}
			int answer = 0;
			for(int k=1; k<=N; ++k) {
				gtCnt = ltCnt =  0;
				gtBFS(k, new boolean[N+1]);
				ltBFS(k, new boolean[N+1]);
				if(gtCnt + ltCnt ==N-1) answer++;
			}
			System.out.println("#"+t+" "+answer);
		}
	}
	static int gtCnt = 0,ltCnt = 0;
	private static void gtBFS(int start,boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for(int i=1; i<=N; ++i) {
				if(adj[k][i]==1 && !visited[i]) {
					gtCnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
	private static void ltBFS(int start,boolean[] visited) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for(int i=1; i<=N; ++i) {
				if(adj[i][k]==1 && !visited[i]) {
					ltCnt++;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}

}
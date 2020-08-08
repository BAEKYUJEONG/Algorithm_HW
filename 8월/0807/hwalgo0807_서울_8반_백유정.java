import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class hwalgo0807_서울_8반_백유정 {
	
	static int visit[] = new int[100001];
	
	static void bfs(int n, int k){
		Queue<Integer> q = new LinkedList<>();
		
		q.add(n);
		visit[n] = 1;
		
		while(!q.isEmpty()) {
			n = q.poll();
			
			if(n==k) {
				break;
			}
			if(n*2<visit.length && visit[n*2]==0) {
				q.add(n*2);
				visit[n*2] = visit[n]+1;
			}
			if(n+1<visit.length && visit[n+1]==0) {
				q.add(n+1);
				visit[n+1] = visit[n]+1;
			}
			if(n-1>=0 && visit[n-1]==0){
				q.add(n-1);
				visit[n-1] = visit[n]+1;
			}
		}
		
		System.out.println(visit[k]-1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		bfs(N,K);
		
		sc.close();
	}

}

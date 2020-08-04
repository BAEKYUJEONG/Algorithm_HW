import java.util.Scanner;

public class hwalgo0804_서울_8반_백유정{
	static int[] arr;
	static int[] cnt;

	static int find(int n) {
		if(n == arr[n])
			return n;
		int p = find(arr[n]);
		arr[n] = p;
		cnt[p]++;
		return p;
	}

	static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) {
			if(cnt[p1] < cnt[p2]) {
				arr[p1] = p2;
				cnt[p1] += cnt[p2];
			}
			else {
				arr[p2] = p1;
				cnt[p2] += cnt[p1];
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[N+1];
		cnt = new int[N+1];

		for(int i = 1; i <= N; i++) {
			arr[i] = i;
			cnt[i] = 1;
		}

		for(int i = 0; i < M; i++) 
			union(sc.nextInt(), sc.nextInt());

		int[] visit = new int[N+1];
		int ans = 0;

		for(int i = 1; i <= N; i++) {
			find(i);
			visit[arr[i]]++;
		}
		for(int i = 1; i <= N; i++)
			if(visit[i] != 0)
				ans++;
		System.out.println(ans);
	}
}​
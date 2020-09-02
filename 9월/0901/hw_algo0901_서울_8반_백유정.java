import java.util.Arrays;
import java.util.Scanner;
// 백준 14889 스타트와 링크
public class hw_algo0901_서울_8반_백유정 {
	static int N;
	static int[][] map;
	static int res;
	static boolean[] team;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N= sc.nextInt();
		map = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int len = 1 << N;
		team = new boolean[N];
		int cnt = 0;
		res = Integer.MAX_VALUE;
//		반대팀 만드는 경우는 해보지 않아도 됨 {1,2,3} : {4,5,6} == {4,5,6} :{1,2,3}		
		for(int i = 0; i < len/2; i++) {
			Arrays.fill(team, false);
			cnt = 0;
			for(int j = 0; j < N; j++) {
				if((i & (1<< j)) != 0) {
					team[j] = true;
				}
			}
//			반으로 나누어졌는지 확인
			for(int b = 0 ; b < N; b++) {
				if(team[b]) {
					cnt++;
				}
			}
//			반으로 나누어진 경우 솔루션 구현
			if(cnt == N/2) {
				solve();
			}
		}
		System.out.println(res);
	}
	
	static void solve() {
        int teamA = 0; 
        int teamB = 0;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j )	continue; // 능력치 없음
                if(team[i] != team[j]) continue;   //같은팀이 아니면 무시             
                if(team[i]) {
                	teamA += map[i][j];
                }
                else {
                	teamB += map[i][j];
                }
            }
        }
        res = Math.min(res, Math.abs(teamA-teamB));
    }

}

// 교수님 코드 쳐보며 다시 공부했습니다!
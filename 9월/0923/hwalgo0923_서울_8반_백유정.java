import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo0923_서울_8반_백유정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N][N];
		long[][][] dp = new long[N][N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp[0][1][0] = 1; // 0:가로 1:세로 2:대각선

		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if (map[i][j] == 0) {
					// 가로방향으로 현재칸으로 오는 경우
					if(j-1>=0) {
						dp[i][j][0] += dp[i][j-1][0];
						dp[i][j][0] += dp[i][j-1][2];
					}
					// 세로방향으로 현재칸으로 오는 경우
					if(i-1>=0) {
						dp[i][j][1] += dp[i-1][j][1];
						dp[i][j][1] += dp[i-1][j][2];
					}
					// 대각선으로 현재칸으로 오는 경우
					if(i-1>=0 && j-1>=0 && map[i-1][j]==0 && map[i][j-1]==0) {
						dp[i][j][2] += dp[i-1][j-1][0];
						dp[i][j][2] += dp[i-1][j-1][1];
						dp[i][j][2] += dp[i-1][j-1][2];
					}

				}
			}//for
		}//for
		System.out.println(dp[N-1][N-1][0]+dp[N-1][N-1][1]+dp[N-1][N-1][2]);
	}
}
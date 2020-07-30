import java.util.Scanner;

public class hwalgo0729_seoul_class8_baekyujeong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			int map[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			
			int Z = (N-M+1);
			int max = 0;
			int temp = 0;
			
			for(int i=0; i<Z; i++) {
				for(int j=0; j<Z; j++) {
					temp = 0;
					for(int a=i; a<i+M; a++) {
						for(int b=j; b<j+M; b++) {
							temp += map[a][b];
							
							if(temp>max) {
								max = temp;
							}
						}
					}
					
				}
			}
			
			System.out.println("#"+test_case+" "+max);
			
		}
		sc.close();
	}
}

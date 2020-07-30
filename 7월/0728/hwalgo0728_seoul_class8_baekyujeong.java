import java.util.Scanner;

public class hwalgo0728_seoul_class8_baekyujeong {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        
        for(int test_case = 1; test_case <= T; test_case++) 
        {

            int N = sc.nextInt();
            int map[][] = new int[N][N];
            int x = 0, y = -1;
            int cnt = 1;
            int change = 1;
            int t = N;
            
            while (true) {
                if(cnt > N*N) {
                    break;
                }
                for (int i = 0; i < t; i++) {
                    y = y + change;
                    map[x][y] = cnt;
                    cnt++;
                }
                t--;
                
                for (int i = 0; i < t; i++) {
                    x = x + change;
                    map[x][y] = cnt;
                    cnt++;

                }
                change *= -1;
            }
        
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(map[i][j]+" ");
                }
                System.out.println();
            }

        }

    }

}

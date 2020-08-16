import java.util.Scanner;

public class sw2005 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int line = sc.nextInt();
			int [][] arr  = new int [line][line];
			
			for(int i=0; i<line; i++) {
				for(int j=0; j<=i; j++) {
					arr[0][0] = 1;
					if(j==0 || j==line-1) {
						arr[i][j] = 1;
					}else {
						arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
					}
				}
			}
			System.out.println("#"+tc);
			
			for(int i=0; i<line; i++) {
				for(int j=0; j<=i; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		sc.close();
	}

}

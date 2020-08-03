import java.util.Scanner;

public class hw_algo0803_서울_8반_백유정 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int snack[] = new int[N];
			
			for(int i=0; i<N; i++) {
				snack[i] = sc.nextInt();
			}
			
			int max = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					int sum = snack[i]+snack[j];
					if(sum<=M && sum>=max) {
						max = sum;
					}
					max = 0;
				}
			}
			
			System.out.println("#"+tc+" "+max);
		}
	}

}


import java.io.IOException;
import java.util.Scanner;

public class sw1206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=10; tc++) {
			int r = sc.nextInt();
			int b[] = new int [r];
			int answer = 0;
			
			for(int i=0; i<b.length; i++) {
				b[i] = sc.nextInt();
			}
			
			for(int i=2; i<r-2; i++) {
			int max = Math.max(Math.max(b[i-2], b[i-1]), Math.max(b[i+1], b[i+2]));
				if(b[i]-max > 0) {
					answer += (b[i]-max);
				}
			}
			
			System.out.print("#"+tc+" "+answer);
			System.out.println();
		}
		sc.close();
	}
}

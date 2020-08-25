import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hw_algo0825_서울_8반_백유정 {
	static int n, m;
	static int map[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine().trim());
		map = new int[n][n];
		int num[] = new int[n];
		
		for(int i=0; i<n; i++) {
			String num1 = br.readLine();
			for(int j=0; j<n; j++) {
				num[j] = num1.charAt(j);
				map[i][j] = (int)num[j]-48;
			}
		}
		divide(0,0,n);
	}
	
	private static boolean check(int r, int c, int n) {
		int std = map[r][c];
		for(int i=r; i<r+n; i++) {
			for(int j=c; j<c+n; j++) {
				if(std!=map[i][j]) {
					return false;
				}
			}
		}
		m = std;
		return true;
	}
	
	private static void divide(int r, int c, int n) {
		if(check(r,c,n)) {
			System.out.print(m);
		} else {
			System.out.print("(");
			int s = n/2;
			for(int i=0; i<2; i++) {
				for(int j=0; j<2; j++) {
					divide(r+s*1,c+s*j,s);
				}
			}
			System.out.print(")");
		}
	}
	
}

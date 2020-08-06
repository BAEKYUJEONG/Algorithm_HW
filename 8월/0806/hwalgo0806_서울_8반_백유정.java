import java.util.Scanner;

public class hwalgo0806_서울_8반_백유정 {
	
	static int [] sour;
	static int [] bitter;
	static boolean [] visited;
	static int min;
	
	static void powerSet(int s, int b, int n, int idx) {
	    if(idx == n) {
	    	if(min > Math.abs(s-b)&&b!=0)
	    		min = Math.abs(s-b);
	        return;
	    }
	 
	    visited[idx] = true;
	    powerSet(s*sour[idx],b+bitter[idx], n, idx + 1);
	 
	    visited[idx] = false;
	    powerSet(s, b, n, idx + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int J = sc.nextInt();
		sour = new int[J];
		bitter = new int[J];
		visited = new boolean[J];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<J; i++) {
			sour[i] = sc.nextInt();
			bitter[i] = sc.nextInt();
		}
		
		powerSet(0, 1, J, 0);
		
		System.out.println(min);
		
		sc.close();
	}
}

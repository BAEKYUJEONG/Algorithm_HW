import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo1028_서울_8반_백유정 {

	static int  N,X,map[][],count;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine().trim());
		StringTokenizer st = null;
		for(int t=1; t<=TC; ++t) {
			st = new StringTokenizer(in.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			count = 0;
			for(int i=0; i<N; ++i) {
				st = new StringTokenizer(in.readLine().trim());
				for(int j=0; j<N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			process();
			System.out.println("#"+t+" "+count);
		}
	}
	private static void process() {
		for(int i=0; i<N; ++i) {
			if (makeRoadByRow(i)) count++;
			if (makeRoadByCol(i)) count++;
		}
	}

	private static boolean makeRoadByRow(int i) {
		int beforeHeight,size;
		beforeHeight = map[i][0];
		size = 1;
		
		for(int j=1; j<N; ++j) {
			if(beforeHeight==map[i][j]) { 
				size++;
			}else if(beforeHeight+1==map[i][j]) { 
				if(size<X) return false;
				beforeHeight++;
				size=1;
			}else if(beforeHeight-1==map[i][j]) {
				int count = 0;
				for(int k=j; k<N; ++k) {
					if(map[i][k] != beforeHeight-1) break;
					count++;
				}
				if(count<X) return false;
				j += (X-1); 
				beforeHeight--;
				size = 0;
			}else { 
				return false;
			}
		}
		return true;
	}
	
	private static boolean makeRoadByCol(int i) {
		int beforeHeight,size;
		beforeHeight = map[0][i];
		size = 1;
		
		for(int j=1; j<N; ++j) {
			if(beforeHeight==map[j][i]) {
				size++;
			}else if(beforeHeight+1==map[j][i]) { 
				if(size<X) return false;
				beforeHeight++;
				size=1;// 새로운 높이이므로 다시 카운팅해야함
			}else if(beforeHeight-1==map[j][i]) {
				int count = 0;
				for(int k=j; k<N; ++k) {
					if(map[k][i] != beforeHeight-1) break;
					count++;
				}
				if(count<X) return false;
				j += (X-1);
				beforeHeight--;
				size = 0;
			}else {
				return false;
			}
		}
		return true;
	}	
}
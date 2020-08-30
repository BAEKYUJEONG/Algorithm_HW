import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class hwalgo0828_서울_8반_백유정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int N = Integer.parseInt(st.nextToken()); //초밥 접시 수
		int d = Integer.parseInt(st.nextToken()); //초밥 가짓수
		int k = Integer.parseInt(st.nextToken()); //연속 먹는 접시 수
		int c = Integer.parseInt(st.nextToken()); //쿠폰번호
		
		int table[] = new int[N+k];
		int kind[] = new int[d+1];
		int count = 0;
		int max = 0;
		
		for(int i=0; i<N; i++) {
			table[i] = Integer.parseInt(br.readLine());
		}
		
		System.arraycopy(kind, 0, kind, N, k-1);
		//앞뒤로 최대 연속 먹는 접시에 방해를 주지 않기 위해 연속 먹는 접시 수 만큼 뒤로 처음부터 k개만큼 더 붙여준다.
		
		for(int i=0; i<k; i++) {
			if(kind[table[i]]++ == 0) 
				count++;
		}
		
		for(int i=1; i<N; i++) {
			if(kind[table[i+k-1]]++ == 0)
				count++;
			
			if(--kind[table[i-1]] < 1)
				count--;
			
			int tmp = count;
			if(kind[c] == 0)
				tmp++;
			
			if(tmp > max) {
				max = tmp;
			}
		}
		
		System.out.println();
		
	}
}

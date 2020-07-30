import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class hw_algo03_서울_8반_백유정 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		int[] Arr = new int[n];
		
		for(int i=0; i<n; i++) {
			int cnt = i;
			int tmp = Integer.parseInt(br.readLine());
			
			if(stack.isEmpty()) {
				stack.add(tmp);
				Arr[i] = 0;
			}else {
				while(!stack.isEmpty()) {
					if(stack.peek()>tmp) {
						Arr[i] = cnt;
						stack.add(tmp);
						break;
					}else {
						stack.pop();
						cnt--;
					}
				}
				if(stack.isEmpty()) {
					stack.add(tmp);
					Arr[i] = 0;
				}
			}
		}
		
		for(int i=0; i<n; i++)
			System.out.print(Arr[i]+" ");
		
	}

}

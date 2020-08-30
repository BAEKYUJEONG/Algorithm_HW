import java.util.Scanner;

public class hwalgo0826_서울_8반_백유정 {

	// 사방 둘레를 한칸씩 더 두어 범위 체크를 하지 않아도 되도록 크기 설정
	static int[][] board = new int[21][21];

	static int[] dx = {1, 0, 1, -1};
	static int[] dy = {0, 1, 1,  1};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				board[i][j] = sc.nextInt();
			}
		}
		sc.close();

		for (int i = 1; i < 20; i++) {
			for (int j = 1; j < 20; j++) {
				
				int currVal = board[i][j]; 
				if (currVal == 0)
					continue;

				for (int k = 0; k < 4; k++) {					
					int count = 1;
					int nx = dx[k];
					int ny = dy[k];
					
					// 지금 체크하려는 값이 이전에 체크된 값인지 확인하여 이전에 확인한 루틴이라면 가지치기 
					if (currVal == board[i + dx[k] * -1][j + dy[k] * -1]) continue;
					
					while (currVal == board[i + nx][j + ny]) {
						count++;
						nx = dx[k] * count;
						ny = dy[k] * count;
					}
					if (count == 5) {
						System.out.println(currVal);
						System.out.println(i + " " + j);
						System.exit(0);						
					}
				}
			}
		}
		System.out.println(0);
	}
}

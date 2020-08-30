import java.io.FileInputStream;
//import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class hwalgo0827_서울_8반_백유정 {

	static int R, C, answer;
	static char[][] map;
	static boolean[][]visit;
	static HashSet<Character> set;
	
	//방향좌표
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
                  //위 오 아 왼
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner scan = new Scanner(System.in);
		set = new HashSet<>();
		
		R = scan.nextInt();// nextInt() - next(), nextLine()
		C = scan.nextInt();

		map = new char[R][C];
		visit = new boolean[R][C];//기본값 전체false

		String s;
		for (int i = 0; i < R; i++) {
			s = scan.next();// "CAAB" "ADCB"
			// String str="CAAB";
			// 인덱스 0123
			for (int j = 0; j < C; j++) {
				// 배열초기화
				map[i][j] = s.charAt(j);
			}
		}
		// 입력확인
//	  for (int i = 0; i < R; i++) {
//		  System.out.println(Arrays.toString(map[i]));
//	  }

		dfs(0, 0, 1);
      
		System.out.println(answer);
		scan.close();
	}// main

	private static void dfs(int r, int c, int d) {
//		System.out.println("r="+r+",c="+c);
		int s = set.size(); //0
		set.add(map[r][c]); //1
		
		if(s == set.size())  //중복된 데이터가 입력되었다면
		  return;
		
		if(answer<d) answer=d; //이동한 거리값 얻기
	    visit[r][c]=true;		
		int nr,nc;
		for(int i=0; i<4; i++) {//네방향 인덱스 표현
			nr=r+dr[i];
			nc=c+dc[i];
			if(nr<0 || nr>=R || nc<0 || nc>=C) continue;//범위밖인덱스 체크
			
			if(!visit[nr][nc])
      	  dfs(nr,nc, d+1); //새로운 인덱스로 출발
      }
		
		set.remove(map[r][c]);
		visit[r][c]=false;
	}//dfs
}
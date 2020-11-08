import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class hwalgo1105_서울_8반_백유정 {
//Solution_d4_1868_파핑파핑지뢰찾기_BFS 
	public static int[] di={-1,-1, 0, 1, 1, 1, 0,-1};
	public static int[] dj={ 0, 1, 1, 1, 0,-1,-1,-1};
	//상,우상,우,우하,하,좌하,좌,좌상  (8방향 표현)
	
	public static int N;
	public static char[][] bomb;
	public static boolean[][] visit;
	public static Queue<int[]> queue;

	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());

		for(int tc=1; tc<=T; tc++){//테스트 케이스
			N=Integer.parseInt(br.readLine());
			bomb=new char[N][N];//폭탄정보 입력할 문자 배열
			visit=new boolean[N][N];//방문정보를 입력할 논리 배열
			queue=new LinkedList<int[]>();//bfs를 위한 자료구조

			for(int i=0; i<N; i++){
				String s=br.readLine();
				for(int j=0; j<N; j++){
					bomb[i][j]=s.charAt(j);//폭탄정보를 문자를 배열에 입력
				}
			}
			
			int ans=0;
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(bomb[i][j]!='.') continue; //폭탄이 없는 곳을 찾기
					if(count(i,j)==0){ //주위(8방)에 폭탄이 1개도 없다면 
						ans++;//[원클릭 증가]
						bfs(i,j);//원클릭한 곳과 원클릭 주위 8방의 숫자를 표기 
					}
				}
			}
			//여기까지 ans는 주위(8방)에 폭탄이 없어 한번의 클릭으로 숫자표현되는 곳을 카운트 한다.
			
			
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(bomb[i][j]=='.') ans++;
				}
			}
			//여기에서 ans는 주위에 1개 이상의 폭탄이 있어서 카운트 못한 것들을 카운트 한다.
			
			
			System.out.println("#"+tc+" "+ans);//최종 카운트값을 출력
		}
		br.close();
	}
	public static int count(int i,int j){//현재위치(i,j)를 기준으로 8방에 있는 폭탄의 수를 카운트
		int cnt=0;
		for(int d=0; d<8; d++){//주위 8방의 새로운 정보를 얻음
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && bomb[ni][nj]=='*') cnt++; //폭탄을 발견했다면 카운트
		}
		return cnt;
	}
	public static void bfs(int i,int j){
		visit[i][j]=true;//방문을 표시한다
		queue.offer(new int[]{i,j});//큐에 기준되는 위치(i,j)를 표시 ==> Point클래스를 사용해도 됨.
		                        //1차원 배열 0번지:행,  배열 1번지:열 표현
		while(!queue.isEmpty()){
			int[] ij=queue.poll();
			i=ij[0];//행 정보
			j=ij[1];//열 정보			

			int cnt=count(i,j);//현위치의 주위의 폭탄을 카운트
			bomb[i][j]=(char)(cnt+'0');//현위치의 주위 폭탄수를 폭탄배열에 표기			
			if(cnt!=0) continue; //주위에 폭탄이 (1개라도)있다면 stop 
			
			for(int d=0; d<8; d++){//주위에 폭탄이 한개도 없다면 확장해서 8방향으로 검사 
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && bomb[ni][nj]=='.' && !visit[ni][nj]) {
					//이동한 위치에 방문하지 않은 곳에 폭탄도 없다면 queue에 입력하여 검사
					visit[ni][nj]=true;//방문표시
					queue.offer(new int[]{ni,nj});//폭탄없는 기준위치 저장
				}
			}
		}
	}
}
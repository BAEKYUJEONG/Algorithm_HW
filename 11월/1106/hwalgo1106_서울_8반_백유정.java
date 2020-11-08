import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class hwalgo1106_서울_8반_백유정{
//Main_15685_드레곤커브
	
	    static boolean[][] map = new boolean[101][101];
	    static int[][] dir = {{0,1},{-1,0},{0,-1},{1,0}}; //우상좌하
	    static int N;
	    
	    public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	         
	        N = Integer.parseInt(br.readLine());//커브의 개수
	        
	        int x,y,d,g;
	        StringTokenizer st;
	        for(int i=0; i<N; i++){
                st=new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());//커브 시작열  (0~100)
                y = Integer.parseInt(st.nextToken());//커브 시작행  (0~100)
                d = Integer.parseInt(st.nextToken());//커브 시작방향  0 (→), 1 (↑), 2 (←), 3(↓)
                g = Integer.parseInt(st.nextToken());//커브 세대     (0~10)
                
                makeCurve(x,y,d,g);//세대수만큼 드레곤커브 만들기
	        }
	        
	        countRec();	 
	    }//main

		private static void makeCurve(int x, int y, int d, int g) {
/*
0세대 : 0

1세대 : 0             1 
      ==> 0세대   +  (0+1)

2세대 : 0 1           2     1
      ==> 1세대   +  (1+1) (0+1)

3세대 : 0 1 2 1       2      3      2      1
      ==> 2세대   +  (1+1)  (2+1)  (1+1)  (0+1)

4세대 : 0 1 2 1 2 3 2 1       2    3       0     3     2     3     2     1			
      ==> 3세대   +         (1+1) (2+1) (3+1=0) (2+1) (1+1) (2+1) (1+1) (0+1)
 */
	     
	            ArrayList<Integer> list = new ArrayList<>();
	            list.add(d);//시작 방향 저장
	            
	            for(int i=0; i<g; i++){ //세대수 만큼
	                int size = list.size();
	                for(int j=size-1; j>=0; j--){ //변경된 방향 저장
	                    int n = list.get(j);
	                    if(n==3){
	                    	list.add(0);
	                    }else{
	                    	list.add(n+1);
	                    }
	                }
	            }	             
	            drawRect(x,y, list);
	    }
	     
		private static void drawRect(int x, int y, ArrayList<Integer> list) {
			//리스트의 방향정보를 통해 드레곤커브 그리기 
			map[y][x] = true;
			for(int i=0; i<list.size(); i++){
				y = y+ dir[list.get(i)][0];
				x = x+ dir[list.get(i)][1];
				map[y][x] = true;
			}
		}
		
	    private static void countRec() {
	        int cnt = 0;
	        
	        for(int i=0; i<100; i++){
	            for(int j=0; j<100; j++){
	                
	            	//사각형 확인
	                if(map[i][j] && //기준
	                   map[i+dir[3][0]][j+dir[3][1]] && //아래  map[i+1][j]
	                   map[i+dir[0][0]][j+dir[0][1]] && //오른쪽 map[i][j+1]
	                   map[i+1][j+1]){//대각선
	                    cnt++;
	                }
	            }
	        }	         
	        System.out.println(cnt);	         
	    }
}
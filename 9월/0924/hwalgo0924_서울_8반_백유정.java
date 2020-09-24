import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class hwalgo0924_서울_8반_백유정 {
	
    static int N;    
    static int arr[][];
    static ArrayList<Point> list;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            
            list = new ArrayList<>();
            arr = new int[N+2][N+2];
            
            for(int i=0; i<N+2; i++)
               Arrays.fill(arr[i], 999999); 

            
            StringTokenizer st;
            
            for(int i=0; i<N+2; i++) {
                st = new StringTokenizer(br.readLine());
           
                list.add(new Point(Integer.parseInt(st.nextToken()),
                		           Integer.parseInt(st.nextToken()))
                		);
            }
            
            for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    if(i==j)
                     continue;
                    
                    Point p1 = list.get(i);
                    Point p2 = list.get(j);
                    
                    int dist = Math.abs(p1.x-p2.x)+Math.abs(p1.y-p2.y);
                    if(dist<=1000)
                        arr[i][j] = 1;
                }
            }

            floyd();

            if(0<arr[0][N+1] && arr[0][N+1]<999999)
                System.out.println("happy");
            else
                System.out.println("sad");
        }
    }//end main
    
    
    static void floyd() {
        for(int k=0; k<N+2; k++) {
            for(int i=0; i<N+2; i++) {
                for(int j=0; j<N+2; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j])
                       arr[i][j] = arr[i][k] + arr[k][j];
                }
            }
        }
    }
    
    static class Point{
    	int x,y;
    	
    	public Point(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}    	
    }
    
}//end class
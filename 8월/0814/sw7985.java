import java.util.Scanner;

public class sw7985 {
	static int tree [] = new int [3000];
	static int each_depth[][] = new int [12][1025];
	static int each_depth_idx[] = new int [12];
	static int depth_max = 0;
	static int newmap[] = new int [100000];
	
	static void search_depth(int start, int end, int depth) {
		if(depth > depth_max)
			return;
		int box = (end-start) / 2;
		each_depth[depth][each_depth_idx[depth]++] = tree[start + box];
		search_depth(start, start + box - 1, depth + 1);
		search_depth(start + box+1, end, depth + 1);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		newmap[0] = 1;
		
		for(int i=1; i<=11; i++) {
			newmap[i] = newmap[i-1]*2;
		}
		
		for(int tc=1; tc<=T; tc++) {
			depth_max = sc.nextInt();
			
			for(int i=0; i<newmap[depth_max]-1; i++) {
				tree[i] = sc.nextInt();
			}
			search_depth(0, newmap[depth_max]-2, 1);
			System.out.print("#"+tc+" ");
			int tree_idx = 0;
			
			for(int i=1; i<=depth_max; i++) {
				for(int j=0; j<each_depth_idx[i]; j++) {
					System.out.print(each_depth[i][j]+" ");
					each_depth[i][j] = 0;
					tree[tree_idx++] = 0;
				}
				each_depth_idx[i] = 0;
				System.out.println();
			}
		}
		sc.close();
	}

}

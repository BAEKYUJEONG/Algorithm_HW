package com.ssafy.algo;

import java.util.Scanner;

//º“±›¿Ô¿Ã ¡ﬂ√∏
public class Solution22  {

	public static void main(String[] args) {

		int dx[] = { 0, 0, 0,-1,1};
		int dy[] = { 0 , -1, 1,0,0};

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int test = 1; test <= t; test++) {
			int res = 0;
			int n = sc.nextInt();
			int num = sc.nextInt();
			boolean visited[][] = new boolean[n+1][n+1];
			int die = 0;
			for(int i=0;i<num;i++) {
				int y = sc.nextInt();
				int x= sc.nextInt();
				int dir = sc.nextInt();
				if(visited[y][x] == true) {
					die++;
					continue;
				}
				int nexty = y;
				int nextx = x;
				

				boolean flag = false;
				for(int k=3;k>0;k--) {
					nexty = nexty + dy[dir] * k;
					nextx = nextx + dx[dir] * k;
					
					if(nexty >= n || nexty < 0 || nextx >= n || nextx < 0) {
						flag = true;
						die++;
						break;
					}
					
					if(visited[nexty][nextx] == true) {
						die++;
						flag = true;
						break;
					}
					
				}
				if(flag)
					continue;
				visited[nexty][nextx] = true;
			}
			res = num - die;
			System.out.printf("#%d %d\n",test, res);			
		
		}
		sc.close();
	}

}
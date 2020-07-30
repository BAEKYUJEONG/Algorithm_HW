package com.ssafy.algo;

import java.util.Scanner;

public class Solution13 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T, N;
		int tc = 0;
		int max = 0;
		int ex_max = 0;
		
		T = sc.nextInt(); 
		
		while(T>tc){
			tc++;
			
			N = sc.nextInt();
			
			char [][] Ground = new char [N+2][N+2];
			
			//값 입력 받기
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					Ground[i][j] = sc.next().charAt(0);
				}
			}
			
			//주변 B로 채우기
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					if(i==0 || i==N+1 || j==0 || j==N+1) {
						Ground[i][j] = 'B';
					}
				}
			}
			
			// 모든 값에 대해
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					//겹쳐있는거 찾기
					if(Ground[i-1][j-1] == 'B' && Ground[i][j-1] == 'B' && Ground[i+1][j-1] == 'B'
							&& Ground[i-1][j] == 'B' && Ground[i][j] == 'B'  && Ground[i+1][j] == 'B'
							&& Ground[i-1][j+1] == 'B' && Ground[i][j+1] == 'B' && Ground[i+1][j+1] == 'B') {
						//가로 세로 탐색
						for(int a=1; a<=N; a++) {
							if(Ground[i][a] == 'B') {
								ex_max++;
							}
							if(Ground[a][j] == 'B') {
								ex_max++;
							}
						}
					}
					if(ex_max>max) {
						max = ex_max;
					} 
					ex_max = 0;
				}
			}
			
			System.out.println("#"+tc+" "+(max-1));
			
		}
		sc.close();
	}

}

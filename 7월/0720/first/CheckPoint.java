package com.java.first;

import java.util.Scanner;

public class CheckPoint {
	public static void main(String[] args) {
		
		int weight, height;
		int fat;
		
		Scanner scan = new Scanner(System.in);
		height= scan.nextInt();
		weight = scan.nextInt();
				
		fat = weight+100-height;
		
		System.out.println("비만수치는 "+fat+"입니다.");
		
		if(fat>0) {
			System.out.println("당신은 비만이군요.");
		}
		
	}

}

package com.java.first;

import java.util.Scanner;

public class Compute {
	public static void main(String[] args) {
		
		int num1, num2;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("µÎ °³ÀÇ Á¤¼ö ÀÔ·Â : ");
		num1 = scan.nextInt();
		num2 = scan.nextInt();
		
		System.out.println("°ö="+num1*num2);
		System.out.println("¸ò="+num1/num2);
	}

}

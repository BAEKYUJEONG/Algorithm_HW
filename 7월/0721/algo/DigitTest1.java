package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	static int zero, one, two, three, four, five, six, seven, eight, nine = 0;
	
	public static void main(String[] args) {
		int [] Array = new int [10000];
		int temp = 0;
		int num = 0;
		int sum = 0;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<Array.length; i++) {
			
			temp = sc.nextInt();
			
			if(temp!=0) {
				Array[i] = temp;
				sum++;
			}else {
				break;
			}
			temp = 0;
		}
		
		for(int i=0; i<sum; i++) {
			num = Array[i]/10;
			switch(num) {
			case 0 :
				zero++;
				break;
			case 1 :
				one++;
				break;
			case 2 :
				two++;
				break;
			case 3 :
				three++;
				break;
			case 4 :
				four++;
				break;
			case 5 :
				five++;
				break;
			case 6 :
				six++;
				break;
			case 7 :
				seven++;
			case 8 :
				eight++;
				break;
			case 9 :
				nine++;
				break;
			}
		}
		
		if(zero>0) {
			System.out.println("0 : "+zero+"개");
		}if(one>0) {
			System.out.println("1 : "+one+"개");
		}if(two>0) {
			System.out.println("2 : "+two+"개");
		}if(three>0) {
			System.out.println("3 : "+three+"개");
		}if(four>0) {
			System.out.println("4 : "+four+"개");
		}if(five>0) {
			System.out.println("5 : "+five+"개");
		}if(six>0) {
			System.out.println("6 : "+six+"개");
		}if(seven>0) {
			System.out.println("7 : "+seven+"개");
		}if(eight>0) {
			System.out.println("8 : "+eight+"개");
		}if(nine>0) {
			System.out.println("9 : "+nine+"개");
		}
		
	}
}

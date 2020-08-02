import java.util.Scanner;
import java.util.Stack;

public class hw_algo0731_서울_8반_백유정 {
	static Scanner sc = new Scanner(System.in);
	static Stack<Character> operator = new Stack<>();
	static Stack<Integer> sum = new Stack<>();
	
	static int priority(char c) {
		if(c == '*')
			return 1;
		else if(c == '+')
			return 0;
		else
			return -1;
	}
	
	static String convert_calc(String formula) {
		String str = "";
		for(int i=0; i<formula.length(); i++) {
			char f = formula.charAt(i);
			if(f-'0'>=0 && f-'0'<=9) {
				str += f;
			}else {
				if(operator.empty()) { //비어있을 때
					operator.push(f);
				}else if(!operator.empty() && priority(operator.peek())>=priority(f)) { //안비어있는데 지금 들어가는 것이 우선순위가 더 낮을 때
					str += operator.pop();
					operator.push(f);
				}else { //안비어있는데 지금 들어가는 것이 우선순위가 더 클 때 그냥 넣음
					operator.push(f);
				}
			}
		}
		
		while(!operator.empty()) {
			str += operator.pop();
		}
		
		return str;
	}
	
	static int postfix_calc(String formula) {
		int answer = 0;
		for(int i=0; i<formula.length(); i++) {
			char tmp = formula.charAt(i);
			if(tmp-'0'>=0 && tmp-'0'<=9) {
				sum.push(tmp-'0');
			}
			else {
				switch(tmp) {
				case '+':
					int plus = 0;
					plus += sum.pop();
					plus += sum.pop();
					sum.push(plus);
					break;
				case '*' :
					int multiply = 1;
					multiply *= sum.pop();
					multiply *= sum.pop();
					sum.push(multiply);
					break;
				}
			}
		}
		answer = sum.pop();
		return answer;
	}
	
	public static void main(String[] args) {
		String str = "";
		for(int i=0; i<10; i++) {
			str = sc.next();
			System.out.println("#"+(i+1)+" "+postfix_calc(convert_calc(str)));
		}
	}
}

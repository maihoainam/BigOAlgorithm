import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    ArrayList<String> expressions = new ArrayList<>();
    for(int i = 0; i < n ; i++) {
    	expressions.add(reader.next());
    }

    System.out.println(convert(expressions));
  }
  public static String convert(ArrayList<String> expressions) {
	  Stack<Character> stack = new Stack<>();
	  StringBuilder sb = new StringBuilder();
	  for(String expression : expressions) {
		  for(char ch : expression.toCharArray()) {
			  if(Character.isLetter(ch)) {
				  sb.append(ch);
			  }
			  if(isPush(ch)) {
				  stack.push(ch);
			  }
			  if(ch == ')') {
				  while(stack.peek() != '(') {
					  sb.append(stack.pop());
				  }
				  stack.pop();
			  }
		  }
		 while(!stack.empty()) {
			 sb.append(stack.pop());
		 }
		  sb.append("\n");
	  }
	  return sb.toString();
  }
  public static boolean isPush(char ch) {
	  return ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
  }
}

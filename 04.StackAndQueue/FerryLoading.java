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

    System.out.println(parse(expressions));
  }
  
  public static String parse(ArrayList<String> expressions) {
	  StringBuilder sb = new StringBuilder();
	  int count = 0;
	  int ans = 0;
	  for(String expression : expressions) {
		  Stack<Character> stack = new Stack<>();
		  count = 0;
		  ans = 0;
		  for(char ch : expression.toCharArray()) {
			  if(ch == '<') {
				  if(stack.empty())
					  ans = count;
				  stack.push(ch);
			  }
			  if(ch == '>') {
				  if(stack.empty()) {
					  break;
				  }
				  count++;
				  stack.pop();
			  }
		  }
		  if(!stack.empty()) count = ans;
		  sb.append(count*2 + "\n");
		  
	  }
	  return sb.toString();
  }
}

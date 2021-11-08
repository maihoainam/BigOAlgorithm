import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    String text = reader.next();
    System.out.println(count(text));


  }
  
  public static int count(String text) {
	  Stack<Integer> stack = new Stack<>();
	  StringBuilder convertedText = new StringBuilder();
	  for(char atom: text.toCharArray()) {
		  if((atom == '(' || Character.isLetter(atom)) && convertedText.length() > 0 && convertedText.charAt(convertedText.length()-1) != '(') {
			  convertedText.append("+"+atom);
		  }
		  else if(Character.isDigit(atom)) {
			  convertedText.append("*" + atom);
		  }
		  else {
			  convertedText.append(atom);
		  }
	  }
	  String rpnText = convert(convertedText.toString());
	  for(char ch : rpnText.toCharArray()) {
		  switch(ch) {
		  case '+':
			  stack.push(stack.pop() + stack.pop());
			  break;
		  case '*':
			  stack.push(stack.pop() * stack.pop());
			  break;
		  default:
			  stack.push(number(ch));	  
		  }
	  }
	  return stack.pop();
  }
  public static String convert(String expression) {
	  Stack<Character> stack = new Stack<>();
	  StringBuilder sb = new StringBuilder();

		  for(char ch : expression.toCharArray()) {
			  if(Character.isLetter(ch) || Character.isDigit(ch)) {
				  sb.append(ch);
			  }
			  while(ch == '+' &&  !stack.empty() && stack.peek() == '*') {
				  sb.append(stack.pop());
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
	  return sb.toString();
  }
  public static boolean isPush(char ch) {
	  return ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
  }
  public static int number(char ch) {
	  switch(ch) {
	  	case 'C':
	  		return 12;
	  	case 'O':
	  		return 16;
	  	case 'H':
	  		return 1;
	  }
	  return Character.getNumericValue(ch);
		  
  }
}


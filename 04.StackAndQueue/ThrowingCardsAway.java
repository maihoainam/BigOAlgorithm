import java.io.*;
import java.util.*;



public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    while(true) {
        int n = reader.nextInt();
        if(n == 0) break;
    	LinkedList<Integer> cards = new LinkedList<>();
        for(int i =n ; i > 0; i--) {
        	cards.push(i);
        }
        System.out.println(deck(cards));
    }
  }
  
  public static String deck(LinkedList<Integer> cards) {
	  if(cards.size() == 1) {
		  return "Discarded cards:\n"
		  		+ "Remaining card: " + cards.pop();
	  }
	  StringBuilder sb = new StringBuilder();
	  sb.append("Discarded cards: ");
	  while(cards.size() > 2) {
		  sb.append(cards.pop()+", ");
		  cards.add(cards.pop());
	  }
	  sb.append(cards.pop()+"\n");
	  sb.append("Remaining card: "+cards.pop());
	  return sb.toString().trim();
  }
  
}

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    ArrayList<ArrayList<Integer>> arrives = new ArrayList<>();
    while(n != 0) {
    	ArrayList<Integer> arrive = new ArrayList<>();
        for(int i = 0; i < n ; i++) {
        	arrive.add(reader.nextInt());
        }
        arrives.add(arrive);
        n = reader.nextInt();
    }
    for(ArrayList arrive : arrives)
    	System.out.println(isSortable(arrive));
  }
  
  public static String isSortable(ArrayList<Integer> arrives) {
	  Stack<Integer> order = new Stack<Integer>();
	  Stack<Integer> sideRoad = new Stack<>();

	  for(int i = 0 ; i < arrives.size(); i++) {
		  if(sideRoad.empty() || arrives.get(i) < sideRoad.peek()) {
			  sideRoad.add(arrives.get(i));
		  }
		  else {
			  while(!sideRoad.empty() && sideRoad.peek() < arrives.get(i)) {
				  if(!sideRoad.empty() && !order.empty() && sideRoad.peek() < order.peek())
					  return "no";
				  order.add(sideRoad.pop());
			  }
				  
			  sideRoad.add(arrives.get(i));
		  }
	  }
	  while(!sideRoad.empty()) {
		  if(order.empty()) {
			  order.add(sideRoad.pop());
		  }
		  if(sideRoad.peek() < order.peek()) {
			  return "no";
		  }
		  else {
			  order.add(sideRoad.pop());
		  }
	  }
	  return "yes";
  }
}

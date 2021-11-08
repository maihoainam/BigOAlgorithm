import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int k = reader.nextInt();
    int[][] arrays = new int[n][2]; 
    for(int i = 0; i < n ; i++) {
    	for(int j = 0; j < 2; j++)
    		arrays[i][j] = reader.nextInt();
    }

    System.out.println(process(arrays, k));
  }
  
  public static String process(int[][] arrays, int k) {
	  StringBuilder sb = new StringBuilder();
	  Queue<Long> queue = new LinkedList<>();
	  long time = 0;
	  for(int i = 0; i < arrays.length; i++) {
		  while(!queue.isEmpty() && queue.peek() <= arrays[i][0]) {
			  queue.remove();
		  }
		  if(queue.isEmpty()) {
			  time = arrays[i][0];
		  }
		  if(queue.size() <= k) {
			  time+= arrays[i][1];
			  queue.add(time);
			  sb.append(time + " ");
		  }
		  else {
			  sb.append("-1 ");
		  }

		  
	  }
	  return sb.toString();

  }
}

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int[] ranges = new int[n]; 
    for(int i = 0; i < n ; i++) {
    	ranges[i] = reader.nextInt();
    }

    System.out.println(longest(ranges));
  }
  
  public static int longest(int[] arrays) {
	  int result = 1;
	  int current = arrays[0];
	  int prev = -1;
	  int next = -1;
	  int prevCount = 0;
	  int currentCount = 1;
	  
	  for(int i = 1; i < arrays.length; i++) {
		  next = arrays[i];
		  if(next == current) {
			  currentCount++;
		  }
		  else if(next == prev) {
			  prevCount += currentCount;
			  prev = current;
			  current = next;
			  currentCount = 1; 
		  }
		  else {
			  result = Math.max(result, currentCount + prevCount);
			  prev = current;
			  current = next;
			  prevCount = currentCount;
			  currentCount = 1;
		  }
	  }
	  return Math.max(result, currentCount+prevCount);
  }
}
                                                                                                                                          
 

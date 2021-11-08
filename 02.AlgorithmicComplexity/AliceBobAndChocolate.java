import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int[] chocolates = new int[n]; 
    for(int i = 0; i < n ; i++) {
    	chocolates[i] = reader.nextInt();
    }

    System.out.println(eat(chocolates));
  }
  
  public static String eat(int[] chocolates) {
	  int alice = 0;
	  int bob = 0;
	  int aliceTime = 0;
	  int bobTime = 0;
	  int n = chocolates.length-1;
	  int i = 0;
	  while(i<=n) {
		  if(aliceTime <= bobTime) {
			  aliceTime+= chocolates[i];
			  alice++;
			  i++;
		  }
		  else {
			  bobTime += chocolates[n];
			  bob++;
			  n--;
		  }

		  if(n < 0 || i > chocolates.length-1 || n < i)
			  break;
	  }
	  return alice + " " + bob;
  }
}
                                                                                                                                          
 

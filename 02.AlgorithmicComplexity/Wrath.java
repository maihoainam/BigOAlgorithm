import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int[] cards = new int[n]; 
    for(int i = 0; i < n ; i++) {
    	cards[i] = reader.nextInt();
    }

    System.out.println(game(cards));
  }
  
  public static String game(int[] arrays) {
	  int serejaPoint = 0;
	  int dimaPoint = 0;
	  int n = arrays.length-1;
	  int i = 0;
	  while(i<=n) {
		  serejaPoint+= Math.max(arrays[i], arrays[n]);
		  if(arrays[i] > arrays[n]) {
			  i++;
		  }
		  else {
			  n--;
		  }
		  if(n < 0 || i > arrays.length-1 || n < i)
			  break;
		  dimaPoint+= Math.max(arrays[i], arrays[n]);
		  if(arrays[i] > arrays[n]) {
			  i++;
		  }
		  else {
			  n--;
		  }
	  }
	  return serejaPoint + " " + dimaPoint;
  import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int[] claws = new int[n]; 
    for(int i = 0; i < n ; i++) {
    	claws[i] = reader.nextInt();
    }

    System.out.println(wrath(claws));
  }
  
  public static int wrath(int[] claws) {
	  int count = 0;
	  int max = 0;
	  for(int i = claws.length-1; i>=0; i--) {
		  if(max == 0) {
			  count++;
		  }
		  else {
			  max--;
		  }
		  max = Math.max(claws[i], max);
	  }
	  
	  return count == 0 ? 1:count;
  }
}
                                                                                                                                          
 }
}

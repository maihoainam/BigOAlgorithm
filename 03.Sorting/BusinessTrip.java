import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int k = reader.nextInt();
    List<Integer> flowers = new ArrayList<>();
    for(int i = 0; i < 12 ; i++) {
    	flowers.add(reader.nextInt());
    }

    System.out.println(water(flowers, k));
  }
  
  public static int water(List<Integer> flowers, int k) {
	  if(  k == 0)
		  return 0;
	  Collections.sort(flowers, Collections.reverseOrder());
	  int result = 1;
	  int sum = 0;
	  for(int flower : flowers) {
		  sum+=flower;
		  if(sum < k)
			  result++;
		  else {
			  break;
		  }
	  }
	  return result == 13 ? -1 : result;
  }
}

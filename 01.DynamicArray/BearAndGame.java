import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int[] mins = new int[n];
    for (int i = 0; i < n; ++i) {
      mins[i] = reader.nextInt();
    }
    System.out.println(watch(mins));
  }
  public static int watch(int[] mins) {
	  if(mins[0] > 15) return 15;
	  for(int i = 1; i < mins.length; i++) {
		  if(mins[i-1] + 15 < mins[i])
			  return mins[i-1] +15;
		  else if(mins[i-1] + 15 >= 90)
			  return 90;
	  }
	  return mins[mins.length-1] + 15 < 90 ? mins[mins.length-1] + 15 : 90;
  }
}

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int k = reader.nextInt();
    List<Integer> towers = new ArrayList<>();
    for(int i = 0; i < k ; i++) {
    	towers.add(reader.nextInt());
    }

    System.out.println(bars(towers));
  }
  
  public static String bars(List<Integer> towers) {
	  int[] bars = new int[1001];
	  for(int tower : towers) {
		  bars[tower]++;
	  }
	  int count = 0;
	  int max = 0;
	  for(int bar : bars) {
		  if(bar != 0)
			  count++;
		  max = Math.max(bar, max);
	  }
	  return max + " " + count;

  }
}

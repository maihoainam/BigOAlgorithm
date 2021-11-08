import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int w = reader.nextInt();
    List<Double> cups = new ArrayList<>();
    for(int i = 0; i < n*2 ; i++) {
    	cups.add(reader.nextDouble());
    }

    System.out.println(water(cups, w));
  }
  
  public static double water(List<Double> cups, int w) {
	  Collections.sort(cups);
	  int n = cups.size()/2;
	  double gCup = Math.min(cups.get(0), cups.get(n)/2);
	  return Math.min(w, gCup *3*n );

  }
}

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    List<Integer> ratings = new ArrayList<>();
    for(int i = 0; i < n ; i++) {
    	ratings.add(reader.nextInt());
    }

    System.out.println(rank(ratings));
  }
  
  public static String rank(List<Integer> ratings) {
	  int[] ranks = new int[2001];
	  List<Integer> oRating = new ArrayList<>(ratings);
	  for(int rate : ratings) {
		  ranks[rate]++;
	  }
	  Collections.sort(ratings, Collections.reverseOrder());
	  StringBuilder result = new StringBuilder();
	  for(int rate : oRating) {
		  result.append(ratings.indexOf(rate)+1 + " ");
	  }
	  return result.toString();
	  


  }
}

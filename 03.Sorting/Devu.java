import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int k = reader.nextInt();
    List<Integer> chapters = new ArrayList<>();
    for(int i = 0; i < n ; i++) {
    	chapters.add(reader.nextInt());
    }

    System.out.println(hours(chapters, k));
  }
  
  public static long hours(List<Integer> chapters, int k) {
	  long time = 0;
	  Collections.sort(chapters);
	  for(long chap : chapters) {
		  time += chap*k;
		  if(k > 1) {
			  k--;
		  }
	  }
	  return time;
  }
}

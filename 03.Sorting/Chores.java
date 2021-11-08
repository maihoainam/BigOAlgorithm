import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int a = reader.nextInt();
    int b = reader.nextInt();
    List<Integer> chores = new ArrayList<>();
    for(int i = 0; i < n ; i++) {
    	chores.add(reader.nextInt());
    }

    System.out.println(findX(chores, a, b));
  }
  
  public static int findX(List<Integer> chores, int a, int b) {
	  Collections.sort(chores);
	  return chores.get(b)-chores.get(b-1);
  }
}

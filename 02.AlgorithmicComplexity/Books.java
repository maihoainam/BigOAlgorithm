import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int k = reader.nextInt();
    int[] books = new int[n];
    for (int i = 0; i < n; i++) {
      books[i] = reader.nextInt();
    }
    System.out.println(maxBooks(books, k));
  }
  
  public static int maxBooks(int[] books, int k) {
	  int maxCount = 0;
	  int count = 1;
	  int sum = 0;
	  for(int i = 0; i< books.length; i++) {
		  if(books[i] > k) continue;
		  sum = books[i];
		  count = 1;
		  for(int j = i+1; j < books.length; j++) {
			  if(sum + books[j] <= k) {
				  sum+= books[j];
				  count++;
			  }else {
				  break;
			  }
		  }
		  maxCount = Math.max(maxCount, count);
		  
	  }
	  return maxCount;
  }
}

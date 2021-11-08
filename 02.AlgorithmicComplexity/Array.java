import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int k = reader.nextInt();
    int[] arrays = new int[n]; 
    for(int i = 0; i < n ; i++) {
    	arrays[i] = reader.nextInt();
    }

    System.out.println(minByInclusion(arrays, k));
  }
  
  public static String minByInclusion1(int[] arrays, int k) {
	  if(k == 1)
		  return "1 1";
	  int[] tmp = new int[100001];
	  int count = 0;
	  for(int i = 0; i < arrays.length; i++) {
		  Arrays.fill(tmp, 0);
		  tmp[arrays[i]]++;
		  count = 1;
		  for(int j = i+1; j<arrays.length; j++) {
			  if(arrays[i] == arrays[j] ) {
				  break;
			  }
			  else {
				  if(tmp[arrays[j]] == 0) {
					  tmp[arrays[j]]++;
					  count++;
				  }
				  if(count == k) {
					  i++;
					  j++;
					  return i + " " + j;
				  }
			  }
		  }
		  
	  }
	  return "-1 -1";

  }
  public static String minByInclusion(int[] arrays, int k) {
	  int[] tmp = new int[100001];
	  int count = 0;
	  int i, j;
	  for(i = 0 ; i < arrays.length; i++) {
		  
		  if(tmp[arrays[i]] == 0) {
			  count++;
		  }
		  tmp[arrays[i]]++;
		  if(count == k)
		  	break;
	  }
	  for(j = 0; j< i; j++) {
		  if(tmp[arrays[j]] == 1)
			  break;
		  tmp[arrays[j]]--;
	  }
	  return count == k ? j+1  +" " + (i+1) : "-1 -1";

  }
}

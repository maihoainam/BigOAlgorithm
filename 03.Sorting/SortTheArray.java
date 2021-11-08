import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    List<Integer> arrays = new ArrayList<>();
    for(int i = 0; i < n ; i++) {
    	arrays.add(reader.nextInt());
    }

    System.out.println(checkSort(arrays));
  }
  
  public static String checkSort(List<Integer> arrays) {
	  int l = 0;
	  int r = 0;
	  boolean swapped = false;
	  if(arrays.size() == 1)
		  return "yes\n1 1";
	  for(int i = 0; i < arrays.size()-1; i++) {
		  if(arrays.get(i+1) > arrays.get(i)) {
			  if(i == arrays.size()-2) {
				  return "yes\n1 1";
			  }
			  continue;
		  }
		  l = i;
		  int j;
		  for(j = l; j < arrays.size()-1; j++) {
			  if(arrays.get(j+1) < arrays.get(j)) {
				  if(j == arrays.size()-2)
					  r = j+1;
				  continue;
			  }
			  r = j;
			  break;
		  }
		  Collections.sort(arrays.subList(l, r+1));
		  if((l == 0 || arrays.get(l) > arrays.get(l-1)) && (r == arrays.size()-1 || arrays.get(r) < arrays.get(r+1))) {
			  for(int k = r+1; k < arrays.size()-1; k++) {
				  if(arrays.get(k+1) < arrays.get(k)) {
					  return "no";
				  }
			  }
			  return "yes\n" + (l+1) + " " + (r+1); 
		  }
		  else {
			  break;
		  }
	  }
	  return "no";
  }
}

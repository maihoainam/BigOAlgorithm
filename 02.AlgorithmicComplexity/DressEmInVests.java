import java.io.*;
import java.util.*;

public class Main {
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int n = reader.nextInt();
    int m = reader.nextInt();
    int x = reader.nextInt();
    int y = reader.nextInt();
    int[] vetSize = new int[n]; 
    for(int i = 0; i < n ; i++) {
    	vetSize[i] = reader.nextInt();
    }

    int[] availVest = new int[m];
    for (int i = 0; i < m; i++) {
    	availVest[i] = reader.nextInt();
    }
    int i = 0, j = 0, count = 0;
    while(i < n && j < m) {
    	if(availVest[j] < vetSize[i] - x) {
    		j++;
    	}
    	else if( availVest[j] > vetSize[i] + y) {
    		i++;
    	}
    	else {
    		availVest[count] = ++j;
    		vetSize[count] = ++i;
    		count++;
    	}
    }
    System.out.println(count);
    for(int k = 0; k < count ; k++) {
    	System.out.println(vetSize[k] + " " + availVest[k]);
    }

  }
  
}

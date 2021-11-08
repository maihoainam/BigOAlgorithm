import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int X = reader.nextInt();
		int L = reader.nextInt();
		int N = reader.nextInt();
		int[] keys = new int[N];
		for (int i = 0; i < N; i++) {
			keys[i] = reader.nextInt();
		}
		System.out.println(findKey(keys, X, L));

	}

	public static int findKey(int[] keys, long X, int L) {
		Queue<Long> queue = new LinkedList<>();
		int[] count = new int[100000];
		for(int i = 0; i < count.length; i++) {
			count[i] = -1;
		}
		
		//int[] visited = new int[100001];
		queue.add((long) X);
		count[(int) X] = 0;
		long tmp = 0;
		while(!queue.isEmpty()) {
			X = queue.poll();
			if(X == L) {
				return count[L];
			}
			for(int key : keys) {
				tmp = (X*key)%100000;
				if(count[(int) tmp] == -1) {
					queue.add(tmp);
					count[(int) tmp] = count[(int) X]+1;
				}
				
			}
		}
		return -1;
	}

}

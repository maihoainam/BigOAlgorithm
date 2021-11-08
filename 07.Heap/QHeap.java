import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int Q = reader.nextInt();
		int[][] operations = new int[Q][2];
		for(int i = 0; i< Q; i++) {
			int n1 = reader.nextInt();
			if(n1 != 3) {
				operations[i][0] = n1;
				operations[i][1] = reader.nextInt();
			}
			else {
				operations[i][0] = n1;
				operations[i][1] = 0;
			}
		}
		System.out.println(print(operations));
	}
	public static String print(int[][] operations) {
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i = 0; i < operations.length; i++) {
			if(operations[i][0] == 1) {
				pq.add(operations[i][1]);
			}
			else if(operations[i][0] == 2) {
				pq.remove(operations[i][1]);
			}
			else if(operations[i][0] == 3) {
				sb.append(pq.peek()+"\n");
			}
		}
		
		return sb.toString().trim();
	}
}


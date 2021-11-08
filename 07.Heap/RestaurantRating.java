import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int Q = reader.nextInt();
		int[][] operations = new int[Q][2];
		for(int i = 0; i< Q; i++) {
			int n1 = reader.nextInt();
			if(n1 == 1) {
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
		PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxHeapComparator());
		PriorityQueue<Integer> ranking = new PriorityQueue<>();
		int top = 0;
		int count = 0;
		int newRank = 0;
		for(int i = 0; i < operations.length; i++) {

			if(operations[i][0] == 1) {
				count++;
				pq.add(operations[i][1]);
				top = count/3;
				if(top > ranking.size()) {
					ranking.add(pq.remove());
				}
				if( top == ranking.size() && !ranking.isEmpty() && pq.peek() > ranking.peek()) {
					newRank = ranking.remove();
					ranking.add(pq.remove());
					pq.add(newRank);
				}
			}
			else if(operations[i][0] == 2) {
				if(ranking.isEmpty()) {
					sb.append("No reviews yet\n");
				}
				else {
					sb.append(ranking.peek()+"\n");
				}
							
			}
		}
		
		return sb.toString().trim();
	}
}
class MaxHeapComparator implements Comparator<Integer>{
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}

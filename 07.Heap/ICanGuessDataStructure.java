import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		while (reader.hasNext()) {
			int n = reader.nextInt();
			int[][] operations = new int[n][2];
			Stack<Integer> stack = new Stack<>();
			Queue<Integer> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new MaxHeapComparator());
			int isStack = 1, isQueue = 1, isPQ = 1;
			for (int i = 0; i < n; i++) {
				int n1 = reader.nextInt();
				int n2 = reader.nextInt();
				if (n1 == 1) {
					operations[i][0] = n1;
					operations[i][1] = n2;
					stack.add(n2);
					queue.add(n2);
					pq.add(n2);
				} else {
					if (stack.pop() != n2)
						isStack = 0;
					if (queue.remove() != n2)
						isQueue = 0;
					if (pq.remove() != n2)
						isPQ = 0;
				}
			}
			if (isStack + isQueue + isPQ == 0) {
				System.out.println("impossible");
			} else if (isStack + isQueue + isPQ >= 2) {
				System.out.println("not sure");
			} else if (isStack == 1) {
				System.out.println("stack");

			} else if (isQueue == 1) {
				System.out.println("queue");

			} else if (isPQ == 1) {
				System.out.println("priority queue");

			}
		}
	}

}

class MaxHeapComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2.compareTo(o1);
	}
}

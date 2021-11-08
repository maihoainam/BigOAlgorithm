import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int N = reader.nextInt();
		while(N!=0) {
			ArrayList<Long> numbers = new ArrayList<>();
			for(int i = 0; i < N ; i++) {
				numbers.add(reader.nextLong());
			}
			System.out.println(addAll(numbers));
		
			N = reader.nextInt();
		}
	}
	public static long addAll(ArrayList<Long> numbers) {
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		pq.addAll(numbers);
		long result = 0;
		long num1, num2;
		while(pq.size() > 1) {
			num1 = pq.remove();
			num2 = pq.remove();
			result += num1 + num2;
			pq.add(num1 + num2);
		}
		
		return result;
	}
}


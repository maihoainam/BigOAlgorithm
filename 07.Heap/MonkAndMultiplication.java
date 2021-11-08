import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int N = reader.nextInt();
		ArrayList<Long> numbers = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			numbers.add(reader.nextLong());
		}
		System.out.println(monk(numbers));
	}

	public static String monk(ArrayList<Long> numbers) {
		if(numbers.size() == 1) return "-1";
		StringBuilder sb = new StringBuilder();
		sb.append("-1\n-1\n");
		if(numbers.size() ==2) return sb.toString().trim();
		PriorityQueue<Long> pq = new PriorityQueue<>(new MaxHeapComparator());
		pq.add(numbers.get(0));
		pq.add(numbers.get(1));
		long result = 1;
		for(int i = 2; i < numbers.size(); i++) {
			pq.add(numbers.get(i));
			long number1 = pq.remove();
			long number2 = pq.remove();
			long number3 = pq.remove();
			
			result = number1 * number2 *number3;
			pq.add(number1);
			pq.add(number2);
			pq.add(number3);
			sb.append(result+"\n");
		}
		return sb.toString().trim();
	}

}
class MaxHeapComparator implements Comparator<Long>{
	@Override
	public int compare(Long o1, Long o2) {
		return o2.compareTo(o1);
	}
}

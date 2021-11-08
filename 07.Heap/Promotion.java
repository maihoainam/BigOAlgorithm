import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		ArrayList<ArrayList<Long>> totalBills = new ArrayList<>();
		int n = reader.nextInt();
		for (int i = 0; i < n; i++) {
			int day = reader.nextInt();
			ArrayList<Long> dayBills = new ArrayList<>();
			for (int j = 0; j < day; j++) {
				dayBills.add(reader.nextLong());
			}
			totalBills.add(dayBills);
		}
		System.out.println(costOfPrice(totalBills));
	}

	public static long costOfPrice(ArrayList<ArrayList<Long>> bills) {
		long result = 0;
		PriorityQueue<Long> max = new PriorityQueue<>(new MaxHeapComparator());
		PriorityQueue<Long> min = new PriorityQueue<>();
		for (ArrayList<Long> bill : bills) {
			max.addAll(bill);
			min.addAll(bill);
			long largest = max.remove();
			long smallest = min.remove();
			result += largest - smallest;
			if (max.size() <50 && min.size() < 50) {
				max.remove(smallest);
				min.remove(largest);
			}else {
				max.remove(smallest);
				min.remove(largest);
			}

		}
		return result;
	}

}

class MaxHeapComparator implements Comparator<Long> {
	@Override
	public int compare(Long o1, Long o2) {
		return o2.compareTo(o1);
	}
}


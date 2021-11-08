
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int t = reader.nextInt();
		for (int k = 0; k < t; k++) {
			int N = reader.nextInt();
			ArrayList<Contract> contracts = new ArrayList<>();
			//ArrayList<ExtraPay> extraPays = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				double a = reader.nextInt();
				double b = reader.nextInt();
				double c = reader.nextInt();
				contracts.add(new Contract(a, b, c));
				//extraPays.add(new ExtraPay(a, b, c));

			}
			System.out.println(String.format("%.2f", extraPay(contracts)));

		}

	}

	public static double extraPay(ArrayList<Contract> contracts) {
		Collections.sort(contracts);

		PriorityQueue<ExtraPay> pq = new PriorityQueue<ExtraPay>();
		//pq.addAll(extraPays);
		double time = 0;
		double result = 0;
		for(Contract contract : contracts) {
			pq.add(new ExtraPay(contract.a, contract.b, contract.d));
			time += contract.b;
			if(time > contract.d) {
				while(true) {
					ExtraPay pay = pq.remove();
					if(time - pay.b <= contract.d) {
						result += (time - contract.d)/pay.a;
						pay.b -= time - contract.d;
						pq.add(pay);
						time = contract.d;
						break;
					}
					else {
						result += pay.b/pay.a;
						time -= pay.b; 
					}
				}
			}
			
		}
		return result;
	}
}

class Contract implements Comparable<Contract> {
	double a, b, d;

	public Contract(double a, double b, double d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}

	@Override
	public int compareTo(Contract o1) {
		if (o1.d < this.d)
			return 1;
		else {
			return -1;
		}

	}
}

class ExtraPay implements Comparable<ExtraPay> {
	double a, b, d;

	public ExtraPay(double a, double b, double d) {
		this.a = a;
		this.b = b;
		this.d = d;
	}

	@Override
	public int compareTo(ExtraPay o) {
		if (o.a > this.a)
			return 1;
		else {
			return -1;
		}
	}

}


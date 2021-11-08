import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;
	private static ArrayList<Boolean> visited;

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		V = reader.nextInt();
		E = reader.nextInt();
		graph = new ArrayList<>(V);
		visited = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			visited.add(false);
		}
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int s = reader.nextInt() - 1;
			int f = reader.nextInt() - 1;
			graph.get(s).add(f);
				
		}
		int max = 0;
		for(int i = 0 ; i < V; i++) {
			if(!visited.get(i))
			max = Math.max(max, DFS(i));
		}
		System.out.println(max);

	}

	public static int DFS(int s) {
		for (int i = 0; i < V; i++) {
			visited.set(i,false);
		}
		Stack<Integer> stack = new Stack<>();
		stack.add(s);
		visited.set(s, true);
		int count = 0;
		while(!stack.isEmpty()) {
			count++;
			int u = stack.pop();
			for(int v : graph.get(u)) {
				if(!visited.get(v)) {
					stack.add(v);
					visited.set(v, true);
				}
			}
		}
		return count;
	}

}


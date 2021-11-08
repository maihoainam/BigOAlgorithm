import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;

	private static ArrayList<Boolean> visited;

	private static void DFS(int s) {
		Stack<Integer> q = new Stack();

		visited.set(s, true);
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.pop();
			for (int i = 0; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);
				if (!visited.get(v)) {
					visited.set(v, true);
					q.add(v);
				}
			}
		}
	}



	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int T = reader.nextInt();
		for(int k = 0; k < T; k++) {
			V = reader.nextInt();
			E = reader.nextInt();
			if(E == 0) {
				System.out.println(V);
				continue;
			}
			graph = new ArrayList<>(V);
			for (int i = 0; i < V; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				int s = reader.nextInt();
				int f = reader.nextInt();
				graph.get(s).add(f);
				graph.get(f).add(s);
			}
			int count = 0;
			visited = new ArrayList<>();
			
			for (int i = 0; i < V; i++) {
				visited.add(false);
			}
			for(int i = 0 ; i < V; i++) {
				if(!visited.get(i)) {
					DFS(i);
					count++;
				}
			}
			System.out.println(count);
			
		}
		

	}

}

import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;
	private static ArrayList<Integer> path;
	private static ArrayList<Boolean> visited;

	private static void DFS(int s) {
		Stack<Integer> q = new Stack();
		path = new ArrayList<>();
		visited = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			visited.add(false);
			path.add(-1);
		}
		visited.set(s, true);
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.pop();
			for (int i = 0; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);
				if (!visited.get(v)) {
					visited.set(v, true);
					path.set(v, u);
					q.add(v);
				}
			}
		}
	}

	private static void printPath(int s, int f) {
		if (s == f) {
			System.out.println(s);
			return;
		}
		if (path.get(f) == -1) {
			System.out.println("No path");
			return;
		}
		ArrayList<Integer> b = new ArrayList<>();
		while (true) {
			b.add(f);
			f = path.get(f);
			if (s == f) {
				break;
			}
		}
		for (int i = b.size() - 1; i >= 0; i--) {
			System.out.println(b.get(i) + " ");
		}
	}

	private static int distance(int start, int finish) {
		if (start == finish)
			return 0;
		if (path.get(finish) == -1)
			return -1;
		int count = 0;
		while (true) {
			count++;
			finish = path.get(finish);
			if (start == finish)
				return count;
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		V = reader.nextInt();
		E = V - 1;
		graph = new ArrayList<>(V);
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			int s = reader.nextInt() - 1;
			int f = reader.nextInt() - 1;
			graph.get(s).add(f);
			graph.get(f).add(s);
		}
		int Q = reader.nextInt();
		int[] girls = new int[Q];
		for (int i = 0; i < Q; i++) {
			girls[i] = reader.nextInt() - 1;
		}
		Arrays.sort(girls);
		int start = 0;
		DFS(start);
		StringBuilder sb = new StringBuilder();
		int min = E;
		int result = 0;
		for (int i = 0; i < Q; i++) {
			int distance = distance(start, girls[i]);
			if (distance < min) {
				min = distance;
				result = girls[i];
			}
		}
		System.out.println(result + 1);

	}

}

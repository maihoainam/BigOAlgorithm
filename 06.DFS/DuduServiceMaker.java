import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;
	private static ArrayList<Boolean> visited;
	private static ArrayList<Boolean> isVisiting;

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int T = reader.nextInt();
		for (int k = 0; k < T; k++) {
			V = reader.nextInt();
			E = reader.nextInt();
			graph = new ArrayList<>(V);
			visited = new ArrayList<>();
			isVisiting = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				visited.add(false);
				isVisiting.add(false);
			}
			for (int i = 0; i < V; i++) {
				graph.add(new ArrayList<>());
			}
			for (int i = 0; i < E; i++) {
				int s = reader.nextInt() - 1;
				int f = reader.nextInt() - 1;
				graph.get(s).add(f);
			}
			boolean isLoop = false;
			for (int i = 0; i < V; i++) {
				if (!visited.get(i)) {
					if (DFS(i)) {
						isLoop = true;
					}
				}
			}
			if (isLoop)
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	public static boolean DFS(int s) {
		
		isVisiting.set(s, true);

		for (int v : graph.get(s)) {
			if (isVisiting.get(v))
				return true;
			if (!visited.get(v) && DFS(v))
				return true;
		}
		isVisiting.set(s, false);
		visited.set(s, true);
		return false;

	}

}


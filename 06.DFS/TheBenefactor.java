import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<ArrayList<Point>> graph;
	private static int V;
	private static int E;
	private static int[] distance;

	private static ArrayList<Boolean> visited;

	private static void DFS(int s) {
		Stack<Integer> q = new Stack();
		for (int i = 0; i < V+1; i++) {
			visited.set(i,false);
			distance[i] = 0;
		}
		visited.set(s, true);
		q.add(s);
		while (!q.isEmpty()) {
			int u = q.pop();
			for (int i = 0; i < graph.get(u).size(); i++) {
				Point v = graph.get(u).get(i);
				
				if (!visited.get(v.p)) {
					distance[v.p] = distance[u]+v.distance; 
					visited.set(v.p, true);
					q.add(v.p);
				}
			}
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int t = reader.nextInt();
		for(int k = 0; k < t; k++) {
			V = reader.nextInt();	
			E = V-1;
			graph = new ArrayList<>(V);
			visited = new ArrayList<>(V+1);
			distance = new int[V+1];
			for (int i = 0; i < V+1; i++) {
				graph.add(new ArrayList<>());
				visited.add(false);
			}
			for (int i = 0; i < E; i++) {
				int s = reader.nextInt();
				int f = reader.nextInt();
				int l = reader.nextInt();
				graph.get(s).add(new Point(f, l));
				graph.get(f).add(new Point(s,l));
			}
			int length = 0;
			int point = 0;
			DFS(1);
			for (int i = 2; i < V+1; i++) {
				if (distance[i] > length) {
					length = distance[i];
					point = i;
				}
			}
			int count = 0;
			DFS(point);
			for (int i = 1; i < V+1; i++) {
				if(i != point)
					count = Math.max(count,distance[i]);
			}
			System.out.println(count);
			
		}
		

	}

}
class Point{
	int p, distance;
	public Point(int p, int distance) {
		this.p = p;
		this.distance = distance;
	}
}

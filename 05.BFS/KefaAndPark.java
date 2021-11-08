import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;
	private static ArrayList<Integer> path;
	private static ArrayList<Boolean> visited;
	
	private static void BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		visited = new ArrayList<>();
		for(int i = 0; i < V; i++) {
			visited.add(false);
		}
		visited.set(s, true);
		q.add(s);
		while(!q.isEmpty()) {
			int u = q.remove();
			for(int i = 0 ; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);
				if(!visited.get(v)) {
					visited.set(v, true);
					q.add(v);
				}
			}
		}
	}
	
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    V = reader.nextInt();
    E = V-1;
	int M = reader.nextInt();
	graph = new ArrayList<>(V);
	int[] map = new int[V+1];
	for(int i = 0 ; i< V; i++) {
		map[i] = reader.nextInt();
		graph.add(new ArrayList<>());
	}
	for(int i = 0 ; i < E; i++) {
		int s = reader.nextInt()-1;
		int f = reader.nextInt()-1;
		graph.get(s).add(f);
		graph.get(f).add(s);
	}
	
	int count = 0;
	int[] cat = new int[V];
	
	Queue<Integer> q = new LinkedList<>();
	path = new ArrayList<>();
	visited = new ArrayList<>();
	for(int i = 0; i < V; i++) {
		visited.add(false);
		path.add(-1);
	}
	visited.set(0, true);
	q.add(0);
	while(!q.isEmpty()) {
		int u = q.remove();
		if(map[u] == 1) {
			if(path.get(u) == -1) cat[u] = 1;
			else cat[u] = cat[path.get(u)]+1;
		}
		else cat[u] = 0;
		if(graph.get(u).size() == 1 && u!=0) count++;
		for(int i = 0 ; i < graph.get(u).size(); i++) {
			int v = graph.get(u).get(i);
			if(!visited.get(v) && cat[u] + map[v] <= M) {
				visited.set(v, true);
				path.set(v, u);
				q.add(v);
			}
		}
	}
	System.out.println(count);


  }
  
}

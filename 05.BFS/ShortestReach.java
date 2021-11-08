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
		path = new ArrayList<>();
		visited = new ArrayList<>();
		for(int i = 0; i < V; i++) {
			visited.add(false);
			path.add(-1);
		}
		visited.set(s, true);
		q.add(s);
		while(!q.isEmpty()) {
			int u = q.remove();
			for(int i = 0 ; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);
				if(!visited.get(v)) {
					visited.set(v, true);
					path.set(v, u);
					q.add(v);
				}
			}
		}
	}
	
	private static void printPath(int s, int f) {
		if(s == f) {
			System.out.println(s);
			return;
		}
		if(path.get(f) == -1) {
			System.out.println("No path");
			return;
		}
		ArrayList<Integer> b = new ArrayList<>();
		while(true) {
			b.add(f);
			f = path.get(f);
			if(s == f) {
				break;
			}
		}
		for(int i = b.size()-1; i>=0; i--) {
			System.out.println(b.get(i) + " ");
		}
	}
	
	private static int distance(int start, int finish) {
		if(start == finish) return 0;
		if(path.get(finish) == -1) return -1;
		int count = 0;
		while(true) {
			count++;
			finish = path.get(finish);
			if(start == finish)
				return count;
		}
	}
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int q = reader.nextInt();
    for(int k = 0 ; k < q; k++) {
    	V = reader.nextInt();
    	E = reader.nextInt();
    	graph = new ArrayList<>(V);
    	for(int i = 0 ; i< V; i++) {
    		graph.add(new ArrayList<>());
    	}
    	for(int i = 0 ; i < E; i++) {
    		int s = reader.nextInt()-1;
    		int f = reader.nextInt()-1;
    		graph.get(s).add(f);
    		graph.get(f).add(s);
    	}
    	int start = reader.nextInt()-1;
    	BFS(start);
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < V; i++) {
    		if(i != start) {
    			int distance = distance(start, i);
    			if(distance != -1)
    				sb.append(distance*6 + " ");
    			else
    				sb.append(distance + " ");
    		}
    	}
    	System.out.println(sb.toString().trim());
    }


  }
  
}

import java.io.*;
import java.util.*;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;
	private static ArrayList<Boolean> visited;
	
	private static int BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		visited = new ArrayList<>();
		for(int i = 0; i < V; i++) {
			visited.add(false);
		}
		visited.set(s, true);
		q.add(s);
		int count = 0;
		while(!q.isEmpty()) {
			count++;
			int u = q.remove();
			for(int i = 0 ; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);
				if(!visited.get(v)) {
					visited.set(v, true);
					q.add(v);
				}
			}
		}
		return count;
	}
	

  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int T = reader.nextInt();
    for(int k = 1 ; k <= T; k++) {
    	int M = reader.nextInt();
    	int N = reader.nextInt();
    	int[][] map = new int[N][M];
    	int start = 0;
    	for(int i = 0 ; i < N; i++) {
    		String line = reader.next();
    		for(int j = 0; j < M; j++ ) {
    			if(line.charAt(j) == '.') {
    				map[i][j] = 1;
    			}
    			else if(line.charAt(j) == '@') {
    				map[i][j] = 1;
    				start = i*M + j;
    			}
    		}
    	}
    	System.out.println("Case " + k + ": " + validate(map, M, N, start));
    }


  }
  
  public static int validate(int[][] map, int M, int N, int s) {
	  if( M == 1 && N == 1) return 1;
	  graph = new ArrayList<>();
	  V = M*N;
	  if(M == 1) V = N*(N-1);

	  for(int i = 0 ; i < V; i++) {
		  graph.add(new ArrayList<>());
	  }
	  for(int i = 0; i < N; i++) {
		  for(int j = 0; j<M; j++) {
			  if(map[i][j] == 1) {
				  if(j >0 && map[i][j-1] == 1) {
					  graph.get(i*M+j).add(i*M+j-1);
					  graph.get(i*M+j-1).add(i*M+j);
				  }
				  if(j < M-1 && map[i][j+1] == 1) {
					  graph.get(i*M+j).add(i*M+j+1);
					  graph.get(i*M+j+1).add(i*M+j);
				  }
				  if(i > 0 && map[i-1][j] == 1) {
					  graph.get(i*M+j).add((i-1)*M+j);
					  graph.get((i-1)*M+j).add(i*M+j);
				  }
				  if(i < N-1 && map[i+1][j] == 1) {
					  graph.get(i*M+j).add((i+1)*M+j);
					  graph.get((i+1)*M+j).add(i*M+j);
				  }
			  }			  
		  }
	  }  
	  return BFS(s);
  }
  
}

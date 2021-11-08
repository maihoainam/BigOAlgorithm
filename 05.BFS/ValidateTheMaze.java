import java.io.*;
import java.util.*;

/*
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
	
	private static boolean isPath(int start, int finish) {
		if(path.get(finish) == -1) return false;
		while(true) {
			finish = path.get(finish);
			if(finish == -1) return false;
			if(start == finish)
				return true;
		}
	}
  public static void main(String args[]) throws Exception {
    Scanner reader = new Scanner(System.in);
    int T = reader.nextInt();
    for(int k = 0 ; k < T; k++) {
    	int M = reader.nextInt();
    	int N = reader.nextInt();
    	int[][] maze = new int[M][N];
    	for(int i = 0 ; i < M; i++) {
    		String line = reader.next();
    		for(int j = 0; j < N; j++ ) {
    			if(line.charAt(j) == '.') {
    				maze[i][j] = 1;
    			}
    		}
    	}
    	System.out.println(validate(maze, M, N));
    }


  }
  
  public static String validate(int[][] maze, int M, int N) {
	  int count = 0;
	  graph = new ArrayList<>();
	  V = M*N;
	  int start = -1;
	  int finish = -1;
	  for(int i = 0; i < M; i++) {
		  for(int j = 0; j<N; j++) {
			  if(maze[i][j] == 1) {
				  if(i == 0 || j == 0 || i == M-1 || j == N-1) {
					  count++;
					  if(count == 1) start = i*M + j;
					  else finish = i*M +j;
				  }
				  if(count > 2) {
					  return "invalid";
				  }
			  }	
		  }
	  }
	  if(count != 2) return "invalid";
	  if(count == 2 && (M == 1 || N ==1)) {
		  if(M == 1 && finish - start > 1) return "invalid";
		  if(N == 1 && finish - start > M) return "invalid";
		  return "valid";
	  }
	  for(int i = 0 ; i < M*N; i++) {
		  graph.add(new ArrayList<>());
	  }
	  for(int i = 0; i < M; i++) {
		  for(int j = 0; j<N; j++) {
			  if(maze[i][j] == 1) {
				  if(j >0 && maze[i][j-1] == 1) {
					  graph.get(i*M+j).add(i*M+j-1);
					  graph.get(i*M+j-1).add(i*M+j);
				  }
				  if(j < N-1 && maze[i][j+1] == 1) {
					  graph.get(i*M+j).add(i*M+j+1);
					  graph.get(i*M+j+1).add(i*M+j);
				  }
				  if(i > 0 && maze[i-1][j] == 1) {
					  graph.get(i*M+j).add((i-1)*M+j);
					  graph.get((i-1)*M+j).add(i*M+j);
				  }
				  if(i < M-1 && maze[i+1][j] == 1) {
					  graph.get(i*M+j).add((i+1)*M+j);
					  graph.get((i+1)*M+j).add(i*M+j);
				  }
			  }			  
		  }
	  }
	  BFS(start);
	  
	  
	  return isPath(start, finish) ? "valid" : "invalid";
  }
  
}
*/
public class Main {
	private static boolean[][] visited;
	private static int N, M;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int[][] maze;

	private static boolean BFS(Point s, Point f) {
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			Point u = q.remove();
			if(!u.compare(s) && u.compare(f)) return true;
			visited[u.x][u.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + u.x;
				int ny = dy[i] + u.y;
				if ((nx >= 0 && nx < M && ny >=0 && ny<N) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Point(nx,ny));
				}
			}
		}
		return false;
	}

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int T = reader.nextInt();
		for (int k = 0; k < T; k++) {

			M = reader.nextInt();
			N = reader.nextInt();
			visited = new boolean[M][N];
			maze = new int[M][N];
			for (int i = 0; i < M; i++) {
				String line = reader.next();
				for (int j = 0; j < N; j++) {
					if (line.charAt(j) == '.') {
						maze[i][j] = 1;
					}
					else {
						visited[i][j] = true;
					}
				}
			}
			System.out.println(validate(maze, M, N));
		}

	}

	public static String validate(int[][] maze, int M, int N) {
		int count = 0;
		Point start = new Point(-1, -1);
		Point finish = new Point(-1, -1);;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (maze[i][j] == 1) {
					if (i == 0 || j == 0 || i == M - 1 || j == N - 1) {
						count++;
						if (count == 1)
							start = new Point(i, j);
						else
							finish = new Point(i, j);
					}
					if (count > 2) {
						return "invalid";
					}
				}
			}
		}
		if (count != 2)
			return "invalid";
		
		return BFS(start, finish) ? "valid" : "invalid";
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean compare(Point p) {
		return this.x == p.x && this.y == p.y;
	}
}

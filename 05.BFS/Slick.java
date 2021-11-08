import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int V;
	private static int E;
	private static ArrayList<Boolean> visited;

	private static int BFS(int s) {
		Queue<Integer> q = new LinkedList<>();
		visited.set(s, true);
		q.add(s);
		int count = 0;
		while (!q.isEmpty()) {
			count++;
			int u = q.remove();
			for (int i = 0; i < graph.get(u).size(); i++) {
				int v = graph.get(u).get(i);
				if (!visited.get(v)) {
					visited.set(v, true);
					q.add(v);
				}
			}
		}
		return count;
	}

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int N = reader.nextInt();
		int M = reader.nextInt();

		while (N != 0 && M != 0) {
			visited = new ArrayList<>();
			graph = new ArrayList<>();
			V = M * N;
			if (M == 1 && N!=1) {
				V = N * (N - 1);

			}
				
			for (int i = 0; i < V; i++) {
				visited.add(true);
				graph.add(new ArrayList<>());
			}
			
			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int n = reader.nextInt();
					map[i][j] = n;
					if(n == 1) visited.set(i*M+j, false);
				}
			}
			System.out.println(slick(map, N, M));
			N = reader.nextInt();
			M = reader.nextInt();
		}

	}

	public static String slick(int[][] map, int N, int M) {
		if (M == 1 && N == 1 && map[0][0] == 1)
			return "1\n1 1";
		else if (M ==1 && N ==1 && map[0][0] == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		int[] result = new int[V+1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					if (j > 0 && map[i][j - 1] == 1) {
						graph.get(i * M + j).add(i * M + j - 1);
						graph.get(i * M + j - 1).add(i * M + j);
					}
					if (j < M - 1 && map[i][j + 1] == 1) {
						graph.get(i * M + j).add(i * M + j + 1);
						graph.get(i * M + j + 1).add(i * M + j);
					}
					if (i > 0 && map[i - 1][j] == 1) {
						graph.get(i * M + j).add((i - 1) * M + j);
						graph.get((i - 1) * M + j).add(i * M + j);
					}
					if (i < N - 1 && map[i + 1][j] == 1) {
						graph.get(i * M + j).add((i + 1) * M + j);
						graph.get((i + 1) * M + j).add(i * M + j);
					}
				}
			}
		}
		int count = 0;
		for(int i = 0 ; i < V; i++) {
			if(visited.get(i) == false) {
				result[BFS(i)]++;
				count++;
			}
		}
		sb.append(count + "\n");
		for(int i = 0; i < V+1; i++) {
			if(result[i]!=0) {
				sb.append(i + " " + result[i] + "\n");
			}
		}
		return sb.toString().trim();
	}
}*/

public class Main {
	private static boolean[][] visited;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, -1, 1 };
	private static int N,M;

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		N = reader.nextInt();
		M = reader.nextInt();

		while (N != 0 && M != 0) {
			visited = new boolean[N][M];

			int[][] map = new int[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					int n = reader.nextInt();
					map[i][j] = n;
					if (n == 0)
						visited[i][j] = true;
				}
			}
			System.out.println(slick(map, N, M));
			N = reader.nextInt();
			M = reader.nextInt();
		}
	}

	private static int BFS(Point s) {
		Queue<Point> q = new LinkedList<>();
		q.add(s);
		int count = 0;
		while (!q.isEmpty()) {
			count++;
			Point u = q.remove();
			visited[u.x][u.y] = true;
			for (int i = 0; i < 4; i++) {
				int nx = dx[i]+u.x;
				int ny = dy[i]+u.y;
				if ((nx>=0 && nx<N && ny>=0 && ny<M)&&!visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Point(nx, ny));
				}
			}
		}
		return count;
	}

	public static String slick(int[][] map, int N, int M) {
		if (M == 1 && N == 1 && map[0][0] == 1)
			return "1\n1 1";
		else if (M == 1 && N == 1 && map[0][0] == 0) {
			return "0";
		}
		int V = M*N;
		StringBuilder sb = new StringBuilder();
		int[] result = new int[V + 1];

		int count = 0;
		for (int i = 0; i < N; i++) {
			for(int j = 0 ; j < M; j++) {
				if (!visited[i][j]) {
					result[BFS(new Point(i,j))]++;
					count++;
				}
			}

		}
		sb.append(count + "\n");
		for (int i = 0; i < V + 1; i++) {
			if (result[i] != 0) {
				sb.append(i + " " + result[i] + "\n");
			}
		}
		return sb.toString().trim();
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int V;
	private static int E;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;

	private static Result BFS(Point s) {
		Queue<Point> q = new LinkedList<>();
		int sheep = 0;
		int wolf = 0;
		//visited.set(s, true);
		q.add(s);
		boolean isOpen = false;
		while (!q.isEmpty()) {
			Point u = q.remove();
			visited[u.x][u.y] = true;

			if (map[u.x][u.y] == 2)
				sheep++;
			else if (map[u.x][u.y] == 3)
				wolf++;
			if (u.x == 0 || u.x == N - 1 || u.y == 0 || u.y == M-1)
				isOpen = true;
			for (int i = 0; i < 4; i++) {
				int nx = u.x+dx[i];
				int ny = u.y+dy[i];
				if((nx >=0 && nx<N && ny>=0 && ny<M) &&!visited[nx][ny] && map[nx][ny] >= 1) {
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		if (!isOpen) {
			if (sheep > wolf)
				wolf = 0;
			else
				sheep = 0;
		}

		return new Result(sheep, wolf);
	}

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		N = reader.nextInt();
		M = reader.nextInt();
		V = M * N;

		map = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = reader.next();
			for (int j = 0; j < M; j++) {
				char n = line.charAt(j);
				// fence = 0 field = 1; sheep = 2; wolf = 3;
				if (n == '#') {
					map[i][j] = 0;
					visited[i][j] = true;

				} else if (n == '.') {
					map[i][j] = 1;
				} else if (n == 'k') {
					map[i][j] = 2;
				} else if (n == 'v') {
					map[i][j] = 3;
				}
			}
		}
		System.out.println(sheep(map, N, M));

	}

	public static String sheep(int[][] map, int N, int M) {
		int s = 0;
		int w = 0;
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				if (visited[i][j] == false) {
					Result r = BFS(new Point(i,j));
					s += r.sheep;
					w += r.wolf;
				}
			}

		}
		return s + " " + w;
	}
}

class Result {
	int sheep;
	int wolf;

	public Result(int s, int w) {
		this.sheep = s;
		this.wolf = w;
	}
}
class Point{
	int x, y;
	boolean visited;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.visited = false;
	}
	public void setVisited(boolean v) {
		this.visited = v;
	}
	public boolean getVisited() {
		return this.visited;
	}
}

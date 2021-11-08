import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static int V;
	private static int E,K;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visited;
	private static boolean[][] fillVisited;

	private static Lake DFS(Point s) {
		Stack<Point> q = new Stack<>();
		q.add(s);
		int count = 0;
		boolean isOpen = false;
		while (!q.isEmpty()) {
			Point u = q.pop();
			count++;
			visited[u.x][u.y] = true;
			if (u.x == 0 || u.x == N - 1 || u.y == 0 || u.y == M-1) {
				isOpen = true;
			}
			for (int i = 0; i < 4; i++) {
				int nx = u.x+dx[i];
				int ny = u.y+dy[i];
				if((nx >=0 && nx<N && ny>=0 && ny<M) &&!visited[nx][ny]) {
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		return isOpen ? null : new Lake(count, s);
	}
	
	private static void fillLake(Point s) {
		Stack<Point> stack = new Stack<>();
		stack.add(s);
		while(!stack.isEmpty()) {
			Point u = stack.pop();
			fillVisited[u.x][u.y] = true;
			map[u.x][u.y] = 0;
			for(int i = 0 ; i < 4; i++) {
				int nx = u.x +dx[i];
				int ny = u.y + dy[i];
				if(nx>=0 && nx<N && ny>=0 && ny<M && !fillVisited[nx][ny]) {
					stack.add(new Point(nx, ny));
					map[nx][ny] = 0;
				}
			}
			
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		N = reader.nextInt();
		M = reader.nextInt();
		K = reader.nextInt();
		V = M * N;

		map = new int[N][M];
		visited = new boolean[N][M];
		fillVisited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String line = reader.next();
			for (int j = 0; j < M; j++) {
				char n = line.charAt(j);
				// land = 0 water = 1;
				if (n == '*') {
					map[i][j] = 0;
					visited[i][j] = true;
					fillVisited[i][j] = true;

				} else if (n == '.') {
					map[i][j] = 1;
				}
			}
		}
		System.out.println(sheep(map, N, M, K));

	}

	public static String sheep(int[][] map, int N, int M, int K) {
		int countLake = 0;
		ArrayList<Lake> lakes = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				if (visited[i][j] == false) {
					Lake lake = DFS(new Point(i,j));
					if(lake!= null) {
						countLake++;
						lakes.add(lake);
					}
				}
			}
		}
		Collections.sort(lakes);
		int result = 0;
		for(Lake lake : lakes) {
			if(countLake == K) break;
			result += lake.getSize();
			fillLake(lake.getPoint());
			countLake--;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(result);
		for(int i = 0 ; i < N; i++) {
			sb.append("\n");
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0) sb.append("*");
				else sb.append(".");
			}
		}
		return sb.toString().trim();
	}
}

class Lake implements Comparable<Lake>{
	int size;
	Point start;

	public Lake(int size, Point start) {
		this.size = size;
		this.start = start;
	}
	public Point getPoint() {
		return this.start;
	}
	public int getSize() {
		return this.size;
	}
	@Override
	public int compareTo(Lake lake) {
		if(this.getSize() < lake.getSize()) return -1;
		else if(this.getSize() == lake.getSize()) return 0;
		else return 1;
	}
}
class Point{
	int x, y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

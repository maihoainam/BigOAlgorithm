import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static String alliswell = "ALLIZZWELL";
	private static int R, C;
	private static char[][] map;
	private static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };
	static boolean positive;

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		int t = reader.nextInt();
		for (int k = 0; k < t; k++) {
			R = reader.nextInt();
			C = reader.nextInt();
			map = new char[R][C];
			visited = new boolean[R][C];
			ArrayList<Point> aList = new ArrayList<>();
			for (int i = 0; i < R; i++) {
				String line = reader.next();
				for (int j = 0; j < C; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == 'A') {
						aList.add(new Point(i, j, 0));
					}
				}
			}
			if (aList.size() == 0) {
				System.out.println("NO");
				continue;
			}
			positive = false;
			for (Point a : aList) {
				for (boolean[] visit : visited) {
					Arrays.fill(visit, false);
				}
				mrESP(a);
				if(positive) break;
			}
			if (positive)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

	public static void mrESP(Point p) {
		visited[p.x][p.y] = true;

		if (p.pos == alliswell.length() - 1 && map[p.x][p.y] == 'L') {
			positive = true;
			return;
		}
		if (map[p.x][p.y] == alliswell.charAt(p.pos)) {
			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == alliswell.charAt(p.pos + 1)
						&& !visited[nx][ny]) {
					mrESP(new Point(nx, ny, p.pos + 1));
				}
			}

		}
		visited[p.x][p.y] = false;
	}

}

class Point {
	int x, y, pos;

	public Point(int x, int y, int p) {
		this.x = x;
		this.y = y;
		this.pos = p;
	}
}


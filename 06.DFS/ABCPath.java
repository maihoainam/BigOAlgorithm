import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	private static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static int R, C;
	private static char[][] map;
	private static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0, 1, 1, -1, -1 };
	static int[] dy = { 0, 0, -1, 1, 1, -1, 1, -1 };
	static int[][] count;

	public static void main(String args[]) throws Exception {
		Scanner reader = new Scanner(System.in);
		R = reader.nextInt();
		C = reader.nextInt();
		int num = 0;
		while (R != 0 || C != 0) {
			num++;
			map = new char[R][C];
			visited = new boolean[R][C];
			count = new int[R][C];
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
				System.out.println("Case " + num + ": " + 0);
				R = reader.nextInt();
				C = reader.nextInt();
				continue;
			}

			int max = 0;
			for (Point a : aList) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						visited[i][j] = false;
						count[i][j] = 0;
					}
				}
				mrESP(a, count[a.x][a.y]);
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						max = Math.max(max, count[i][j]);
					}
				}
			}
			System.out.println("Case " + num + ": " + max);
			R = reader.nextInt();
			C = reader.nextInt();

		}

	}

	public static void mrESP(Point p, int c) {
		count[p.x][p.y] = c + 1;
		visited[p.x][p.y] = true;
		if (p.pos == alphabet.length() - 1 && map[p.x][p.y] == 'Z') {
			return;
		}
		if (map[p.x][p.y] == alphabet.charAt(p.pos)) {
			for (int i = 0; i < 8; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx >= 0 && nx < R && ny >= 0 && ny < C && map[nx][ny] == alphabet.charAt(p.pos + 1)
						&& !visited[nx][ny]) {
					mrESP(new Point(nx, ny, p.pos + 1), count[p.x][p.y]);
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


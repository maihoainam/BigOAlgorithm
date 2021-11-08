import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static char[][] map;
	static int a, b,c,d,N,M;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	private static boolean DFS(int x, int y) {
		if(x > N || y > M || x<0|| y<0) return false;
		if(map[x][y] != '.') return x == c && y ==d;
		map[x][y] = 'X';
		for(int i = 0; i < 4; i++) {
			if(DFS(x+dx[i], y+dy[i])) return true;
		}
		return false;
	}

	public static void main(String args[]) throws Exception {
		map = new char[501][501];
		Scanner reader = new Scanner(System.in);

		N = reader.nextInt();
		M = reader.nextInt();
		for (int i = 0; i < N; i++) {
			String line = reader.next();
			for (int j = 0; j < M; j++) {
				map[i+1][j+1] = line.charAt(j);
			}
		}
		a = reader.nextInt();
		b= reader.nextInt();
		c = reader.nextInt();
		d= reader.nextInt();
		//System.out.println(dx.length + dy.length);
		map[a][b] = '.';
		System.out.println(DFS(a,b) ? "YES" : "NO");

	}

}


package 九搜索;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BFS_迷宮 {
	static int n = 30, m = 50;
	static char[][] map = new char[n][m];// 地图
	static int[] dx = { 0, 0, -1, 1 };// 移动单位数组
	static int[] dy = { -1, 1, 0, 0 };
	static char[] op = { 'L', 'R', 'U', 'D' };// 移动方向
	static int[][] flag = new int[n][m];// 是否已经路过

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// 存储地图
		List<String> ansList = new ArrayList<>();
		Deque<Pos> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			map[i] = scanner.next().toCharArray();
		}
		queue.offer(new Pos(0, 0, ""));
		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			flag[pos.x][pos.y] = 1;
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				if (nx >= 0 && ny >= 0 && nx <= n-1 && ny <= m-1 && flag[nx][ny] == 0 && map[nx][ny] == '0') {
					Pos npos = new Pos(nx, ny, pos.path + op[i]);
					if (nx == n-1 && ny == m-1) {
						ansList.add(npos.path);
						break;
					}
					queue.offer(npos);
				}

			}
		}
		int min = Integer.MAX_VALUE;
		for (String ans : ansList) {
			min = Math.min(min, ans.length());
		}
		List<String> ans = new ArrayList<>();
		for (String path : ansList) 
			if(path.length() == min)ans.add(path);
		Collections.sort(ans);
		System.out.println(ans.get(0));
		scanner.close();
	}
}

class Pos {
	public int x;// 行
	public int y;// 列
	public String path;

	public Pos() {
	}

	public Pos(int x, int y, String p) {
		this.x = x;
		this.y = y;
		this.path = p;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "行" + this.x + "列" + this.y + "路径" + this.path;
	}
}

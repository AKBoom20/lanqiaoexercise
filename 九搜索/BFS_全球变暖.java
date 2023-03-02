package 九搜索;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS_全球变暖 {
	static int n;
	static char[][] map;
	static int[][] flag;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		map = new char[n][n];
		flag = new int[n][n];
		for (int i = 0; i < n; i++)
			map[i] = scanner.next().toCharArray();
		scanner.close();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.' || flag[i][j] == 1)
					continue;
				// 如果发现一片还没有检查的陆地 开始检查这片陆地
				flag[i][j] = 1;
				int landcnt = 0, floodedcnt = 0;
				Node node = new Node(i, j);
				Deque<Node> landDeque = new LinkedList<>();
				landDeque.offer(node);
				while (!landDeque.isEmpty()) {
					node = landDeque.poll();
					landcnt++;
					flag[node.x][node.y] = 1;
					for (int k = 0; k < 4; k++) {
						int nx = node.x + dx[k];
						int ny = node.y + dy[k];
						if (nx < n && ny < n && nx >= 0 && ny >= 0 && flag[nx][ny] == 0) {
							if (map[nx][ny] == '.')// 如果检查到一片水 陆地被淹没
								node.f = 1;
							else if (map[nx][ny] == '#')// 如果检查到一片陆地 加入陆地队列
								landDeque.offer(new Node(nx, ny));
						}
					}
					if (node.f == 1)
						floodedcnt++;
				}
				// 检查陆地是否被淹没了
				if (floodedcnt == landcnt)
					ans++;
			}

		System.out.println(ans);
	}
}

class Node {
	int x;// 行
	int y;// 列
	int f;// 是否被淹没

	public Node() {
	}

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Node(int x, int y, int f) {
		this.x = x;
		this.y = y;
		this.f = f;
	}
}

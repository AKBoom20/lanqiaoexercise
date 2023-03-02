package 九搜索;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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

		Deque<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// 如果发现一片还没有检查的陆地 开始检查这片陆地
			if (map[node.x][node.y] == '#' && flag[node.x][node.y] == 0) {
				flag[node.x][node.y] = 1;
				Deque<Node> landDeque = new LinkedList<>();
				List<Node> landList = new ArrayList<>();
				landDeque.add(node);
				while (!landDeque.isEmpty()) {
					node = landDeque.poll();
					flag[node.x][node.y] = 1;
					landList.add(node);
					for (int i = 0; i < 4; i++) {
						int nx = node.x + dx[i];
						int ny = node.y + dy[i];
						if (nx < n && ny < n && nx >= 0 && ny >= 0 && flag[nx][ny] == 0) {
							if (map[nx][ny] == '.')// 如果检查到一片水 陆地被淹没
								node.f = 1;
							else if (map[nx][ny] == '#')// 如果检查到一片陆地 加入陆地队列
								landDeque.offer(new Node(nx, ny));
						}
					}
				}
				// 检查陆地是否被淹没了
				int flooded = 1;
				for (Node node2 : landList)
					if (node2.f == 0)
						flooded = 0;
				if (flooded == 1)
					ans++;
			}
			// 如果发现一片水域 继续查找四周
			else if (map[node.x][node.y] == '.' && flag[node.x][node.y] == 0) {
				flag[node.x][node.y] = 1;
				for (int i = 0; i < 4; i++) {
					int nx = node.x + dx[i];
					int ny = node.y + dy[i];
					if (nx < n && ny < n && nx >= 0 && ny >= 0 && flag[nx][ny] == 0)
						if (map[nx][ny] == '#')
							queue.add(new Node(nx, ny, 1));
						else
							queue.add(new Node(nx, ny));
				}

			}
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

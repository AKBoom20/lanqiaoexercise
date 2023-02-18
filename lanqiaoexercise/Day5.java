package lanqiaoexercise;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Day5 {

	static Scanner scanner = new Scanner(System.in);

	
	static int m = scanner.nextInt();
	static int n = scanner.nextInt();
	/* 地图和访问数组 */
	static int[][] map = new int[m][n];
	static boolean[][] flag = new boolean[m][n];
	/* 队列 */
	static Queue<Node> queue = new LinkedList<>();
	/* 方向步长 */
	static int[] x = { 0, 0, -1, 1 };
	static int[] y = { -1, 1, 0, 0 };
	/* 填充地图 */
	static {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
	}

	public static void main(String[] args) {
		/* 起点 */
		int i = scanner.nextInt() - 1;
		int j = scanner.nextInt() - 1;
		Node startNode = new Node(i, j, 0);
		queue.offer(startNode);
		flag[i][j] = true;

		int endx = scanner.nextInt() -1;
		int endy = scanner.nextInt() -1;

		while (!queue.isEmpty()) {
			/* 取出一个结点 */
			Node node = queue.poll();
			/* 如果到终点 则输出长度 */
			if (node.x == endx && node.y == endy) {
				System.out.println(node.path);
				return;
			}
			/* 没有到终点 利用队列BFS */
			for (int k = 0; k < 4; k++) {
				int nexti = node.x + x[k];
				int nextj = node.y + y[k];
				if (nexti >=0 && nexti < m && nextj >=0 && nextj < n && map[nexti][nextj] == 1
						&& flag[nexti][nextj] == false) {
					queue.offer(new Node(nexti,  nextj, node.path+1));
					flag[nexti][nextj] = true;
				}
			}
		}
		System.out.println(-1);
		scanner.close();

	}

}

/* 结点类型 */
class Node {
	int x;
	int y;
	int path;

	public Node(int x, int y, int path) {
		this.x = x;
		this.y = y;
		this.path = path;
	}
}

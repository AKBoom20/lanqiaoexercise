package 数据结构基础;

import java.util.Scanner;

public class 带权并查集_蓝桥部队 {

	static int[] p;// 士兵数组 存储士兵所在队头
	static int[] dist;// 存储每个士兵到队首距离
	static int[] size;// 存储每个列队的长度
	static int N;// 士兵数量
	static int M;// 询问数量

	// find操作
	static int find(int x) {
		if (x != p[x]) {
			// 先记录父亲结点
			int pr = p[x];
			p[x] = find(p[x]);//路径压缩
			dist[x] += dist[pr];
		}
		return p[x];
	}

	// union操作
	static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		// 如果祖先不同 进行合并
		if (px != py) {
			// x的祖先加到y队列的最末尾
			p[px] = py;
			dist[px] = size[py];
			size[py] += size[px];
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();

		p = new int[N + 1];
		dist = new int[N + 1];
		size = new int[N + 1];
		// 初始化数组
		for (int i = 1; i <= N; i++) {
			p[i] = i;
			dist[i] = 0;
			size[i] = 1;
		}

		for (int i = 0; i < M; i++) {
			int op = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			// x 所在列移动到 y所在列
			if (op == 1) {
				union(x, y);
			} else {
				if (find(x) == find(y))
					System.out.println(Math.abs(dist[x] - dist[y])-1);
				else
					System.out.println(-1);

			}
		}
		scanner.close();
	}
}

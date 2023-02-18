package 数据结构基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 并查集_蓝桥幼儿园 {
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] nmStrings = reader.readLine().split(" ");
		int N = Integer.parseInt(nmStrings[0]);
		int M = Integer.parseInt(nmStrings[1]);
		p = new int[N + 1];
		// 初始化并查集 每个结点的父亲设置为自己
		for (int i = 1; i <= N; i++)
			p[i] = i;
		for (int i = 0; i < M; i++) {
			String[] opString = reader.readLine().split(" ");
			int op = Integer.parseInt(opString[0]);
			int num1 = Integer.parseInt(opString[1]);
			int num2 = Integer.parseInt(opString[2]);
			if (op == 1)
				union(num1, num2);
			else
				System.out.println(find(num1) == find(num2) ? "YES" : "NO");

		}
	}

	/***
	 * 查找元素所在集合
	 * 
	 * @param x
	 * @return
	 */
	public static int find(int x) {
		// 结点不是祖宗结点 路径压缩 找到祖宗结点 路径上的所有点的父亲都设置为祖宗结点
		if (p[x] != x)
			p[x] = find(p[x]);
		return p[x]; // 结点是祖宗结点 直接返回
	}

	/***
	 * 合并两个集合
	 * 
	 * @param x
	 * @param y
	 */
	public static void union(int x, int y) {
		p[find(x)] = find(y);// x的祖宗连接到y的祖宗上 连接祖宗也是路径压缩的操作
	}

}

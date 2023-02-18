package 数据结构基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 种类并查集_蓝桥侦探 {

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] nmStrings = reader.readLine().split(" ");
		int N = Integer.parseInt(nmStrings[0]);
		int M = Integer.parseInt(nmStrings[1]);
		p = new int[2 * N + 1];
		for (int i = 1; i <= 2 * N; i++)
			p[i] = i;

		for (int i = 0; i < M; i++) {
			String[] testimony = reader.readLine().split(" ");
			int num1 = Integer.parseInt(testimony[0]);
			int num2 = Integer.parseInt(testimony[1]);
			if (find(num1) != find(num2)) {
				union(num1, num2 + N);
				union(num1 + N, num2);
			} else {
				System.out.println(num1);
				return;
			}

		}
		reader.close();
	}

	public static int find(int x) {
		if (p[x] != x)
			p[x] = find(p[x]);
		return p[x];
	}

	public static void union(int x, int y) {
		p[find(x)] = find(y);
	}
}

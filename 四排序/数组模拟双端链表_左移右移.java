package 四排序;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 数组模拟双端链表_左移右移 {
	static int N, M;
	static int[] valueArray;
	static int[] lindex;
	static int[] rindex;
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	static {
		try {
			String[] nmStrings = reader.readLine().split(" ");
			N = Integer.parseInt(nmStrings[0]);
			M = Integer.parseInt(nmStrings[1]);
			valueArray = new int[N + 2];
			lindex = new int[N + 2];
			rindex = new int[N + 2];
			lindex[0] = 1;
			rindex[0] = 2;
			lindex[1] = N + 1;
			rindex[1] = 0;
			lindex[2] = 0;
			rindex[2] = 3;
			rindex[N + 1] = 1;
			lindex[N + 1] = N;
			for (int i = 3; i <= N; i++) {
				lindex[i] = i - 1;
				rindex[i] = i + 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void insertLeft(int n) {
		// 第n个元素对应数组valueArray第n+1个位置
		// 如果是第一个元素 不用移动
		if (n == rindex[0] - 1)
			return;
		// 如果是最后一个元素
		else {

			lindex[rindex[n + 1]] = lindex[n + 1];
			rindex[lindex[n + 1]] = rindex[n + 1];

			lindex[n + 1] = 0;// 左边一个元素变成头节点
			lindex[rindex[0]] = n + 1;// 头节点右节点的左节点变成此节点
			rindex[n + 1] = rindex[0];// 右边一个元素变成原来头节点的右边一个结点
			rindex[0] = n + 1;
		}

	}

	public static void insertRight(int n) {
		// n是最后一个元素
		if (n == lindex[1] - 1)
			return;
		else {
			lindex[rindex[n + 1]] = lindex[n + 1];
			rindex[lindex[n + 1]] = rindex[n + 1];
			lindex[n + 1] = lindex[1];
			rindex[n + 1] = 1;
			rindex[lindex[1]] = n + 1;
			lindex[1] = n + 1;
		}
	}

	public static void main(String[] args) throws IOException {

		for (int i = 0; i < M; i++) {

			String[] opStrings = reader.readLine().split(" ");
			String opString = opStrings[0];
			int target = Integer.parseInt(opStrings[1]);
			if (opString.equals("L"))
				insertLeft(target);
			else
				insertRight(target);

		}
		int j = 0;
		while (rindex[j] != 1) {
			System.out.printf("%d ", rindex[j] - 1);
			j = rindex[j];
		}
		reader.close();

	}
}

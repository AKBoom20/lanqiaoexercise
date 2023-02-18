package lanqiaoexercise;

import java.util.HashSet;
import java.util.Set;

public class Day8 {

	static int[][] w = new int[2021][2021];
	/* 初始化邻接矩阵 */
	static {
		for (int i = 1; i <= 2021; i++) {
			for (int j = 1; j <= 2021; j++) {
				int sum1 = 0, sum2 = 0;
				Set<Integer> set = new HashSet<>();
				set.add(i % 10);
				set.add((i / 10) % 10);
				set.add((i / 100) % 10);
				set.add((i / 1000));
				for (Integer integer : set) {
					sum1 += integer;
				}
				set.clear();
				set.add(j % 10);
				set.add((j / 10) % 10);
				set.add((j / 100) % 10);
				set.add((j / 1000));
				for (Integer integer : set) {
					sum2 += integer;
				}
				w[i - 1][j - 1] = sum1 + sum2;
			}
		}
	}

	public static void main(String[] args) {
		
		Prim(666);
	}

	public static void Prim(int v) {
		// 判断点是否访问过 也可以理解成集合
		int[] visited = new int[2021];
		// v这个点已经被访问了，从这个点开始访问
		visited[v] = 1;

		int minWeight = Integer.MAX_VALUE;// 定义初始值为最大值，只要出现小的就会替换
		int sum = 0;
		int h = v;
		//循环2020次 访问所有点 生成2020条边
		for (int k = 1; k <= 2020; k++) {
			for (int i = 1; i <= 2021; i++) {// 遍历已经访问过的点
				if (visited[i-1] == 1) {
					for (int j = 1; j <= 2021; j++) {// 遍历没有访问过的点
						// 在未访问点中寻找所有与访问过的点相连的边中权值最小值
						if ( visited[j-1] == 0 && w[i-1][j-1] < minWeight) {
							minWeight = w[i-1][j-1];
							h = j - 1;
						}
					}
				}
			}
			sum += minWeight; // 求最小生成熟的总权值
			// 然后标记点
			visited[h] = 1;
			// 将权值重新变成最大值
			minWeight = Integer.MAX_VALUE;
		}
		System.out.println(sum);

	}

}

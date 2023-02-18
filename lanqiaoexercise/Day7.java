package lanqiaoexercise;

import java.util.Scanner;

public class Day7 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println(lianGongZhuang());
	}

	public static String isHuiWenChuan() {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		scanner.close();
		int p1 = 0, p2 = s.length() - 1;
		while (p1 < p2) {
			if (s.charAt(p1) == s.charAt(p2)) {
				p1++;
				p2--;
			} else
				return "N";
		}
		return "Y";
	}

	public static long lianGongZhuang() {
		Scanner scanner = new Scanner(System.in);
		/* 练功桩数量 */
		int n = scanner.nextInt();
		/* 练功次数 */
		int m = scanner.nextInt();

		/* 原数组 */
		int[] loss = new int[n];
		/* 一阶差分 */
		int[] gap1 = new int[n];
		/* 二阶差分 */
		int[] gap2 = new int[n];

		for (int i = 0; i < m; i++) {
			int l = scanner.nextInt();
			int r = scanner.nextInt();
			int s = scanner.nextInt();
			int e = scanner.nextInt();
			/* 等差数列公差 */
			int d;
			if (r != l) {
				d = (e - s) / (r - l);
			} else
				d = 0;
			/*
			 * 只需要修改二阶差分数组 然后计算一阶差分数组 最后计算原数组
			 */
			gap2[l - 1] += s;
			gap2[l] += d - s;
			gap2[r] = gap2[r] - e - d;
			if(r+1 <= n-1)gap2[r + 1] += e;

		}
		gap1[0] = gap2[0];
		loss[0] = gap2[0];
		for (int i = 1; i < gap1.length; i++) {
			gap1[i] = gap2[i] + gap1[i - 1];
			loss[i] = gap1[i] + loss[i - 1];
		}
		int sum = 0;
		for (int i : loss) {
			sum += i;
		}
		scanner.close();
		return sum;
	}
}

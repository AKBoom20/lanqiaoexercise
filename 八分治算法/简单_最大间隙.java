package 八分治算法;

import java.util.Scanner;

public class 简单_最大间隙 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int ans = Integer.MIN_VALUE;
		int a = scanner.nextInt();
		for (int i = 1; i < N; i++) {
			int ai = scanner.nextInt();
			ans = Math.max(ans, ai - a);
			a = ai;
		}
		System.out.println(ans);
		scanner.close();
	}
}

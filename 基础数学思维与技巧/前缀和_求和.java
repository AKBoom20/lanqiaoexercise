package 基础数学思维与技巧;

import java.util.Scanner;

public class 前缀和_求和 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		// 前缀和数组
		int[] preSum = new int[n];
		preSum[0] = array[0];
		for (int i = 0; i < array.length; i++) {
			array[i] = scanner.nextInt();
			if (i > 0)
				preSum[i] = array[i] + preSum[i - 1];
		}
		scanner.close();

		long ans = 0, sumi = 0;
		for (int i = 0; i < n - 1; i++) {
			sumi = preSum[n - 1] - preSum[i];
			ans += array[i] * sumi;
		}
		System.out.println(ans);
	}

}

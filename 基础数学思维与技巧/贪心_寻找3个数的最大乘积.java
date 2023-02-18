package 基础数学思维与技巧;

import java.util.Arrays;
import java.util.Scanner;

public class 贪心_寻找3个数的最大乘积 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		scanner.close();
		Arrays.sort(array);
		int ans1 = array[n - 1] * array[n - 2] * array[n - 3];// 全正数和全负数的情况
		int ans2 = array[n - 1] * array[0] * array[1];// 有负数有正数可能的另一个最大值
		System.out.println(Math.max(ans1, ans2));

	}
}

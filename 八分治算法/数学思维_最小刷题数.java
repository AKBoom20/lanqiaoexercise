package 八分治算法;

import java.util.Arrays;
import java.util.Scanner;

public class 数学思维_最小刷题数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] amount = new int[N];
		int[] temp = new int[N];
		for (int i = 0; i < N; i++) {
			int num = scanner.nextInt();
			amount[i] = num;
			temp[i] = num;
		}
		// 存在一个中间刷题数 大于等于这个刷题数的学生 都不需要刷题了
		Arrays.sort(temp);
		// 找到临界值 统计比它大的有greater个 比它小的有less个
		int target = temp[N / 2];
		int greater = 0, less = 0;
		int k = N / 2 + 1;
		while (k < N - 1 && temp[k] == target)
			k++;
		greater = N - k;
		k = N / 2 - 1;
		while (k > 0 && temp[k] == target)
			k--;
		less = k + 1;
		if (greater < less) {
			for (int i = 0; i < N; i++) {
				int num = amount[i];
				if (num < target)
					System.out.print((target - num) + " ");
				else
					System.out.print(0 + " ");
			}
		} else if (greater == less) {
			for (int i = 0; i < N; i++) {
				int num = amount[i];
				if (num < target)
					System.out.print((target - num + 1) + " ");
				else
					System.out.print(0 + " ");
			}
		} else {
			for (int i = 0; i < N; i++) {
				int num = amount[i];
				if (num <= target)
					System.out.print((target - num + 1) + " ");
				else
					System.out.print(0 + " ");
			}
		}
		scanner.close();
	}
}

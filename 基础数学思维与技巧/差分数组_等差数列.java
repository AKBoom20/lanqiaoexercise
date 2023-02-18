package 基础数学思维与技巧;

import java.util.Arrays;
import java.util.Scanner;

public class 差分数组_等差数列 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = scanner.nextInt();
		}
		scanner.close();
		if (N ==2) {
			System.out.println(2);
			return;
		}
		Arrays.sort(A);

		// 一阶差分数组
		int[] gap = new int[N - 1];// 丢掉第一个数 方便排序
		for (int i = 0; i < N - 1; i++)
			gap[i] = A[i + 1] - A[i];
		Arrays.sort(gap);
		// 找到一阶差分数组中最接近的两个数（不相等） 求最大公约数就是公差
		int target = Integer.MAX_VALUE, left = 0, right = 0, temp = 0;
		for (int i = 1; i < gap.length; i++) {
			temp = gap[i] - gap[i - 1];
			if (temp < target && temp != 0) {
				target = temp;
				left = i - 1;
				right = i;
			}
		}
		// 公差
		int differ = gap[right]*gap[left]==0?0:gcd(gap[right], gap[left]);
		// 从最小到最大 求项数
		System.out.println(differ==0?N:(A[N - 1] - A[0]) / differ + 1);
	}

	private static int gcd(int i, int j) {
		int a = Math.max(i, j);
		int b = Math.min(i, j);
		int r = a % b;
		a = b;
		b = r;
		return r == 0 ? a : gcd(a, b);
	}

}

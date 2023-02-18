package 排序;

import java.util.Scanner;

/*复杂度NK 超时*/
public class 枚举_Max最值差 {
	static int N, K;
	static int[] array;
	static {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();
		array = new int[N];
		for (int i = 0; i < array.length; i++)
			array[i] = scanner.nextInt();

		scanner.close();
	}

	public static void main(String[] args) {
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int j = (i - K) < 0 ? 0 : i - K;
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			for (int j2 = j; j2 <= i; j2++) {
				min = Math.min(min, array[j2]);
				max = Math.max(max, array[j2]);
			}
			ans = Math.max(ans, max - min);
		}
		System.out.println(ans);
	}
}

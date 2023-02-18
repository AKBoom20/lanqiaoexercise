package 排序;

import java.util.Scanner;
//超时 复杂度O(n2)
public class 枚举_百亿富翁 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[] house = new int[N];
		int[] left = new int[N];
		int[] right = new int[N];
		for (int i = 0; i < N; i++)
			house[i] = scanner.nextInt();
		scanner.close();
		for (int i = 0; i < N; i++) {
			// 找右边的
			int j = i;
			while (j < N && house[j] <= house[i])
				j++;
			right[i] = j < N ? j + 1 : -1;
			// 找左边的
			j = i;
			while (j >= 0 && house[j] <= house[i])
				j--;
			left[i] = j >= 0 ? j + 1 : -1;

		}
		for (int i = 0; i < N; i++) {
			System.out.printf("%d ", left[i]);
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.printf("%d ", right[i]);
		}

	}
}

package 基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 二分_美丽区间 {
	static int N, S;
	static int[] array;
	static long[] prefixSum;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] nsStrings = reader.readLine().split(" ");
			N = Integer.parseInt(nsStrings[0]);
			S = Integer.parseInt(nsStrings[1]);
			array = new int[N];
			prefixSum = new long[N + 1];
			String[] arrayString = reader.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				array[i] = Integer.parseInt(arrayString[i]);
				prefixSum[i + 1] = prefixSum[i] + array[i];
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		// 二分活动窗口大小 就是枚举答案 最大1e5
		int l = 1, r = N, mid = (l + r) / 2;
		// 不存在的情况特判
		if (prefixSum[N] < S)
			System.out.println(0);
		else {
			while (l <= r) {
				if (check(mid))
					r = mid - 1;
				else
					l = mid + 1;
				mid = (l + r) / 2;
			}
			System.out.println(l);
		}

	}

	private static boolean check(int mid) {
		for (int i = 0; i <= N - mid; i++)
			if (prefixSum[mid + i] - prefixSum[i] >= S)
				return true;
		return false;
	}
}

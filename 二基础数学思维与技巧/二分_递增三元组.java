package 二基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*https://www.lanqiao.cn/courses/11020/learning/?id=595722&compatibility=false
*/
public class 二分_递增三元组 {
	static Integer n;
	static Integer[] A, B, C;
	static long ans;

	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(reader.readLine());
			A = new Integer[n];
			B = new Integer[n];
			C = new Integer[n];
			String[] inputStrings = new String[n];
			inputStrings = reader.readLine().split(" ");
			for (int i = 0; i < n; i++)
				A[i] = Integer.parseInt(inputStrings[i]);

			inputStrings = reader.readLine().split(" ");
			for (int i = 0; i < n; i++)
				B[i] = Integer.parseInt(inputStrings[i]);

			inputStrings = reader.readLine().split(" ");
			for (int i = 0; i < n; i++)
				C[i] = Integer.parseInt(inputStrings[i]);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {
		Arrays.sort(A);
		Arrays.sort(C);
		for (int i = 0; i < n; i++)
			ans += check(B[i]);
		System.out.println(ans);
	}

	public static long check(int target) {
		int l = 0, r = n - 1, mid = (l + r) / 2;
		long countA = 0, countC = 0;
		// A中二分查找临界元素 最后一个小于target的元素
		while (l <= r) {
			if (A[mid] >= target)
				r = mid - 1;
			else if (A[mid] < target)
				l = mid + 1;
			mid = (l + r) / 2;
		}
		countA = l;
		// C中二分查找临界元素 第一个大于target的元素
		l = 0;
		r = n - 1;
		mid = (l + r) / 2;
		while (l <= r) {
			if (C[mid] > target)
				r = mid - 1;
			else if (C[mid] <= target)
				l = mid + 1;
			mid = (l + r) / 2;
		}
		countC = n - r - 1;
		return countA * countC;
	}
}

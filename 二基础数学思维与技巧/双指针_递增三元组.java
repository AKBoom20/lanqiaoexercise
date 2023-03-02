package 二基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 双指针_递增三元组 {
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
		// 遍历B 双指针遍历A和C
		for (int i = 0; i < n; i++) {
			int j = 0, k = n - 1;
			int countA = 0, countC = 0;
			while (j <= n - 1 && A[j] < B[i]) {
				j++;
				countA++;
			}
			while (k >= 0 && C[k] > B[i]) {
				k--;
				countC++;
			}
			ans += countA * countC;
		}
		System.out.println(ans);
	}

}

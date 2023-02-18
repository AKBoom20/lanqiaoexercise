package 基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 枚举_递增三元组 {

	static Integer n;
	static Integer[] A, B, C;

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

	public static void main(String[] args) throws IOException {
		Arrays.sort(A, (a, b) -> (a - b));
		Arrays.sort(B, (a, b) -> (b - a));
		Arrays.sort(C, (a, b) -> (b - a));
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] > B[0])
				break;
			for (int j = 0; j < n; j++) {
				if (B[j] > A[i]) {
					for (int k = 0; k < n; k++) {
						if (C[k] > B[j])
							ans++;
						else
							break;
					}
				} else
					break;
			}

		}
		System.out.println(ans);
	}
}

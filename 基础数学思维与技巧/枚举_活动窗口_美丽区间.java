package 基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 枚举_活动窗口_美丽区间 {
	static int N, S;
	static int[] array;
	static int[] prefixSum;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] nsStrings = reader.readLine().split(" ");
			N = Integer.parseInt(nsStrings[0]);
			S = Integer.parseInt(nsStrings[1]);
			array = new int[N];
			String[] arrayString = reader.readLine().split(" ");
			prefixSum = new int[N + 1];
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

		int width = 1;
		while (width <= N) {
			for (int i = 0; i <= N - width; i++) {
				if (prefixSum[i + width] - prefixSum[i] >= S) {
					System.out.println(width);
					return;
				}

			}
			width++;
		}
	}
}

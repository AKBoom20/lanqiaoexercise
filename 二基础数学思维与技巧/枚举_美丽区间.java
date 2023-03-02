package 二基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 枚举_美丽区间 {
	static int N, S;
	static int[] array;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] nsStrings = reader.readLine().split(" ");
			N = Integer.parseInt(nsStrings[0]);
			S = Integer.parseInt(nsStrings[1]);
			array = new int[N];
			String[] arrayString = reader.readLine().split(" ");
			for (int i = 0; i < N; i++)
				array[i] = Integer.parseInt(arrayString[i]);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int sum = 0, j = i, length = 0;
			while (sum < S && j < N) {
				sum += array[j++];
				length++;
			}
			if (sum >= S)
				ans = Math.min(ans, length);
		}
		System.out.println(ans);
	}
}

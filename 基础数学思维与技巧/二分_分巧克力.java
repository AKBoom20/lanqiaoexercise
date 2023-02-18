package 基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 二分_分巧克力 {

	static int N, K;
	static int[][] area;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] nkString = reader.readLine().split(" ");
			N = Integer.parseInt(nkString[0]);
			K = Integer.parseInt(nkString[1]);
			area = new int[N][2];

			for (int i = 0; i < N; i++) {
				String[] s = reader.readLine().split(" ");
				area[i][0] = Integer.parseInt(s[0]);
				area[i][1] = Integer.parseInt(s[1]);
			}

			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		// 边长最小是1，最大是1e5
		int l = 1, r = 100000, mid = (l + r) / 2;
		// 二分
		while (l <= r) {
			if (check(mid))
				l = mid + 1;
			else
				r = mid - 1;
			mid = (l + r) / 2;
		}
		System.out.println(r);
	}

	private static boolean check(int mid) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (area[i][0] / mid) * (area[i][1] / mid);
			if (sum >= K)
				return true;
		}
		return false;
	}
}

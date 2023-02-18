package 排序;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 前缀和_K倍区间 {
	static int N, K;
	static long[] array;
	static long[] prefixSum;
	static long ans = 0;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] nkStrings = reader.readLine().split(" ");
			N = Integer.parseInt(nkStrings[0]);
			K = Integer.parseInt(nkStrings[1]);
			array = new long[N];
			prefixSum = new long[N + 1];
			for (int i = 0; i < N; i++) {
				array[i] = Long.parseLong(reader.readLine());
				prefixSum[i + 1] = prefixSum[i] + array[i];
				if (prefixSum[i + 1] % K == 0)
					ans++;

			}

			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			int remain = (int) (prefixSum[i] % K);
			map.put(remain, map.getOrDefault(remain, 0) + 1);
		}
		for (Integer key : map.keySet()) {
			long count = map.getOrDefault(key, 1) - 1;
			ans += (count + 1) * count / 2;
		}
		System.out.println(ans);
	}
}

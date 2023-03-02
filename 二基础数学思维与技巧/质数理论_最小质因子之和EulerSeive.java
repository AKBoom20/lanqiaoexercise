package 二基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 质数理论_最小质因子之和EulerSeive {
	/* 每个合数只被最小的质因子筛一次 amazing */

	// 缓存数组 存储2到3000000的所有数的最小质因子
	static int[] temp = new int[3000001];
	// temp的前缀和数组
	static long[] sum = new long[3000001];

	// 欧拉筛prime数组 存储2到3000000之间所有素数
	static int[] prime = new int[3000000];
	// 欧拉筛是否是素数的倍数（2倍以上）数组
	static boolean[] isMultiple = new boolean[30000001];
	// 素数个数
	static int count = 0;
	static {
		Arrays.fill(isMultiple, false);
	}

	public static void main(String[] args) throws IOException {
		EulerSeive(3000000);
		for (int i = 2; i < temp.length; i++) {
			sum[i] = sum[i-1] + temp[i];
		}
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int k = 0; k < T; k++) {
			int N = Integer.parseInt(bufferedReader.readLine());
			System.out.println(sum[N]);
		}
		bufferedReader.close();
	}

	public static void EulerSeive(int n) {
		for (int i = 2; i <= n; i++) {
			if (isMultiple[i] == false) {
				prime[count++] = i;
				temp[i] = i;
			}
			for (int j = 0; j < count && i * prime[j] <= n; j++) {
				// 素数是prime[j] 倍数是i 和埃式筛相反
				isMultiple[i * prime[j]] = true;
				temp[i * prime[j]] = prime[j];
				if (i % prime[j] == 0)
					break;
			}
		}
	}

}

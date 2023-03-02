package 八分治算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 数学思维_最大比例 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		String[] awardStrings = reader.readLine().split(" ");
		long[] award = new long[N];
		long[][] ratio = new long[2][N];
		for (int i = 0; i < N; i++)
			award[i] = Long.parseLong(awardStrings[i]);
		// 从小到大排序
		Arrays.sort(award);
		for (int i = 1; i < N; i++) {
			// 先求gcd 然后分子分母化简
			long gcd = gcd(award[i], award[i - 1]);
			ratio[0][i] = award[i] / gcd;// 分子
			ratio[1][i] = award[i - 1] / gcd;// 分母
		}

		// 用qgcd求最大公比
		long numerator = ratio[0][1];
		long denominator = ratio[1][1];
		for (int i = 1; i < N; i++) {
			numerator = qgcd(ratio[0][i], numerator);
			denominator = qgcd(ratio[1][i], denominator);
		}
		System.out.printf("%d/%d", numerator, denominator);
	}

	// 辗转相除法求gcd
	public static long gcd(long m, long n) {
		long a = m > n ? m : n;
		long b = m > n ? n : m;
		long r = a % b;
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;
	}

	// 已知两个数x = p^i,y = p^j 求p的类gcd算法
	public static long qgcd(long m, long n) {
		long a = m > n ? m : n;
		long b = m > n ? n : m;
		if (b == a)
			return a;
		else
			return qgcd(b, a / b);
	}
}

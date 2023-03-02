package 八分治算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 快速幂_数的幂次 {
	//快速幂
	public static long fastPower(long n, long m, long p) {
		long result = 1;
		while (m > 0) {
			if (m % 2 == 1)
				result = result * n % p;
			m = m / 2;
			n = n * n % p;
		}
		return result;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		long N, M, P;
		for (int i = 0; i < T; i++) {
			String[] nmpStrings = reader.readLine().split(" ");
			N = Long.parseLong(nmpStrings[0]);
			M = Long.parseLong(nmpStrings[1]);
			P = Long.parseLong(nmpStrings[2]);
			System.out.println(fastPower(N, M, P));
		}

		reader.close();

	}
}

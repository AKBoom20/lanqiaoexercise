package 基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class 质数理论_小蓝做实验 {

	static int count = 0;
	static long[] prime = new long[100000000];
	static boolean[] isMultiple = new boolean[100000001];
	static {
		Arrays.fill(isMultiple, false);
	}

	public static void main(String[] args) throws IOException {
		EulerSeive(100000000);
		int primeNum = 0;
		BufferedReader reader = new BufferedReader(new FileReader("D:\\primes.txt"));
		while (reader.ready()) {
			long n = Long.parseLong(reader.readLine());
			if (n >= 10000000 && n <= 100000000) {
				primeNum = isMultiple[(int) n] ? primeNum : primeNum + 1;
			} else {
				primeNum = checkPrime(n) ? primeNum + 1 : primeNum;
			}
		}
		reader.close();
		System.out.println(primeNum);
	}

	public static void EulerSeive(int n) {
		for (int i = 2; i <= n; i++) {
			if (isMultiple[i] == false)
				prime[count++] = i;
			for (int j = 0; j < count && i * prime[j] <= n; j++) {
				isMultiple[(int) (i * prime[j])] = true;
				if (i % prime[j] == 0)
					break;
			}
		}
	}

	public static boolean checkPrime(long number) {
		if (number == 2 || number == 3)
			return true;
		// 保证number在6的倍数的相邻位置 才有可能是prime
		if (number % 6 != 1 && number % 6 != 5)
			return false;
		// 只需要检查number有没有质数因子 因为合数可以分解为若干质数的乘积 因为保证了number在6的倍数附近 所以不可能是2或者3的倍数了
		for (int i = 5; i <= Math.sqrt(number); i += 6)
			if (number % i == 0 || number % (i + 2) == 0)
				return false;
		return true;

	}
}

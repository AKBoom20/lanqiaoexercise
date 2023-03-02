package 二基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 质数理论_最小质因子之和BF {
	public static void main(String[] args) throws IOException {
		long[] temp = new long[3000000];
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(bufferedReader.readLine());
		for (int k = 0; k < T; k++) {
			long sum = 0;
			int N = Integer.parseInt(bufferedReader.readLine());
			for (int i = N; i >= 2; i--) {
				if (temp[i-1] == 0 ) sum +=getMinPrime(i);
				else {
					sum+=temp[i-1];
					break;
				}
			}
			temp[N-1] = sum;
			System.out.println(sum);
		}
		bufferedReader.close();
	}

	private static int getMinPrime(int i) {
		for (int j = 2; j * j <= i; j++)
			if (i % j == 0)
				return j;
		return i;
	}
}

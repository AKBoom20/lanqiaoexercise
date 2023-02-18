package 基础数学思维与技巧;

import java.util.Scanner;

public class 质数理论_质因数个数 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		scanner.close();
		long sum = 0;
		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				sum++;
				while (n % i == 0)
					n = n / i;
			}
		}
		if(n > 1) sum++;
		System.out.println(sum);
	}
}

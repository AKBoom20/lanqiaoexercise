package 基础数学思维与技巧;

import java.util.Scanner;

public class 二分_求阶乘 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long k = scanner.nextLong();
		scanner.close();

		long low = 5, high = Long.MAX_VALUE - 5, mid = (low + high) / 2;
		while (low < high - 1) {

			while (facZeroNum(mid) < k && low < high - 1) {
				low = mid;
				mid = (low + high) / 2;
			}
			while (facZeroNum(mid) >= k && low < high - 1) {
				high = mid;
				mid = (low + high) / 2;
			}
		}
		if (facZeroNum(low) == k) System.out.println(low);
		else System.out.println(facZeroNum(high) == k ? high:-1);
			

		
	}

	public static long facZeroNum(long n) {
		// 5! = 5 4 3 2 1
		// 10！ = 10 9 8 7 6 5 4 3 2 1
		// 25! = 25 24 23 ... 5 4 3 2 1
		long count = 0;
		while (n > 0) {
			count += n / 5;
			n /= 5;
		}
		return count;
	}
}

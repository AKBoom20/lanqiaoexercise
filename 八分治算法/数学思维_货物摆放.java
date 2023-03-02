package 八分治算法;

public class 数学思维_货物摆放 {
	static long ans;

	public static void main(String[] args) {
		long n = 2021041820210418L;
		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				factor(n / i);
				if (n / i != i)
					factor(i);
			}

		}
		System.out.println(ans);
	}

	public static void factor(long a) {
		for (long i = 1; i <= Math.sqrt(a); i++) {
			if (a % i == 0) {
				ans++;
				if (a / i != i)
					ans++;
			}

		}
	}
}

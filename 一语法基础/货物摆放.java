package 一语法基础;

public class 货物摆放 {
	static long ans = 0;

	public static void main(String[] args) {
		long n = 2021041820210418L;
		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				factor(i);
				if (n / i != i) {
					factor(n / i);
				}
			}
		}
		System.out.println(ans);
	}

	private static void factor(long l) {

		for (long i = 1; i <= Math.sqrt(l); i++) {
			if (l % i == 0) {
				ans++;
				if (l / i != i)
					ans++;
			}
		}
	}
}

package 蓝桥5天集训;

public class 质数理论_超级质数 {
	// 2 3 5 7
	public static void main(String[] args) {
		//2开头 最大23
		//3开头 最大373
		//5开头 最大53
		//7开头 最大73
		System.out.println(isPrime(53) ? "Yes" : "No");
	}

	public static boolean isPrime(long num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				System.out.println(i);
				return false;
			}
		}
		return true;
	}

}

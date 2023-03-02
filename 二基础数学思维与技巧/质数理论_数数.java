package 二基础数学思维与技巧;

public class 质数理论_数数 {
	public static void main(String[] args) {
		// count统计最终答案 power统计每个数分解为质数乘积之后的指数之和 和为12的满足要求
		int count = 0, powerSum = 0;
		for (int i = 2333333; i <= 23333333; i++) {
			powerSum = 0;
			int temp = i;
			for (int j = 2; j * j <= temp; j++) {
				while (temp % j == 0) {
					powerSum++;
					temp /= j;
				}
			}
			if (temp > 1)
				powerSum++;
			if (powerSum == 12)
				count++;
		}
		System.out.println(count);
	}
}

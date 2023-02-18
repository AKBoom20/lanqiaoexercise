package 蓝桥5天集训;

import java.util.Scanner;

public class 二分_卡片 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		long low = 1, high = 100000;// 1e5 平方有1e10完全满足n=1e9时种类数
		long mid = (low + high) / 2;
		while (low < high - 1) {
			//  如果相等 直接输出
			if (mid * mid + mid ==2 * n) break;
			// 如果 大于 向小于找
			while ((mid * mid + mid > 2 * n) && low < high -1) {
				high = mid;
				mid = (low + high) / 2;
				System.out.printf("%d %d\n", low,high);
			} // 退出时找到了小于的地方
			while ((mid * mid + mid < 2 * n) && low < high -1) {
				low = mid;
				mid = (low + high) / 2;
				System.out.printf("%d %d\n", low,high);
			}
		}
		System.out.println(mid * mid + mid >=2 * n ?mid:mid+1);
	}
}

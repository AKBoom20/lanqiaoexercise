package 一语法基础;

import java.util.Scanner;

public class 贪心_最大化交易利润 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int length = scanner.nextInt();
		int profit = -Integer.MAX_VALUE;
		int min = scanner.nextInt();
		for (int i = 1; i < length; i++) {
			int price = scanner.nextInt();
			profit = Math.max(profit, price-min);
			min = Math.min(min, price);
		}
		scanner.close();
		System.out.println(profit);
	}
}

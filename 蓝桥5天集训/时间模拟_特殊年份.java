package 蓝桥5天集训;

import java.util.Scanner;

public class 时间模拟_特殊年份 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = 0, count = 0;
		for (int i = 0; i < 5; i++) {
			year = scanner.nextInt();
			count = check(year) ? count + 1 : count;
		}
		System.out.println(count);
		scanner.close();
	}

	private static boolean check(int year) {
		int a = year % 10, b = (year / 10) % 10, c = (year / 100) % 10, d = (year / 1000);
		if (d == b && a == c + 1)
			return true;
		return false;
	}
}

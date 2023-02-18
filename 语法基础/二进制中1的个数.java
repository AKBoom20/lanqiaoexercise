package 语法基础;

import java.util.Scanner;

public class 二进制中1的个数 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		int sum = 0;
		//条件必须是 !=0 保证负数的情况
		while (num != 0) {
			num &= num - 1;
			sum++;
		}
		System.out.println(sum);
		scanner.close();
	}
}

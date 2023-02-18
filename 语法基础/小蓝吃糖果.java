package 语法基础;

import java.util.Scanner;

public class 小蓝吃糖果 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		/*
		 * 第一行是整数n(0<n<1000000) 1e6
		 * 第二行包含n个数，表示n种糖果的数量
		 * mi，0<mi<10000000 1e6
		 */
		//1e6 * 1e6 超过1e10 int最大在20亿左右 不用long会爆掉
		long sum = 0;
		int max = 0;
		for (int i = 0; i < num; i++) {
			int candy = scanner.nextInt();
			sum+=candy;
			max = Math.max(max, candy);
		}
		scanner.close();
		System.out.println((max-1)*2 >= sum ? "No":"Yes");
	}
}

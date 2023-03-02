package 三字符串基础;

import java.util.Arrays;
import java.util.Scanner;

public class 排序_数位排序 {
	static int n;
	static int m;
	static Integer[] number;
	static {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		number = new Integer[n + 1];
		for (int i = 1; i <= n; i++)
			number[i] = i;

		scanner.close();
	}

	public static void main(String[] args) {
		//对Object排序不会改变相同元素的相对顺序
		Arrays.sort(number,1,n+1,(a,b)->(getBitSum(a) -getBitSum(b)));
		System.out.println(number[m]);
	}

	public static int getBitSum(int i) {
		int sum = 0;
		while (i != 0) {
			sum += i % 10;
			i /= 10;
		}
		return sum;
	}
}

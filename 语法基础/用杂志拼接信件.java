package 语法基础;

import java.util.Scanner;

public class 用杂志拼接信件 {
	public static void main(String[] args) {
		// 统计杂志字符数目
		int[] a = new int[26];
		// 统计信件字符数目
		int[] b = new int[26];

		Scanner scanner = new Scanner(System.in);
		String magazineString = scanner.nextLine();
		String mailString = scanner.nextLine();
		scanner.close();
		for (int i = 0; i < magazineString.length(); i++)
			a[magazineString.charAt(i) - 'a']++;
		for (int i = 0; i < mailString.length(); i++)
			b[mailString.charAt(i) - 'a']++;
		boolean flag = true;
		for (int i = 0; i < 26; i++) {
			if (b[i] > a[i]) {
				flag = false;
				break;
			}
		}
		System.out.println(flag ? "YES" : "NO");
	}
}

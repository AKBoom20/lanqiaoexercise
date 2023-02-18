package 字符串基础;

import java.util.Scanner;

public class 字符统计 {
	public static void main(String[] args) {
		int[] letter = new int[26];
		Scanner scanner = new Scanner(System.in);
		char[] s = scanner.next().toCharArray();
		scanner.close();
		for (int i = 0; i < s.length; i++)
			letter[s[i] - 'A']++;
		// 先遍历一遍 找到次数最多的
		int max = 0;
		for (int i = 0; i < letter.length; i++)
			max = Math.max(max, letter[i]);
		// 再遍历一遍 按照顺序输出次数等于max的
		for (int i = 0; i < letter.length; i++)
			if (letter[i] == max)
				System.out.printf("%c", 'A' + i);

	}
}

package 字符串基础;

import java.util.Arrays;
import java.util.Scanner;

public class 贡献思想_子串分值和 {
	// 统计上一次出现字母的下标
	static int[] lastIndex = new int[26];

	public static void main(String[] args) {
		long ans = 0;
		Arrays.fill(lastIndex, -1);
		Scanner scanner = new Scanner(System.in);
		String targetString = scanner.next();
		char[] targetArray = targetString.toCharArray();
		scanner.close();
		for (long i = 0; i < targetArray.length; i++) {
			ans += (i - lastIndex[targetArray[(int) i] - 'a']) * (targetArray.length - i);
			lastIndex[targetArray[(int) i] - 'a'] = (int) i;
		}
		System.out.println(ans);
	}
}

package 字符串基础;

import java.util.Scanner;

public class 贪心_重复字符串 {
	static int K;
	static String s;
	static {
		Scanner scanner = new Scanner(System.in);
		K = scanner.nextInt();
		s = scanner.next();
		scanner.close();
	}

	public static void main(String[] args) {
		// 除不尽 打印-1
		if (s.length() % K != 0) {
			System.out.println(-1);
			return;
		}
		// 遍历字符串一次 统计每个位置26个字母的个数 复杂度On
		// K次字符串 每个串的长度是S.length()/K 即周期
		int T = s.length() / K;
		int[][] letterCount = new int[T][26];
		char[] sArray = s.toCharArray();
		for (int i = 0; i < sArray.length; i++)
			letterCount[i % T][sArray[i] - 'a']++;

		int ans = 0;
		// 取所有位置的次数最大字符组成的字符串作为周期串就可以了 修改次数是其他字符出现次数之和
		for (int i = 0; i < T; i++) {
			// 遍历一遍找到最大字符
			char maxLetter = 'a';
			for (int j = 0; j < 26; j++)
				if (letterCount[i][j] > letterCount[i][maxLetter - 'a'])
					maxLetter = (char) (j + 'a');
			// 再遍历一遍计算修改次数
			for (int j = 0; j < 26; j++)
				if (j + 'a' != maxLetter)
					ans+=letterCount[i][j];
		}
		System.out.println(ans);
	}
}

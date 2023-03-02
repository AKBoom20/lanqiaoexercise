package 三字符串基础;

import java.util.Scanner;

public class 双指针_最长子序列 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		char[] S = scanner.next().toCharArray();
		char[] T = scanner.next().toCharArray();
		scanner.close();
		int i = 0, j = 0;
		while (i < S.length && j < T.length) {
			if(S[i] == T[j]) {
				i++;
				j++;
			}
			else i++;
		}
		System.out.println(j);
	}
}

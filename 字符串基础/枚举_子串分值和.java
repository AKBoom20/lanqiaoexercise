package 字符串基础;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/*时间复杂度n2 1e10超了*/
public class 枚举_子串分值和 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String targetString = scanner.next();
		char[] targetArray = targetString.toCharArray();
		scanner.close();
		Set<Character> set = new HashSet<>();
		long ans = 0;
		for (int i = 0; i < targetArray.length; i++) {
			set.add(targetArray[i]);
			for (int j = i; j < targetArray.length; j++) {
				set.add(targetArray[j]);
				ans += set.size();
			}
			set.clear();
		}
		System.out.println(ans);
	}
}

package 字符串基础;

import java.util.HashSet;
import java.util.Set;

public class 枚举_不同字串 {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		String target = "0100110001010001";
		for (int i = 1; i <= target.length(); i++) {
			for (int j = 0; j <= target.length() - i; j++) {
				String subsString = target.substring(j, j + i);
				set.add(subsString);
			}
		}
		System.out.println(set.size());
	}
}

package 字符串基础;

public class 进制理论_年号字串 {
	public static void main(String[] args) {
		StringBuilder ans = new StringBuilder("");
		int target = 26*26;
		// 26 进制
		// 余数 0 ~ 25 对应A ~ Z
		while (target != 0) {
			int remainder = target % 26;
			target = target / 26;
			ans = ans.insert(0, (char) ('A' + remainder));
		}
		System.out.println(ans);
	}
}

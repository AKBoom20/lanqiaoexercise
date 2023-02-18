package 基础数学思维与技巧;

import java.math.BigInteger;

public class 大数_棋盘放麦子 {
	public static void main(String[] args) {

		BigInteger num = new BigInteger("1");
		BigInteger sum = new BigInteger("1");
		for (int i = 2; i <= 64; i++) {
			num = num.add(num);
			sum = sum.add(num);
		}
		System.out.println(sum);
	}
}

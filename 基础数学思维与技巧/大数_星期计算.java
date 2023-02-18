package 基础数学思维与技巧;

import java.math.BigInteger;

public class 大数_星期计算 {

	public static void main(String[] args) {
		BigInteger base  = new BigInteger("20");
		BigInteger n = base.pow(22);
		System.out.println((n.mod(new BigInteger("7")).add(new BigInteger("6"))).mod(new BigInteger("7")));
				
	}
}

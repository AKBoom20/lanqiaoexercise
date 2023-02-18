package 语法基础;

import java.math.BigInteger;
import java.util.Scanner;

public class 乌托邦树 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		scanner.close();
		BigInteger height = new BigInteger("1");
		for (int i = 1; i <= n; i++)
			height = (i % 2 == 0) ? height.add(new BigInteger("1")) : height.add(height);
		System.out.println(height);
	}
}

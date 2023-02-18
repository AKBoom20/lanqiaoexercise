package lanqiaoexercise;

import java.util.Scanner;

public class Day6 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/* 商品数量 */
		int N = scanner.nextInt();
		/* 背包容量 */
		int V = scanner.nextInt();
		
		int[] w = new int[N+1];
		int[] v = new int[N+1];
		for (int i = 1; i <= N; i++) {
			w[i] = scanner.nextInt();
			v[i] = scanner.nextInt();
		}
		
		int[] dp = new int[V+1];
		
		for (int i = 1; i <=N; i++) {
			for (int j = V; j >=w[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
			}
		}
		System.out.println(dp[V]);
		scanner.close();
				
	}
}
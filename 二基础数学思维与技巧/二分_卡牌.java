package 二基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * https://www.lanqiao.cn/courses/11020/learning/?id=595718&compatibility=false
*/
public class 二分_卡牌 {
	static int N;
	static long M;
	static int[] cards, cardSupply;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] s = reader.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			M = Long.parseLong(s[1]);
			cards = new int[N];
			cardSupply = new int[N];
			s = reader.readLine().split(" ");
			for (int i = 0; i < N; i++)
				cards[i] = Integer.parseInt(s[i]);
			s = reader.readLine().split(" ");
			for (int i = 0; i < N; i++)
				cardSupply[i] = Integer.parseInt(s[i]);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		int l = 1, r = 400000;// 最少能组成l张牌 最多组成r张牌 2分找答案
		int mid = (l + r) / 2;
		while (l < r - 1) {
			if (check(mid, M))
				l = mid;
			else
				r = mid;
			mid = (l + r) / 2;
		}
		System.out.println(mid);
	}

	// 判断能不能组成n套卡牌
	public static boolean check(int n, Long m) {
		for (int i = 0; i < N; i++) {
			if (cards[i] >= n)
				continue;
			else if (cardSupply[i] + cards[i] >= n && n - cards[i] <= m) {
				m -= n - cards[i];
			} else
				return false;
		}
		return true;
	}
}

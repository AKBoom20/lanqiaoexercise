package 基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 二分_数列123 {
	static long[] blockSum = new long[2000001];
	static long[] prefixSum = new long[2000001];

	static {
		blockSum[1] = 1;
		prefixSum[1] = 1;
		for (int i = 2; i < blockSum.length; i++) {
			blockSum[i] = blockSum[i - 1] + i;
			prefixSum[i] = prefixSum[i - 1] + blockSum[i];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		for (int i = 0; i < T; i++) {
			String[] lrStrings = reader.readLine().split(" ");
			long l = Long.parseLong(lrStrings[0]);
			long r = Long.parseLong(lrStrings[1]);
			long lblock = whichBlock(l);
			long rblock = whichBlock(r);
			long lindex = l - lblock * (lblock - 1) / 2;// l在自己的块的第几个
			long rindex = r - rblock * (rblock - 1) / 2;// r在自己的块的第几个
			long lsum = prefixSum[(int) lblock - 1] + (1 + lindex) * lindex / 2;
			long rsum = prefixSum[(int) rblock - 1] + (1 + rindex) * rindex / 2;
			System.out.println(rsum - lsum + lindex);
		}
		reader.close();

	}

	public static long whichBlock(long pos) {
		long l = 1, r = 2 * (int) Math.sqrt(pos), mid = (l + r) / 2;// 至少在第一块 至多小于第r块
		while (l < r) {
			// 第mid块的最后一个位置小于pos 不可能在第mid块了 所以l = mid + 1
			if ((mid * mid + mid) / 2 < pos)
				l = mid + 1;
			// 第mid块的最后一个位置大于pos 还有可能在第mid块 所以r = mid
			else if ((mid * mid + mid) / 2 > pos)
				r = mid;
			// 第mid块的最后一个位置就是pos
			else
				return mid;
			mid = (l + r) / 2;
		}
		return l;

	}

}

package 基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 双指针_统计子矩阵 {
	static int N, M, K;
	static int[][] matrix;
	static int[][] prefixSum;
	static long ans;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] nmkString = reader.readLine().split(" ");
			N = Integer.parseInt(nmkString[0]);
			M = Integer.parseInt(nmkString[1]);
			K = Integer.parseInt(nmkString[2]);
			matrix = new int[N][M];
			prefixSum = new int[N][M];
			for (int i = 0; i < N; i++) {
				String[] s = reader.readLine().split(" ");
				for (int j = 0; j < M; j++)
					matrix[i][j] = Integer.parseInt(s[j]);
			}
			reader.close();
			// 生成二维前缀和矩阵
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i == 0 && j == 0)
						prefixSum[0][0] = matrix[0][0];
					else if (i == 0)
						prefixSum[0][j] = prefixSum[0][j - 1] + matrix[0][j];
					else if (j == 0)
						prefixSum[i][0] = prefixSum[i - 1][0] + matrix[i][0];
					else
						prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
								+ matrix[i][j];
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(prefixSum[i]));
		}
		for (int n1 = 0; n1 < N; n1++) {
			for (int n2 = n1; n2 < N; n2++) {
				// 连续子区间的和与K的大小关系可以用双指针来求 复杂度只有on
				int m1 = 0, m2 = 0;
				while (m2 < M) {
					while (m1 <= m2 && getSum(n1, n2, m1, m2) > K)
						m1++;
					ans += m2 - m1 + 1;
					m2++;

				}
			}
		}
		System.out.println(ans);

	}

	public static long getSum(int n1, int n2, int m1, int m2) {

		return prefixSum[n2][m2] + (n1 > 0 && m1 > 0 ? prefixSum[n1 - 1][m1 - 1] : 0)
				- (n1 > 0 ? prefixSum[n1 - 1][m2] : 0) - (m1 > 0 ? prefixSum[n2][m1 - 1] : 0);
	}
}

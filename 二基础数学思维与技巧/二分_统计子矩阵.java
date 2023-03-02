package 二基础数学思维与技巧;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 二分_统计子矩阵 {
	static int N, M, K;
	static int[][] matrix;
	static int[][] prefixSum;
	static int ans;
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
					for (int k = 0; k <= i; k++) {
						for (int q = 0; q <= j; q++) {
							prefixSum[i][j] += matrix[k][q];
						}
					}
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
				//此处采用枚举m1二分m2的做法复杂度是nlogn 总体复杂度是n^3logn 超时了 
				for (int m1 = 0; m1 < M; m1++) {
					// 二分找到子矩阵和小于等于K的临界点
					int l = m1, r = M - 1, mid = (l + r) / 2;
					while (l <= r) {
						if (getSum(n1, n2, m1, mid) > K)
							r = mid - 1;
						else
							l = mid + 1;
						mid = (r + l) / 2;
					}
					// r的位置就是最后一个满足小于等于K的临界点 统计从0到r的子矩阵个数
					ans += r + 1 - m1;
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

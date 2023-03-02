package 八分治算法;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 差分数组_小明的彩灯 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
		int N, Q;
		long[] light, gap;
		String[] nqStrings = reader.readLine().split(" ");
		N = Integer.parseInt(nqStrings[0]);
		Q = Integer.parseInt(nqStrings[1]);
		light = new long[N + 1];
		gap = new long[N + 1];
		String[] lightStrings = reader.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			light[i] = Long.parseLong(lightStrings[i - 1]);
			gap[i] = light[i] - light[i - 1];
		}

		for (int i = 0; i < Q; i++) {
			String[] opString = reader.readLine().split(" ");

			int l = Integer.parseInt(opString[0]);
			int r = Integer.parseInt(opString[1]);
			long x = Long.parseLong(opString[2]);
			// 修改差分数组
			gap[l] += x;
			if (r < N)
				gap[r + 1] -= x;
		}
		for (int i = 1; i <= N; i++) {
			light[i] = light[i - 1] + gap[i];
			if (light[i] < 0)
				writer.write("0 ");
			else
				writer.write(light[i] + " ");
		}
		writer.flush();
		reader.close();
	}
}

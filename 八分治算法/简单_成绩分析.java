package 八分治算法;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class 简单_成绩分析 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int max = 0;
		int min = 101;
		double sum = 0;
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(reader.readLine());
			max = Math.max(max, score);
			min = Math.min(min, score);
			sum += score;
		}
		double avg = new BigDecimal(sum / N).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.printf("%d\n%d\n%.2f\n", max, min, avg);
		reader.close();
	}
}

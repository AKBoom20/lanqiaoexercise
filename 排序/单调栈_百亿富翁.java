package 排序;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;

public class 单调栈_百亿富翁 {
	static int N;
	static int[] house;
	static int[] right;
	static int[] left;
	static PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			N = Integer.parseInt(reader.readLine());
			house = new int[N];
			right = new int[N];
			left = new int[N];
			String[] hStrings = reader.readLine().split(" ");
			for (int i = 0; i < N; i++)
				house[i] = Integer.parseInt(hStrings[i]);
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<>();
		// 找右边第一个比自己大的数 从右往左遍历
		// 单调递增栈
		for (int i = N - 1; i >= 0; i--) {
			// 每一遍循环是求right[i]
			// 栈顶元素不大于新元素 那么栈顶元素一定不可能是左边数的 第一个比它大的数
			while (!stack.isEmpty() && house[stack.peek()] <= house[i])
				stack.pop();// 弹出这个没用的元素
			if (!stack.isEmpty())
				right[i] = stack.peek() + 1;
			else
				right[i] = -1;
			// 最后将这个元素入栈
			stack.push(i);
		}
		stack.clear();
		// 找左边第一个比自己大的数 从左往右遍历
		for (int i = 0; i < N; i++) {
			while (!stack.isEmpty() && house[stack.peek()] <= house[i])
				stack.pop();
			if (!stack.isEmpty())
				left[i] = stack.peek() + 1;
			else
				left[i] = -1;
			stack.push(i);
		}
		for (int i = 0; i < N; i++) {
			writer.printf("%d ", left[i]);
		}

		writer.println();
		for (int i = 0; i < N; i++) {
			writer.printf("%d ", right[i]);
		}
		writer.flush();
	}
}

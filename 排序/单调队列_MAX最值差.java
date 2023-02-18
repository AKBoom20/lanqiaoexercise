package 排序;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 单调队列_MAX最值差 {
	static int ans;
	static int N, K;
	static int[] array;
	static int[] maxArray;// 记录区间最大值
	static int[] minArray;// 记录区间最小值
	static {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		K = scanner.nextInt();
		maxArray = new int[N];
		minArray = new int[N];
		array = new int[N];
		for (int i = 0; i < array.length; i++)
			array[i] = scanner.nextInt();
		scanner.close();
	}

	public static void main(String[] args) {
		Deque<Integer> queue = new ArrayDeque<>();

		// 遍历一遍 找最大值 队头永远是当前区间的最大值
		for (int i = 0; i < N; i++) {
			// 先加入的在队列前面 队前面的元素不在当前区间时 都要出队
			// 对[i-k,i]区间 队头元素的下表>=i-K
			while (!queue.isEmpty() && queue.peekFirst() < i - K)
				queue.poll();// 不在这个区间的都出队
			// 如果新加入的元素大于等于队尾的元素 即他又后出队 又比前一个大 原来的队尾元素已经没用了 直接淘汰
			while (!queue.isEmpty() && array[i] >= array[queue.peekLast()])
				queue.pollLast();// 已经没有存在意义
			queue.offer(i);
			maxArray[i] = array[queue.peekFirst()];
		}
		//不要忘记清空队列
		queue.clear();
		// 遍历第二遍找最小值 队头元素永远是当前区间最小的
		for (int i = 0; i < N; i++) {
			while (!queue.isEmpty() && queue.peekFirst() < i - K)
				queue.poll();
			while (!queue.isEmpty() && array[i] <= array[queue.peekLast()])
				queue.pollLast();
			queue.offer(i);
			minArray[i] = array[queue.peekFirst()];
		}
		// 遍历第三遍 求出最大差值
		for (int i = 0; i < N; i++) {
			ans = Math.max(maxArray[i] - minArray[i], ans);
		}
		System.out.println(ans);
	}
}

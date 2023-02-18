package 基础数学思维与技巧;

import java.util.HashMap;
import java.util.Scanner;

public class 哈希_查找两个总和为特定值的索引 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}
		int target = scanner.nextInt();
		scanner.close();
		HashMap<Integer, Integer> map = new HashMap<>();
		int[] ans = { 101, 101 };
		for (int i = 0; i < array.length; i++) {
			if (!map.containsKey(target - array[i])) {
				if (!map.containsKey(array[i]))
					map.put(array[i], i);
			} else {
				if (map.get(target - array[i]) < ans[0]) {
					ans[0] = map.get(target - array[i]);
					ans[1] = i;
				}
			}
		}
		System.out.printf("%d %d", ans[0],ans[1]);
	}
}

package 数据结构基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//超时
public class 集合_蓝桥幼儿园 {
	public static void main(String[] args) throws IOException {
		// 存储所有集合 集合中最大元素做集合的键
		Map<Integer, Set<Integer>> map = new HashMap<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] nmStrings = reader.readLine().split(" ");
		int N = Integer.parseInt(nmStrings[0]);
		int M = Integer.parseInt(nmStrings[1]);
		int[] whichSet = new int[N + 1];
		for (int i = 0; i < M; i++) {
			String[] opString = reader.readLine().split(" ");
			int op = Integer.parseInt(opString[0]);
			int num1 = Integer.parseInt(opString[1]);
			int num2 = Integer.parseInt(opString[2]);
			if (op == 1) {
				if (whichSet[num1] == 0 && whichSet[num2] == 0) {
					Set<Integer> set = new HashSet<>();
					set.add(num1);
					set.add(num2);
					int index = Math.max(num1, num2);
					whichSet[num1] = index;
					whichSet[num2] = index;
					map.put(index, set);
				} else if (whichSet[num1] == 0 || whichSet[num2] == 0) {
					int index = Math.max(whichSet[num1], whichSet[num2]);
					Set<Integer> set = map.get(index);
					set.add(num1);
					set.add(num2);
					//遍历所有集合的操作太费时间
					for (int j : set)
						whichSet[j] = index;
					map.put(index, set);
				} else {
					int index = Math.max(whichSet[num1], whichSet[num2]);
					Set<Integer> set1 = map.get(whichSet[num1]);
					Set<Integer> set2 = map.get(whichSet[num2]);
					set1.addAll(set2);
					for (int j : set1)
						whichSet[j] = index;
					map.put(index, set1);
				}

			} else
				System.out.println(whichSet[num1] == whichSet[num2] && whichSet[num1] != 0 ? "YES" : "NO");

		}
		reader.close();
	}

}

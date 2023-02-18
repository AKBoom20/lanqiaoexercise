package 蓝桥5天集训;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class 考勤刷卡 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = Integer.parseInt(scanner.nextLine());
		HashSet<Integer> indexSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			String input = scanner.nextLine();
			int number = Integer.parseInt(input.substring(9));
			indexSet.add(number);
		}
		scanner.close();
		List<Integer> indexList = new ArrayList<>(indexSet);
		Collections.sort(indexList);
		for (Integer integer : indexList) {
			System.out.println(integer);
		}

	}
}

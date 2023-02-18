package 数据结构基础;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 模拟_CLZ银行问题 {
	public static void main(String[] args) throws IOException {
		Deque<String> nqueue = new ArrayDeque<>();
		Deque<String> vqueue = new ArrayDeque<>();

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		for (int i = 0; i < N; i++) {
			String op="", name="", type="";
			String[] opStrings = reader.readLine().split(" ");
			if (opStrings.length == 3) {
				
				name = opStrings[1];
				type = opStrings[2];
			}
			else type = opStrings[1];
			op = opStrings[0];
			if (op.equals("IN")) {
				if (type.equals("V"))
					vqueue.offer(name);
				else
					nqueue.offer(name);
			} else {
				if (type.equals("V"))
					vqueue.poll();
				else
					nqueue.poll();
			}

		}
		reader.close();
		while(!vqueue.isEmpty()) {
			String nameString = vqueue.poll();
			System.out.println(nameString);
		}
		while(!nqueue.isEmpty()) {
			String nameString = nqueue.poll();
			System.out.println(nameString);
		}
	}
}

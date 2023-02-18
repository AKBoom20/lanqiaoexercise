package 蓝桥5天集训;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 堆_染色时间 {
	static int N, M;
	static int[] dn = { 0, 0, -1, 1 };
	static int[] dm = { -1, 1, 0, 0 };
	static int[][] chessBoard;
	static boolean[][] flag;
	static {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			String[] input = line.split(" ");
			N = Integer.parseInt(input[0]);// 行
			M = Integer.parseInt(input[1]);// 列
			chessBoard = new int[N][M];
			flag = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				String rowString = reader.readLine();
				String[] rowData = rowString.split(" ");
				for (int j = 0; j < M; j++) {
					chessBoard[i][j] = Integer.parseInt(rowData[j]);
					flag[i][j] = false;
				}
			}
			reader.close();

		} catch (Exception e) {
		}

	}

	public static void main(String[] args) {
		int time = 0;
		PriorityQueue<Cell> queue = new PriorityQueue<>((a, b) -> (a.moment - b.moment));
		flag[0][0] = true;
		queue.offer(new Cell(0, 0, chessBoard[0][0]));
		while (!queue.isEmpty()) {
			Cell curCell = queue.poll();
			int n = curCell.n, m = curCell.m;
			time = curCell.moment;

			for (int i = 0; i < 4; i++) {
				int nextn = n + dn[i], nextm = m + dm[i];
				if (nextn >= 0 && nextm >= 0 && nextn < N && nextm < M && flag[nextn][nextm] == false) {
					flag[nextn][nextm] = true;
					queue.offer(new Cell(nextn, nextm, chessBoard[nextn][nextm]+time));
				}
			}

		}
		System.out.println(time);
	}
}

class Cell {

	public int n, m;// 当前格子的行和列
	public int moment;// 当前格子从0时刻开始到自己被触发然后染色完毕的时间

	public Cell(int n, int m, int value) {
		this.n = n;
		this.m = m;
		this.moment = value;
	}
}
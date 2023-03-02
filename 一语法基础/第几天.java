package 一语法基础;

public class 第几天 {
	static int[] monthDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	static int year = 2000;
	static int month = 1;
	static int day = 1;

	public static void main(String[] args) {
		System.out.println(dateSimulator());
	}

	public static int dateSimulator() {
		int count = 1;
		while (!(year == 2000 && month == 1 && day == 8)) {
			monthDay[2] = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
			count++;
			day++;
			if (day > monthDay[month]) {
				day = 1;
				month++;
			}
			if (month > 12) {
				month = 1;
				year++;
			}
		}
		return count;
	}
}

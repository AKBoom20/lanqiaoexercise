package 语法基础;

public class 世纪末的星期 {
	static int[] monthDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	// 1999年12月31日 星期五开始
	static int year = 1999;
	static int month = 12;
	static int day = 31;
	static int week = 5;

	public static void main(String[] args) {

		System.out.println(dateSimulator());
	}

	public static int dateSimulator() {

		while (!(year == 9999 && month == 12 && day == 31)) {
			monthDay[2] = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
			day++;
			week++;
			week = week % 7;
			if (day > monthDay[month]) {
				day = 1;
				month++;
			}
			if (month > 12) {
				month = 1;
				year++;
			}
//			System.out.printf("%d年%d月%d日 星期%d\n", year, month, day, week);
			if (year % 10 == 9 && (year / 10) % 10 == 9 && month == 12 && day == 31 && week == 0)
				return year;

		}
		return -1;

	}
}

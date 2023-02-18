package lanqiaoexercise;

import java.util.Arrays;
import java.util.Scanner;

public class Day2 {

	public static void main(String[] args) {

//		Scanner scanner = new Scanner(System.in);
//		String dateString = scanner.next();
//		scanner.close();
//
//		int year = Integer.parseInt(dateString.substring(0, 4));
//		int month = Integer.parseInt(dateString.substring(4, 6));
//		int day = Integer.parseInt(dateString.substring(6, 8));
//
//		LocalDate date = LocalDate.of(year, month, day);
//		date = date.plusDays(1);
//
//		boolean isFind = false;
//		String date1 = "", date2 = "";
//		while (true) {
//			String dString = date.toString().replace("-", "");
//			if (isHuiWenDate(dString)) {
//				if (!isFind) {
//					isFind = true;
//					date1 = dString;
//				}
//				if (isABHuiWenDate(dString)) {
//					date2 = dString;
//						break;
//				}
//			}
//			date = date.plusDays(1);
//
//		}
//		System.out.println(date1);
//		System.out.println(date2);
//
//	}
//
//	private static boolean isABHuiWenDate(String dString) {
//		
//		if (dString.charAt(0) == dString.charAt(2) && 
//				dString.charAt(1) == dString.charAt(3)) {
//			return true;
//		}
//		return false;
//	}
//
//	private static boolean isHuiWenDate(String dString) {
//		for (int i = 0; i < 4; i++) {
//			if (dString.charAt(i) != dString.charAt(7-i) ) {
//				return false;
//			}
//		}
//		
//		return true;
//	}

//	int i = 1;
//	int sum = 0;
//	while (i <= 2020) {
//		String numString =String.valueOf(i);
//		char[] num = numString.toCharArray();
//		for (int j = 0; j < num.length; j++) {
//			if (num[j] == '2') {
//				sum++;
//			}
//		}
//		i++;
//	}
//	System.out.println(sum);
		
	Scanner scanner = new Scanner(System.in);
	int num = scanner.nextInt();
	int[][] times = new int[num][3];
	
	for (int i = 0; i < num; i++) {
		times[i][0] = scanner.nextInt();
		times[i][1] = scanner.nextInt();
		times[i][2] = scanner.nextInt();
	}
		
	scanner.close();
	Arrays.sort(times,(a,b) -> a[0]+a[1]+a[2]-b[0]-b[1]-b[2]);
	
	long a = 0, b =0;
	
	for (int i = 0; i < num; i++) {
		for (int j = 0; j < 3; j++) {
			b += times[i][j];
			if (j == 1) {
				a += b;
			}
		}
	}
	System.out.println(a);
	
	}

}

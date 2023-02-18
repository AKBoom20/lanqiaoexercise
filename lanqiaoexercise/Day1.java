package lanqiaoexercise;

import java.util.Scanner;

public class Day1 {

	public static void main(String[] args) {

//		Scanner scan = new Scanner(System.in);
//		String word = scan.next();
//		scan.close();
//		int[] letternum = new int[26];
//		for (int i = 0; i < word.length(); i++) {
//			letternum[word.charAt(i) - 'a']++;
//		}
//
//		char ch = 'a';
//		int max = 0;
//		for (int i = 0; i < 26; i++) {
//			if (letternum[i] > max) {
//				ch = (char) (i + 'a');
//				max = letternum[i];
//			}
//		}
//		System.out.println(ch);
//		System.out.println(max);

		Scanner scan = new Scanner(System.in);
		int num=0, a=0, b=0;
		int pass = 0,good = 0;
		if (scan.hasNextInt()) {
			num = scan.nextInt();
		}
		for (int i = 0; i < num; i++) {
			int grade = scan.nextInt();
			 if (grade >= 60) {
				 a++;
			}
			if (grade >= 85) {
				b++;
			}
		}
		if (num!=0) {
			 pass = (int) Math.round(a*100.0/num);
			 good = (int) Math.round(b*100.0/num);
		}
		System.out.printf("%d%%\n",pass);
		System.out.printf("%d%%",good);
		scan.close();
	}

}

package lanqiaoexercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class Day3 {

	public static void main(String[] args) throws IOException {
//		String[] monthString = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
//		Scanner scan = new Scanner(System.in);
//		int month = scan.nextInt();
//		int day = scan.nextInt();
//		scan.close();
//		
//		String dayString ="";
//		if (day <= 9) {
//			dayString = "0" + String.valueOf(day);
//		}else {
//			dayString = String.valueOf(day);
//		}
//		
//		String monthString2 = monthString[month-1];
//		
//		System.out.println(monthString2+dayString);

//		Scanner scanner = new Scanner(System.in);
//		
//		int size =  scanner.nextInt();
//		int[] array = new int[size];
//		for (int i = 0; i < size; i++) {
//			array[i] = scanner.nextInt();
//		}
//		
//		Arrays.sort(array);
//		System.out.print(array[0]);
//		for (int i = 1;i < array.length-1;i++) {
//			System.out.printf(" %d", array[i]);
//		}
//		System.out.printf(" %d\n",array[array.length-1]);
//		
//		System.out.print(array[array.length-1]);
//		for (int i = array.length-2;i > 0;i--) {
//			System.out.printf(" %d", array[i]);
//		}
//		System.out.printf(" %d\n",array[0]);
//		
//		scanner.close();
		/*
		 * 用到了差分数组，需要注意用Scanner会超时，数组类型用int部分答案不通过。
		 */
//		Scanner scanner = new Scanner(System.in);
//		int lightNum = scanner.nextInt();
//		int opNum = scanner.nextInt();
//		int[] lights = new int[lightNum]; 
//		for (int i = 0; i < lightNum; i++) {
//			lights[i] = scanner.nextInt();
//		}
//		for (int i = 0; i < opNum; i++) {
//			int left = scanner.nextInt();
//			int right = scanner.nextInt();
//			int op = scanner.nextInt();
//			
//			for (int j = left; j <=right; j++) {
//				lights[j-1] += op;
//				if (lights[j-1] < 0) lights[j-1] = 0;
//			}
//		}
//		System.out.print(lights[0]);
//		for (int i = 1; i < lights.length; i++) {
//			System.out.printf(" %d", lights[i]);
//		}
//		scanner.close();

//		StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//
//		tokenizer.nextToken();
//		int n = (int) tokenizer.nval;
//		tokenizer.nextToken();
//		int q = (int) tokenizer.nval;
//
//		long[] a = new long[n + 1];
//		long[] b = new long[n + 1];
//
//		for (int i = 1; i <= n; i++) {
//			tokenizer.nextToken();
//			a[i] = (long) tokenizer.nval;
//			;
//			b[i] = a[i] - a[i - 1];
//		}
//
//		for (int i = 0; i < q; i++) {
//			tokenizer.nextToken();
//			int left = (int) tokenizer.nval;
//			tokenizer.nextToken();
//			int right = (int) tokenizer.nval;
//			tokenizer.nextToken();
//			long change = (long) tokenizer.nval;
//
//			b[left] += change;
//			if (right < n)
//				b[right + 1] -= change;
//		}
//
//		for (int i = 1; i <= n; i++) {
//			a[i] = b[i] + a[i - 1];
//		}
//		for (int i = 1; i <= n; i++) {
//			if (a[i] < 0)
//				a[i] = 0;
//			System.out.print(a[i] + " ");
//		}
		
		StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
		tokenizer.nextToken();
		
		while(tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
			float n = (float)tokenizer.nval;
//			double low = 0;
//			double high = tokenizer.nval;
//			double mid = 0;
//			while((high - low) > 0.0001) {
//				mid = (low + high) / 2;
//				double temp = mid * mid * mid;
//				if (temp > n ) {
//					high = mid;
//				}else {
//					low = mid;
//				}
//			}
			float guess = n/2;
			
			float result = fun(guess, n);
			
			
			System.out.printf("%.3f\n",result);
		}
		
	}
	
	private static float fun(float guess,float x)
	{
	    if(Math.abs(guess*guess*guess-x)<0.0000001) return guess;
	    else
	    return fun((x/guess/guess+2*guess)/3,x);
	}

}

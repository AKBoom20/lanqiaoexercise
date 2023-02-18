package lanqiaoexercise;

public class Day4 {
	public static void main(String[] args) {
//		int count = 0;
//		for (int i = 1; i <= 2020; i++) {
//			if (zhanzhuan(i, 1018) == 1)count++;
//		}
//		System.out.println(count);

//		int a = 1,b = 2, c = 4;
//		for (int i = 1; i <= 20; i++) {
//			System.out.printf("%d %d %d %d\n", i,a*i,b*i,c*i);
//		}

//		int result = 1;
//		for (int i = 1; i <= 2021; i++) {
//			if (i % 2 == 1) {
//				result *= i;
//				String rString = String.valueOf(result);
//				if (rString.length() > 5) rString = rString.substring(rString.length()-5,rString.length());
//				result = Integer.parseInt(rString);
//			}
//		}
//		System.out.println(result);

//		Scanner scanner = new Scanner(System.in);
//		int a = scanner.nextInt();
//		for (int i = 1; i < a; i++) {
//			for (int j = 1; j <= i; j++) {
//					String iString = Integer.toString(i,a).toUpperCase();
//					String jString = Integer.toString(j,a).toUpperCase();
//					String rString = Integer.toString(i*j,a).toUpperCase();
//					
//					System.out.printf("%s*%s=%s ", iString, jString, rString);
//			}
//			System.out.println();
//		}
//		scanner.close();

	}

	/* 辗转相除求最大公约数 公约数为1则互质 */
	public static int zhanzhuan(int m, int n) {
		int a = Math.max(m, n);
		int b = Math.min(m, n);
		int r = a % b;
		while (r != 0) {
			a = b;
			b = r;
			r = a % b;
		}
		return b;

	}

}

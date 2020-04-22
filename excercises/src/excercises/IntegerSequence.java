package excercises;

public class IntegerSequence {

	public static void main(String[] args) {

		System.out.println("A SEQUENCE OF INTEGERS\n\n");

		// input tool
		java.util.Scanner in = new java.util.Scanner(System.in);
		in.useLocale(java.util.Locale.US);

		// input some integer numbers
		int[] u = new int[10 + 1];
		System.out.println("enter 10 integer numbers on one line:");
		for (int i = 1; i < u.length; i++)
			u[i] = in.nextInt();
		System.out.println();

		// the least of the integers and their mean value
		int min = u[1];
		int sum = u[1];
		for (int i = 2; i < u.length; i++) {
			if (u[i] < min)
				min = u[i];
			sum += u[i];
		}
		double mean = (double) sum / (u.length - 1);

		// present the result
		System.out.println("the least integer and the mean value of all integers");
		System.out.printf("%4d  |  %7.2f\n\n\n", min, mean);

	}

}

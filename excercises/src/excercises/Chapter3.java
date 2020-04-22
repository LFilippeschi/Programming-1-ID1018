package excercises;

import java.util.Scanner;
import java.math.*;

public class Chapter3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 0;
		byte by = 127;
		System.out.println("int: " + i + "\n" + "byte: " + by);
		i = by * by;
		System.out.println("i=b*b: " + i);
		System.out.println("(byte) b=" + by);
		by = (byte) i;
		System.out.println("(int) b=i: " + by);

		int a, b, c;

		Scanner in = new Scanner(System.in);
		System.out.println("type three numbers and i'll tell you the largest, smallest and middle value");

		System.out.print("a=");
		a = in.nextInt();
		in.nextLine();
		System.out.print("b=");
		b = in.nextInt();
		in.nextLine();
		System.out.print("c=");
		c = in.nextInt();
		in.nextLine();

		boolean bool = a > b;
		System.out.println(bool);

		if (a >= b && a >= c)
			System.out.println(a + " greatest");
		if (b > a && b > c)
			System.out.println(b + " greatest");
		if (c > b && c > a)
			System.out.println(c + " greatest");
		if (a <= b && a <= c)
			System.out.println(a + " smallest");
		if (b < a && b < c)
			System.out.println(b + " smallest");
		if (c < a && c < b)
			System.out.println(c + " smallest");
		if ((a >= b && a <= c) || (a < b && a > c))
			System.out.println(a + " middle");
		if ((b > a && b < c) || (b < a && b > c))
			System.out.println(b + " middle");
		if ((c > a && c < b) || (c < a && c > b))
			System.out.println(c + " middle");

		int max, min, middle;
		max = Math.max(Math.max(a, b), c);
		min = Math.min(Math.min(a, b), c);
		middle = Math.min(Math.max(a, b), c);
		System.out.println("greatest number is " + max);
		if (middle == min) {
			System.out.println("middle number is " + c);
		} else
			System.out.println("middle number is " + middle);

		System.out.println("smallest number is " + min);

	}

}

package excercises;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("insert the length of the sides of the triangle: ");

		double l1 = sc.nextDouble();
		double l2 = sc.nextDouble();
		double l3 = sc.nextDouble();
		sc.nextLine();
		if (l1 < 0)
			l1 = -l1;
		if (l2 < 0)
			l2 = -l2;
		if (l3 < 0)
			l3 = -l3;

		Triangle t = new Triangle(l1, l2, l3);
		t.lengths();
		t.angles();
		System.out.println("Area is: " + t.area());
		System.out.println("bisector of A is: " + t.bisector(l1, l2, t.angleC));
		System.out.println("bisector of A is: " + t.bisector(l2, l1, t.angleC));
		System.out.println("bisector of B is: " + t.bisector(l3, l1, t.angleA));
		System.out.println("Perimeter is: " + t.perimeter());
		System.out.println("CircumCircle is: " + t.radiusCircumcircle());
		System.out.println("InCircle is: " + Triangle.radiusIncircle(l1, l2, l3));
	}

}

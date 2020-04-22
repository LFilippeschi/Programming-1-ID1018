package excercises;

import java.util.*;
import java.util.Scanner;
import java.math.*;

public class Triangle {

	public double lengthA, lengthB, lengthC;
	public double angleA, angleB, angleC;

	public Triangle(double a, double b, double c) {
		lengthA = a;
		lengthB = b;
		lengthC = c;
		angleA = Math.toDegrees(Math.acos(((b * b) + (c * c) - (a * a)) / (2 * c * b)));
		angleB = Math.toDegrees(Math.acos(((a * a) + (c * c) - (b * b)) / (2 * a * c)));
		angleC = Math.toDegrees(Math.acos(((b * b) + (a * a) - (c * c)) / (2 * a * b)));
	}

	public void lengths() {
		System.out.println("length1:" + lengthA + "length2: " + lengthB + "length3: " + lengthC);
	}

	public double area() {
		double area = (lengthA * (Math.sin(angleC)) * lengthB) / 2;
		/*double area = (1 / 4) * (Math.sqrt((Math.pow((lengthA * lengthA + lengthB * lengthB + lengthC * lengthC), 2)
				- 2 * (Math.pow(lengthA, 4) + Math.pow(lengthB, 4) + Math.pow(lengthC, 4)))));*/
		return area;
	}

	public double bisector(double b, double c, double alpha) {
		double p = 2 * b * c * Math.cos(alpha / 2);
		double bis = p / (b + c);
		return Math.toDegrees(bis);
	}

	public double perimeter() {

		return (lengthA + lengthB + lengthC) / 2;

	}

	public void angles() {
		System.out.println("angleA:" + angleA + "angle2: " + angleB + "angle3: " + angleC);

	}

	public double radiusCircumcircle() {
		double circumRadius = Math.sqrt((lengthA * lengthA * lengthB * lengthB * lengthC * lengthC)
				/ ((lengthA + lengthB + lengthC) * (-lengthA + lengthB + lengthC) * (lengthA - lengthB + lengthC)
						* (lengthA + lengthB - lengthC)));
		return circumRadius;
	}

	public static double radiusIncircle(double lengthA, double lengthB, double lengthC) {
		double inRadius = Math
				.sqrt(((-lengthA + lengthB + lengthC) * (lengthA - lengthB + lengthC) * (lengthA + lengthB - lengthC))
						/ (4 * (lengthA + lengthB + lengthC)));
		return inRadius;
	}

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
		//System.out.println("InCircle is: " + t.radiusIncircle());
	}
}
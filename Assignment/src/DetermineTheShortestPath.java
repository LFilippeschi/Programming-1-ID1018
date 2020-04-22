import java.util.Scanner;

public class DetermineTheShortestPath {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m, n;
		System.out.println("Insert the number of the stations in Z2 and Z3 "); // initializes the stations
		m = sc.nextInt();
		sc.nextLine();
		n = sc.nextInt();
		sc.nextLine();

		double[] a = new double[m]; // initializes the lengths of the paths from station X to Z2 in a[m]
		double[] c = new double[n]; // initializes the lengths of the paths from stations in Z3 to Y in c[n]
		double[][] b = new double[m][n]; //// initializes the lengths of the paths from stations in Z2 to Z3 in b[m][n]

		// randomly populate length of stations
		for (int i = 0; i < a.length; i++) {
			a[i] = 100 * Math.random();
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = 100 * Math.random();
				c[j] = 100 * Math.random();
			}
		}

		// manually input lengths
		for (int i = 0; i < a.length; i++) {
			System.out.println("Insert the length from station X to U" + (i + 1));
			a[i] = sc.nextDouble();
			sc.nextLine();
		}
		for (int j = 0; j < c.length; j++) {
			System.out.println("Insert the length from station V" + (j + 1) + " to Y");
			c[j] = sc.nextDouble();
			sc.nextLine();
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				System.out.println("Insert the length from station U" + (i + 1) + " to V" + (j + 1));
				b[i][j] = sc.nextDouble();
				sc.nextLine();
			}
		}
		int[] intermediateStations = TheShortestPath.intermediateStations(a, b, c);
		System.out.println("Intermediate stations are: ");
		for (int i = 0; i < 2; i++)
			System.out.println(intermediateStations[i] + " ");

		System.out.println("The shortest path is:" + TheShortestPath.length(a, b, c));
	}

}

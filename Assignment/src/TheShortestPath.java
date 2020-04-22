public class TheShortestPath {

	// The method intermediateStations returns a vector of the
	// intermediate stations that are on the shortest path .
	// The ordinal number of the first station is located in
	// index 1 of the vector , and the second station on index 2.
	public static int[] intermediateStations(double[] a, double[][] b, double[] c) {
		StringBuilder strBuilder = new StringBuilder();
		double minPath = a[0] + b[0][0] + c[0]; // initializes the minPath to the first path
		int i = a.length; // number of stations in Z2
		int j = c.length; // number of stations in Z3
		double currentPath = 0; // used to compare the currentPath to the minPath
		int[] intermediateStations = new int[2];

		// start visiting all the possibilities in the paths
		for (int k = 0; k < i; k++) {
			for (int l = 0; l < j; l++) {
				currentPath = a[k] + b[k][l] + c[l];
				if (currentPath == minPath) {
					strBuilder.append("Same distance stations:").append(k+1).append("-").append(l+1); //saves the same stations in a String Builder object
				}
				if (currentPath < minPath) {
					minPath = currentPath;
					strBuilder.delete(0, strBuilder.length()); //Clears the String Builder if a new shortest path has been found
					strBuilder.append("Shortest path stations:").append(k+1).append("-").append(l+1); //saves the new indexes of the new shortest path
					intermediateStations[0] = k+1;
					intermediateStations[1] = l+1;
				}

			}
		}
		System.out.println(strBuilder.toString()); //prints on screen all the possible shortest path found
		return intermediateStations; //return a reference to the intermediateStations array
	}

	// The method length returns the length of the shortest path .
	public static double length(double[] a, double[][] b, double[] c) {
		double minPath = a[0] + b[0][0] + c[0]; // initializes the minPath to the first path
		int i = a.length; // number of stations in Z2
		int j = c.length; // number of stations in Z3
		double currentPath = 0; // used to compare the currentPath to the minPath

		// start visiting all the possibilities in the paths
		for (int k = 0; k < i; k++) {
			for (int l = 0; l < j; l++) {
				currentPath = a[k] + b[k][l] + c[l];
				if (currentPath < minPath)
					minPath = currentPath;
			}
		}

		return minPath;
	}

}

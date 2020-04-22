import java.util.Random;

public class SelectPolyline {

	public static final Random rand = new Random();
	public static final int NOF_POLYLINES = 10;

	public static void main(String[] args) {
		// Create a random number of polylines
		Polyline[] polylines = new Polyline[NOF_POLYLINES];
		for (int i = 0; i < NOF_POLYLINES; i++)
			polylines[i] = randomPolyline();
		// Show the polylines
		for (int i = 0; i < polylines.length; i++)
			System.out.println(polylines[i]);
		// Determine the shortest yellow polyline
		double length = Double.MAX_VALUE;
		int index = 0;
		int shortestPolyline = 0;
		
		//if we would not prefer to use Math.MAX_VALUE
//		int count = 0;
//		while (count < 1) {
//			for (Polyline poly : polylines) {
//				if (poly.getColour().equals("yellow")) {
//					length = poly.length();
//					count++;
//				}
//			}
//		}

		for (Polyline poly : polylines) {
			if (poly.getColour().equals("yellow")) {
				System.out.println(poly.length());
				double currentLength = poly.length();
				if (currentLength < length) {
					length = currentLength;
					shortestPolyline = index;
				}
			}
			index++;
		}
		
		if (shortestPolyline==0 && !polylines[shortestPolyline].getColour().equals("yellow")) {
			System.out.println("No yellow polylines where found!");
			return;
		}
		// Show the selected polyline
		System.out.println("The shortest yellow polyline is: " + polylines[shortestPolyline] + " :"
				+ polylines[shortestPolyline].length());

	}

	// The randomPoint method returns a new Point with a name
	// randomly chosen from the single letters A--Z. Coordinates
	// are random .
	public static Point randomPoint() {
		String n = "" + (char) (65 + rand.nextInt(26));
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);
		return new Point(n, x, y);
	}

	// The method randomPolyline returns a random polyline ,
	// with a colour either blue , red , or yellow . The names
	// of the vertices are single letters from the set A--Z.
	// Two vertices can not have the same name .
	public static Polyline randomPolyline() {
		// Create an empty polyline and add vertices
		Polyline polyline = new Polyline();
		int nofVertices = 2 + rand.nextInt(7);

		int nofSelectedVertices = 0;
		boolean[] selectedNames = new boolean[26];
		// Two vertices can not have the same name
		Point chosenPoint = null;
		char chosenChar = 0;

		// first point will always be ok

		while (nofSelectedVertices < nofVertices) {
			chosenPoint = randomPoint();
			chosenChar = chosenPoint.getName().charAt(0);
			if (selectedNames[((int) chosenChar) - 65] != true) {
				polyline.addLast(chosenPoint);
				nofSelectedVertices += 1;
				selectedNames[((int) chosenChar) - 65] = true;
			} else
				continue;

		}
		// Assign a colour
		int selectColour = rand.nextInt(3);
		String colour = "";
		switch (selectColour) {
		case 0:
			colour = "blue";
			break;

		case 1:
			colour = "red";
			break;
		case 2:
			colour = "yellow";
			break;

		}

		polyline.setColour(colour);
		return polyline;
	}

}

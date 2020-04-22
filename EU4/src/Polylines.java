import java.util.Random;

public class Polylines {

	public static final Random rand = new Random();
	
	public static Polyline shortestYellowPolyline(Polyline[] poly) {
		double shortestLength = Double.MAX_VALUE;
		int index = -1;
		int length = poly.length;
		double actualLength = 0;
		for (int j = 0; j < length; j++) {
			if (poly[j].getColour().equals("yellow")) {
				actualLength = poly[j].length();
				if (actualLength < shortestLength) {
					shortestLength = actualLength;
					index = j;
				}
			}
		}

		if (index == -1)
			return null;
		else
			return poly[index];
	}
	
	public static Point randomPoint() {
		String n = "" + (char) (65 + rand.nextInt(26));
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);
		return new Point(n, x, y);
	}
	
	public static String randomColor(int i) {
		String colour = "";
		switch (i) {
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
		return colour;
	}
	

}

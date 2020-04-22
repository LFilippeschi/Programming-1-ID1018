import java.util.Iterator;
import java.util.Random;

public class TestPolyline {
	public static final Random rand = new Random();

	public static void main(String[] args) {
		Polyline polyline = null;
		polyline = new VPolyline(
				new Point[] { new Point("A", 2, 4), new Point("B", 1, 7), new Point("C", 6, 3), new Point("D", 4, 1) }); // (1)
//		polyline = new NPolyline(
//				new Point[] { new Point("A", 2, 4), new Point("B", 1, 7), new Point("C", 6, 3), new Point("D", 4, 1) }); // (2)
		polyline.add(new Point("F", 2, 4));

		System.out.println(polyline);
		System.out.println(polyline.length());

		polyline.insertBefore(new Point("Z", 10, 0), "C");
		System.out.println(polyline);

		polyline.remove("C");
		System.out.println(polyline);

		// test using an iteator
		Iterator<Point> pointIterator = polyline.iterator();
		while (pointIterator.hasNext())
			System.out.print(pointIterator.next());

		// create polylines of different type

		VPolyline vPoly1 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		vPoly1.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline vPoly2 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		vPoly2.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline vPoly3 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		vPoly3.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline vPoly4 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		vPoly4.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline vPoly5 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		vPoly5.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline[] vPoly = new VPolyline[] { vPoly1, vPoly2, vPoly3, vPoly4, vPoly5 };
		System.out.println();
		System.out.println("VPolylines");
		for (VPolyline p : vPoly) {
			System.out.println();
			System.out.print("Points:");
			System.out.println();
			for(Point po : p) {
				System.out.println(po);}
			System.out.print(p);
		}

		NPolyline nPoly1 = new NPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		nPoly1.setColour(Polylines.randomColor(rand.nextInt(3)));

		NPolyline nPoly2 = new NPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		nPoly2.setColour(Polylines.randomColor(rand.nextInt(3)));

		NPolyline nPoly3 = new NPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		nPoly3.setColour(Polylines.randomColor(rand.nextInt(3)));

		NPolyline nPoly4 = new NPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		nPoly4.setColour(Polylines.randomColor(rand.nextInt(3)));

		NPolyline nPoly5 = new NPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		nPoly5.setColour(Polylines.randomColor(rand.nextInt(3)));

		NPolyline[] nPoly = new NPolyline[] { nPoly1, nPoly2, nPoly3, nPoly4, nPoly5 };
		System.out.println();
		System.out.println("NPolylines");
		for (NPolyline p : nPoly)
			System.out.print(p);

		NPolyline poly1 = new NPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		poly1.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline poly2 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		poly2.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline poly3 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		poly3.setColour(Polylines.randomColor(rand.nextInt(3)));

		NPolyline poly4 = new NPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		poly4.setColour(Polylines.randomColor(rand.nextInt(3)));

		VPolyline poly5 = new VPolyline(new Point[] { Polylines.randomPoint(), Polylines.randomPoint(),
				Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), Polylines.randomPoint(), });
		poly5.setColour(Polylines.randomColor(rand.nextInt(3)));

		Polyline[] poly = new Polyline[] { poly1, poly2, poly3, poly4, poly5 };
		System.out.println();
		System.out.println("Mixed Polylines");
		for (Polyline p : poly)
			System.out.print(p);

		// shortest yellow polyline in the array of VPolylines
		System.out.println();
		double length = Double.MAX_VALUE; // Double.POSITIVE_INFINITY a better choice  
		for (Polyline p : vPoly) {
			if (p.getColour().equals("yellow"))
				if (p.length() < length)
					length = p.length();
		}
		if (length == Double.MAX_VALUE)
			System.out.println("No yellow Polylines in the array VPolylines");
		else {
			System.out.println("Shortest yellow Polyline in VPolyline");
			System.out.println(length);
		}
		// shortest yellow polyline in the array of NPolylines
		System.out.println();
		length = Double.MAX_VALUE;
		for (Polyline p : nPoly) {
			if (p.getColour().equals("yellow"))
				if (p.length() < length)
					length = p.length();
		}
		if (length == Double.MAX_VALUE)
			System.out.println("No yellow Polylines in the array NPolylines");
		else {
			System.out.println("Shortest yellow Polyline in NPolyline");
			System.out.println(length);
		}
		// shortest yellow polyline in the array of Mixed Polylines
		System.out.println();
		length = Double.MAX_VALUE;
		for (Polyline p : poly) {
			if (p.getColour().equals("yellow"))
				if (p.length() < length)
					length = p.length();
		}
		if (length == Double.MAX_VALUE)
			System.out.println("No yellow Polylines in the mixed array Polylines");
		else {
			System.out.println("Shortest yellow Polyline in Polyline");
			System.out.println(length);
		}

	}

}


public class PolylineTest {

	public static void main(String[] args) {
		Point p1 = new Point("A",2,4);
		Point p2 = new Point("B",4,10);
		Point p3 = new Point("C",0,0);
		Point[] points = {p1,p2,p3};
		Polyline poly= new Polyline(points);
		System.out.println(poly);
		double len1 = poly.length();
		System.out.println(len1);
		
		poly.addLast(p1);
		len1 = poly.length();
		System.out.println(poly);
		System.out.println(len1);
		
		poly.remove("D");
		System.out.println(poly);
		poly.remove("A");
		System.out.println(poly);
		poly.remove("B");
		System.out.println(poly);
		poly.addBefore(new Point("D",-2,6), "C");
		System.out.println(poly);
		poly.addBefore(new Point("F",12,6), "A");
		System.out.println(poly);
		len1 = poly.length();
		System.out.println(len1);
		poly.addBefore(new Point("G",5,0), "D");
		System.out.println(poly);
		len1 = poly.length();
		System.out.println(len1);
		System.out.println("ITERATOR _______________________");
		Polyline.PolylineIterator polyIte = poly.new PolylineIterator();
		System.out.println(polyIte.vertex());
		polyIte.advance();
		System.out.println(polyIte.vertex());
		polyIte.advance();
		System.out.println(polyIte.vertex());
		polyIte.advance();
		System.out.println(polyIte.vertex());
		polyIte.advance();
		System.out.println(polyIte.vertex());
		polyIte.advance();
		System.out.println(polyIte.vertex());
		
	}

}

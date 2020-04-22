
public class Point {
	private int x, y;
	private String name;

	public Point() {

	}

	public Point(String name, int x, int y) {
		this.x = x;
		this.y = y;
		this.name = name;
	}

	public Point(Point p) {
		this.x = p.getX();
		this.y = p.getY();
		this.name = p.getName();
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {

		return name;
	}

	public String toString() {
		return "(" + name + " " + x + " " + y + ")";
	}

	public double distance(Point p) {
		return Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
	}

	public boolean equals(Point p) {
		if (this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
}

import java.util.Iterator;

public class VPolyline implements Polyline {

	private Point[] vertices;
	private String colour1 = " black ";
	private int width1 = 1;

	private String colour = " black ";
	private int width = 1;

	public VPolyline() {
		this.vertices = new Point[0];
	}

	public VPolyline(Point[] vertices) {
		this.vertices = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new Point(vertices[i]);
	}

	@Override
	public Iterator<Point> iterator() {
		return new PolylineIterator();
	}

//	public boolean hasNext() {               ????
//		if (this.iterator().hasNext())
//			return true;
//		return false;
//	}

	public class PolylineIterator implements Iterator<Point> {
		private int current = -1;

		public PolylineIterator() {
			if (VPolyline.this.vertices.length > 0)
				current = 0;
		}

		public boolean hasNext() {
			return current != -1;
		}

		public Point vertex() throws java.util.NoSuchElementException {
			if (!this.hasNext())
				throw new java.util.NoSuchElementException("end of iteration ");
			Point vertex = VPolyline.this.vertices[current];
			return vertex;
		}

		public Point next() {
			Point rtrnPoint = new Point(VPolyline.this.vertices[current]);
			if (current >= 0 && current < VPolyline.this.vertices.length - 1)
				current++;
			else
				current = -1;
			return rtrnPoint;
		}


	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{[");
		for (Point p : this.getVertices())
			sb.append(p);
		sb.append("], ");
		sb.append(getColour());
		sb.append(", ");
		sb.append(getWidth());
		sb.append("}.");
		return sb.toString();
	}

	public Point[] getVertices() { // creates a copy of the array and then returns the reference of the copy
		int length = vertices.length;
		Point[] verticesCopy = new Point[length];
		for (int i = 0; i < length; i++) {
			verticesCopy[i] = new Point(vertices[i]);
		}
		return verticesCopy;
	}

	public String getColour() {
		return colour1;
	}

	public int getWidth() {
		return width1;
	}

	public void setColour(String colour) {
		this.colour1 = colour;
	}

	public void setWidth(int width) {
		this.width1 = width;
	}

	public double length() {
		if (this.getVertices().length == 0)
			throw new IllegalArgumentException("Empty collection!");
		double length = 0;
		for (int i = 0; i < this.getVertices().length - 1; i++) {
			length += this.getVertices()[i].distance(this.getVertices()[i + 1]);
		}
		return length;
	}

	public void add(Point vertex) {
		Point[] h = new Point[this.vertices.length + 1];
		int i = 0;
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);
		this.vertices = h;
	}

	public void insertBefore(Point vertex, String vertexName) {
		// This method creates a copy of the object given and uses the copy in the
		// method

		// first check if the element is in the array and saves the position
		Point p1 = new Point(vertex);
		boolean found = false;
		int index = 0;
		for (int i = 0; i < this.getVertices().length; i++) {
			if (vertexName.equals(this.getVertices()[i].getName())) {
				index = i;
				found = true;
			}
		}
		// if not found adds the new vertex in last position and returns
		if (!found) {
			return;
		}

		// create new array
		Point[] vertices = new Point[this.getVertices().length + 1];

		for (int i = 0; i < vertices.length; i++) {
			if (index == i) {
				vertices[i] = p1;
				for (int j = i; j < this.getVertices().length; j++) {
					vertices[j + 1] = this.getVertices()[j];
				}
				this.vertices = vertices;
				return;
			}
			vertices[i] = this.getVertices()[i];

		}
		this.vertices = vertices;

	}

	public void remove(String vertexName) {
		// first check if the element is in the array and saves the position
		boolean found = false;
		int index = 0;
		for (int i = 0; i < this.getVertices().length; i++) {
			String currentName = this.getVertices()[i].getName();
			if (vertexName.equals(currentName)) {
				index = i;
				found = true;
			}
		}
		if (!found)
			return; // if not found returns

		Point[] vertices = new Point[this.getVertices().length - 1];
		for (int i = 0; i < vertices.length; i++) {
			if (i == index) {
				for (int j = i; j < this.getVertices().length - 1; j++) {
					vertices[j] = this.getVertices()[j + 1];
				}
				this.vertices = vertices;
				break;
			}
			vertices[i] = this.getVertices()[i];

		}
		this.vertices = vertices;
	}

}

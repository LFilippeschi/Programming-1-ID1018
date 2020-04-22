
public class Polyline1 {
	private Point[] vertices;
	private String colour = " black ";
	private int width = 1;

	public Polyline1() {
		this.vertices = new Point[0];
	}

	public Polyline1(Point[] vertices) {
		this.vertices = new Point[vertices.length];
		for (int i = 0; i < vertices.length; i++)
			this.vertices[i] = new Point(vertices[i]);
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

	public Point[] getVertices() { // returns the same reference without copying the values
		return vertices;
	}

	public String getColour() {
		return colour;
	}

	public int getWidth() {
		return width;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setWidth(int width) {
		this.width = width;
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

	public void addLast(Point vertex) {
		Point[] h = new Point[this.vertices.length + 1];
		int i = 0;
		for (i = 0; i < this.vertices.length; i++)
			h[i] = this.vertices[i];
		h[i] = new Point(vertex);
		this.vertices = h;
	}

	public void addBefore(Point vertex, String vertexName) {
		//this method uses the same reference to the object instead of creating a copy of the object given
		
		// first check if the element is in the array and saves the position
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
				vertices[i] = vertex;
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
				for (int j = i; j < this.getVertices().length - i; j++) {
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

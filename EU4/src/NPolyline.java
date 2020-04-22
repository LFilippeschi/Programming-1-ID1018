import java.util.Iterator;

public class NPolyline implements Polyline {

	private static class Node {
		public Point vertex;
		public Node nextNode;

		public Node(Point vertex) {
			this.vertex = vertex;
			nextNode = null;
		}
	}

	private Node vertices;
	private String colour = " black ";
	private int width = 1; // pixels

	public NPolyline() {
		this.vertices = null;
	}

	public NPolyline(Point[] vertices) {
		if (vertices.length > 0) {
			Node node = new Node(new Point(vertices[0]));
			this.vertices = node;
			int pos = 1;
			while (pos < vertices.length) {
				node.nextNode = new Node(new Point(vertices[pos++]));
				node = node.nextNode;
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Node node = vertices; // uses a copy of the iterator so that the list remain intact
		while (node != null) {
			sb.append(node.vertex.toString());
			sb.append(", ");
			node = node.nextNode;
		}
		sb.append(colour + ", " + width + "}");
		return sb.toString();
	}

	@Override
	public Point[] getVertices() {
		// counts how many elements are in the list
		int i;
		Node node = vertices;
		for (i = 0; node != null; node = node.nextNode) {
			i++;
		}

		Point[] rtrnVertices = new Point[i];

		// populate the array
		node = vertices;
		for (i = 0; node != null; node = node.nextNode) {
			rtrnVertices[i] = node.vertex;
			i++;
		}
		return rtrnVertices;
	}

	@Override
	public String getColour() {
		return colour;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public double length() {
		double length = 0;
		Node node = vertices;
		while (node.nextNode != null) {
			length += node.vertex.distance(node.nextNode.vertex);
			node = node.nextNode;
		}
		return length;
	}

	@Override
	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void add(Point vertex) {
		Node node = vertices;
		while (node.nextNode != null)
			node = node.nextNode;
		Node addNode = new Node(new Point(vertex));
		node.nextNode = addNode;
	}

	@Override
	public void insertBefore(Point vertex, String vertexName) {
		Node node = vertices;
		Node tmpNode;
		Node insertNode = new Node(new Point(vertex));
		if (node.vertex.getName().equals(vertexName)) {
			insertNode.nextNode = vertices;
			vertices = insertNode;
			return;
		}
		while (node.nextNode != null) {
			if (node.nextNode.vertex.getName().equals(vertexName)) {
				tmpNode = node.nextNode;
				node.nextNode = insertNode;
				insertNode.nextNode = tmpNode;
			}
			node = node.nextNode;
		}

	}

	@Override
	public void remove(String vertexName) {
		Node node = vertices;
		if (node.vertex.getName().equals(vertexName))
			vertices = node.nextNode;
		while (node.nextNode != null) {
			if (node.nextNode.vertex.getName().equals(vertexName)) {
				node.nextNode = node.nextNode.nextNode;
			}
			node = node.nextNode;
		}
	}

	@Override
	public Iterator<Point> iterator() {
		return new NPolylineIterator();
	}

	private class NPolylineIterator implements Iterator<Point> {
		private Node node;

		public NPolylineIterator() {
			node = vertices;
		}

		@Override
		public boolean hasNext() {
			boolean rtrn;
			if (node.nextNode != null)
				rtrn = true;
			else
				rtrn = false;
			return rtrn;
		}

		@Override
		public Point next() {
			Point point = new Point(node.vertex);
			if (node.nextNode != null) {
				node = node.nextNode;
			}
			return point;
		}

	}

}
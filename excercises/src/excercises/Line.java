package excercises;

public class Line {
	
	public static final int X=1;

	public static void line(int n) {
		if (n > 0) {
			System.out.print('-');
			line(n - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 5;
		line(X);
		String name = null;
		System.out.println(name);

	}

}

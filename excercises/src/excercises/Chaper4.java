package excercises;

public class Chaper4 {

	public static void main(String[] args) {
		/*
		for (int i = 0; i < 100; i++)
			System.out.println(-100 + i);
			*/

		int[][] a = new int[12+1][12+1];
		for (int row = 1; row < a.length; row++) {
			for (int col = 1; col < a[row].length; col++) {
				if(col==1 && row==1) {
					System.out.print("    ");
					continue;
				}
					
				a[row][col] = row * col;
				System.out.printf("%4d", a[row][col]);
			}
			System.out.println();
		}
		
		for (int row = 1; row < a.length; row++) {
			for (int col = 1; col < a[row].length; col++) {
				if(col==1 && row==1) {
					System.out.print("    ");
					continue;
				}
					
				a[row][col] = row * col;
				System.out.printf("%4d", a[a.length-row][a[row].length-col]);
			}
			System.out.println();
		}
		
	}

}

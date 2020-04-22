package excercises;
import java.util.*;

public class Chapter2 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		short s = -1;
		byte b = 127;
		int sum = i + s + b;
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("helloooosdjbcsb: ");
		double test = in.nextDouble();
		in.nextLine();
		System.out.println(test);
		

		System.out.println(i);
		System.out.println(s);
		System.out.println(b);
		System.out.println(sum);
		System.out.println((char) (i + s + b));

		String s1 = "abcde";
		String s2 = "ABCDE";
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equalsIgnoreCase(s2));

	}

}

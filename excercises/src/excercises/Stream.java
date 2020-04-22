package excercises;

import java.util.OptionalDouble;
import java.util.Arrays;

public class Stream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double[] numbers = new double[100000000];

		for (int i = 0; i < numbers.length; i++)
			numbers[i] = 100 * Math.random();

		OptionalDouble optd = Arrays.stream(numbers).parallel().min();

		if (optd.isPresent())
			System.out.println("Minumum: " + optd.getAsDouble());

	}

}

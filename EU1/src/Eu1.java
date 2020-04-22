
public class Eu1 {

	// The min method returns the least element in a sequential
	// collection . If the collection is empty an
	// IllegalArgumentException is thrown .
	public static int min(int[] elements) throws IllegalArgumentException {
		if (elements.length == 0)
			throw new IllegalArgumentException(" empty collection ");
		// Is used in trace printing 2:
		// int nofIters = 1;
		int[] sequence = elements;
		int nofPairs = sequence.length / 2;
		int nofUnpairedElements = sequence.length % 2;
		int nofPossibleElements = nofPairs + nofUnpairedElements;
		int[] partialSeq = new int[nofPossibleElements];
		int i = 0;
		int j = 0;
		while (nofPairs != 0) {
			// extract a partial sequence of possible elements
			i = 0;
			j = 0;
			while (j < nofPairs) {
				partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
				i += 2;
			}
			if (nofUnpairedElements == 1)
				partialSeq[j] = sequence[i];
			// now turn to the partial sequence
			sequence = partialSeq;
			nofPairs = nofPossibleElements / 2;
			nofUnpairedElements = nofPossibleElements % 2;
			nofPossibleElements = nofPairs + nofUnpairedElements;
			// Trace printing 1 - to follow the sequence
			System.out.println(java.util.Arrays.toString(sequence));
			// Trace printing 2 - to terminate the loop preemptively
			// (to be able to see what happens initially )
			// if ( nofIters ++ == 10)
			// System . exit (0);
		}
		// sequence [0] is the only remaining possible element
		// - it is the least element
		return sequence[0];

	}
	
	
	public static int minUpdate(int[] elements) throws IllegalArgumentException {
		if (elements.length == 0)
			throw new IllegalArgumentException(" empty collection ");
		int min = elements[0];
		for (int i = 1; i < elements.length;i++) {
			if (elements[i]<min)
				min= elements[i];
		}
		return min;
	}

	public static void main(String[] args) {

		int[] i = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 1, 18, 19 };
		int min = min(i);
		System.out.println("min is: " + min);
		System.out.println("UPDATE algorithm: min is: " + minUpdate(i));
		
		int[] l = { 2, 3, 4, 1, 5, 6, 7 };
		int minL = min(l);
		System.out.println("min is: " + minL);
		System.out.println("UPDATE algorithm: min is: " + minUpdate(l));
		
		int[] j = new int[21];
		int k=0;
		for (int a : j) {
			j[k++] = (int) (Math.random() * 16);
			System.out.print(j[k-1] + ",");
		}
		int min1 = min(j);
		System.out.println("min is: " + min1);
		System.out.println("UPDATE algorithm: min is: " + minUpdate(j));

	}
}
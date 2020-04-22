
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
		while (nofPairs >= 0) {
			// extract a partial sequence of possible elements
			i = 0;
			j = 0;
			while (j < nofPairs) {
				partialSeq[j++] = (sequence[i] < sequence[i + 1]) ? sequence[i] : sequence[i + 1];
				i += 2;
			}
			if (nofUnpairedElements == 1)
				partialSeq[j] = sequence[sequence.length - 1];
			// now turn to the partial sequence
			sequence = partialSeq;
			nofPairs = nofPossibleElements / 2;
			nofUnpairedElements = nofPossibleElements % 2;
			nofPossibleElements = nofPairs + nofUnpairedElements;
			// Trace printing 1 - to follow the sequence
//			 System . out. println ( java . util . Arrays . toString ( sequence ));
//			 Trace printing 2 - to terminate the loop preemptively
//			 (to be able to see what happens initially )
//			 if ( nofIters ++ == 10)
//			 System . exit (0);
		}
		// sequence [0] is the only remaining possible element
		// - it is the least element
		return sequence[0];
	}

	public static void main(String[] args) {

		int[] i = new int[16];

		for (int a : i) {
			i[a] = (int) (Math.random() * 16);
			System.out.print(i[a] + ",");
		}
		int min = min(i);
		System.out.println("min is: " + min);

	}

}

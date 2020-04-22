package excercises;

public class Chapter5 {

	public static int select(int arraySize) {
		int select = (int) (Math.random() * (arraySize));
		return select;
	}

	public static char[] deleteElement(char[] array, int position) {
		char[] newArray = new char[array.length - 1];
		for (int i = 0; i < newArray.length; i++) {
			if (i == position) {
				for (int j = i; j < newArray.length; j++)
					newArray[j] = array[j + 1];
				break;
			} else
				newArray[i] = array[i];
		}
		return newArray;
	}

	public static void main(String[] args) {
		final char[] A = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'l', 'm', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'z' };
		for (char c : A)
			System.out.print(c);
		int l = A.length;
		System.out.println(l);
		char[] aRandom = new char[20];
		for (int i = 0; i < aRandom.length; i++) {
			int select = (int) (Math.random() * 20);
			aRandom[i] = A[select];
		}
		System.out.println();
		for (char c : aRandom)
			System.out.print(c);

		char[] aScrubbled = new char[20]; // new scrumbled array with 20 elements
		/*
		 * for (int i = 0; i < aScrubbled.length; i++) { // start populating the
		 * scrumbled array int select = (int) (Math.random() * (20 - i)); // random
		 * select in the originl array }
		 */
		int i = Chapter5.select(6);
		deleteElement(aScrubbled, 4);
		char[] newA = new char[19];
		newA=(Chapter5.deleteElement(aScrubbled, 4)).clone();
		System.out.println("i is: " + i);
		for (char c : newA)
			System.out.print(c+newA.length);

		/*
		 * aScrubbled[i] = A[select]; // copies first value char[] newA = new char[20 -
		 * i - 1]; // initializes a new array smaller by 1 at each step for (int j = 0;
		 * j < newA.length; j++) { // populates the new array A -1 if (j == select) { //
		 * checks at every step if j is the same as the element selected in A for (int z
		 * = j + 1; z <= newA.length; z++) { newA[z - 1] = A[z]; // finishes populating
		 * the new array skipping the position of the selected // element } } else
		 * aScrubbled[j] = A[j]; // else copies the value
		 * 
		 * }
		 */

		System.out.println();
		for (char c : aScrubbled)
			System.out.print(c);

	}

}

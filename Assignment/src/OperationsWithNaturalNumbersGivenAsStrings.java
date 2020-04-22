import java.util.*; // Scanner
import static java.lang.System.out;

class OperationsWithNaturalNumbersGivenAsStrings {
	public static void main(String[] args) {
		out.println(" OPERATIONS ON NATURAL NUMBERS " + "IN CHARACTER STRINGS ");
// enter two natural numbers
		Scanner in = new Scanner(System.in);
		out.println("two natural numbers :");
		String tal1 = in.next();
		String tal2 = in.next();
		out.println();
// add the numbers and show the result
		String sum = add(tal1, tal2);
		String sub = subtract(tal1, tal2);
		String mult = multiply(tal1, tal2);
		String division = divide(tal1, tal2);
		show(tal1, tal2, sum, '+');

//subtract the numbers and show the result
		show(tal1, tal2, sub, '-');

// subtract the numbers and show the result
		show(tal1, tal2, mult, '*');

// subtract the numbers and show the result
		show(tal1, tal2, division, '/');
	}

//The add method accepts two natural numbers represented
//as character strings and returns their sum as a
//character string .
	public static String add(String num1, String num2) throws IllegalArgumentException {

		// this method is limited by the size of int, it doesn't work with very large
		// numbers and it will result in an overflow

//		int len1 = num1.length();
//		int len2 = num2.length();
//		int value1 = 0, value2 = 0;
//
//		for (int i = len1 - 1; i >= 0; i--) { // run trough each char starting from the left and scaling it to decimal
//												// and adding the next char
//			if (!Character.isDigit(num1.charAt(i))) // check on each char of the string to see if it is a digit
//				throw new IllegalArgumentException("char not a digit");
//			int actualValue = Character.getNumericValue(num1.charAt(i));
//			value1 = value1 + (int) ((Math.pow(10, (len1 - i - 1))) * (actualValue));
//		}
//		for (int i = len2 - 1; i >= 0; i--) {
//			if (!Character.isDigit(num2.charAt(i))) // check on each char of the string to see if it is a digit
//				throw new IllegalArgumentException("char not a digit");
//			int actualValue = Character.getNumericValue(num2.charAt(i));
//			value2 = value2 + (int) ((Math.pow(10, (len2 - i - 1))) * (actualValue));
//		}
//		return Integer.toString(value1 + value2);

		StringBuilder sb = new StringBuilder();
		StringBuilder numPadder = new StringBuilder();
		int len1 = num1.length();
		int len2 = num2.length();
		String paddedNumber;
		String givenNumber;
		int carry = 0;
		boolean num1Greater = len1 > len2;

		if (num1Greater) {
			numPadder.append(num2);
			numPadder.reverse();
			for (int i = len1 - len2 - 1; i >= 0; i--)
				numPadder.append(0);
			numPadder.reverse();
			paddedNumber = numPadder.toString();
			givenNumber = num1;

		} else {
			numPadder.append(num1);
			numPadder.reverse();
			for (int i = len2 - len1 - 1; i >= 0; i--)
				numPadder.append(0);
			numPadder.reverse();
			paddedNumber = numPadder.toString();
			givenNumber = num2;

		}

		// check that the Strings are numbers
		for (int i = len1 - 1; i >= 0; i--)
			if (!Character.isDigit(paddedNumber.charAt(i)) || !Character.isDigit(givenNumber.charAt(i)))
				throw new IllegalArgumentException("char not a digit");

		for (int i = paddedNumber.length() - 1; i >= 0; i--) {
			int actualValue1 = Character.getNumericValue(paddedNumber.charAt(i));
			int actualValue2 = Character.getNumericValue(givenNumber.charAt(i));
			int sum = carry + actualValue1 + actualValue2;
			if (sum > 9) {
				sb.append(sum - 10);
				carry = 1;
			} else {
				sb.append(sum);
				carry = 0;
			}
		}

		if (carry == 1)
			sb.append(carry);

		// inverts the stringBuilder
		sb.reverse();

		return sb.toString();
	}

//The subtract method accepts two natural numbers
//represented as character strings and returns their
//difference as a character string .
	public static String subtract(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		StringBuilder sb = new StringBuilder();
		sb.append(num2);
		sb.reverse();
		for (int i = len1 - len2; i > 0; i--) {
			sb.append(0);
		}
		sb.reverse();
		StringBuilder rtrn = new StringBuilder();

		int carry = 0;
		for (int i = num1.length() - 1; i >= 0; i--) {
			int diff = (Character.getNumericValue(num1.charAt(i))) - (Character.getNumericValue(sb.charAt(i))) - carry;
			carry = 0;
			if (diff < 0) {
				carry = 1;
				rtrn.append(diff + 10);
			} else
				rtrn.append(diff);
		}
		rtrn.reverse();
		return rtrn.toString();

	}

	public static String subtract1(String num1, String num2) throws IllegalArgumentException {

		// this method is limited by the size of int, it doesn't work with very large
		// numbers and it will result in an overflow

//		int len1 = num1.length();
//		int len2 = num2.length();
//		int value1 = 0, value2 = 0;
//
//		for (int i = len1 - 1; i >= 0; i--) { // run trough each char starting from the left and scaling it to decimal
//												// and adding the next char
//
//			if (!Character.isDigit(num1.charAt(i))) // check on each char of the string to see if it is a digit
//				throw new IllegalArgumentException("char not a digit");
//			int actualValue = Character.getNumericValue(num1.charAt(i));
//			value1 = value1 + (int) ((Math.pow(10, (len1 - i - 1))) * (actualValue));
//		}
//		for (int i = len2 - 1; i >= 0; i--) {
//			if (!Character.isDigit(num2.charAt(i))) // check on each char of the string to see if it is a digit
//				throw new IllegalArgumentException("char not a digit");
//			int actualValue = Character.getNumericValue(num2.charAt(i));
//			value2 = value2 + (int) ((Math.pow(10, (len2 - i - 1))) * (actualValue));
//		}
//		return Integer.toString(value1 - value2);

		int len1 = num1.length();
		int len2 = num2.length();
		String padded;
		String given;
		boolean isDigit = false;

		// decide which number to pad based on the length
		if (len1 < len2) {
			padded = num1;
		} else {
			padded = num2;
		}

		if (padded.equals(num1))
			given = num2;
		else
			given = num1;

		// pads the least smaller number
		StringBuilder padder = new StringBuilder();
		padder.append(padded);
		padder.reverse();
		for (int i = given.length() - padded.length(); i > 0; i--) {
			padder.append(0);
		}
		padder.reverse();

		// check that the Strings are numbers
		for (int i = 0; i < padded.length(); i++)
			if (!Character.isDigit(padder.charAt(i)) || !Character.isDigit(given.charAt(i)))
				throw new IllegalArgumentException("char not a digit");

		// create new StringBuilder for the return
		StringBuilder sb = new StringBuilder();

		// subtract the numbers
		for (int i = 0; i < given.length(); i++) {
			int diff = Character.getNumericValue(given.charAt(i)) - Character.getNumericValue(padder.charAt(i));
			for (int j = i; j >= 0; j--) {
				if (Character.getNumericValue(sb.toString().charAt(j)) != 0)
					isDigit = true;
				else
					isDigit = false;
			}

			if (diff >= 0)
				sb.append(diff);

			if (diff < 0 && i == 0) {
				sb.append(subtract(padder.toString(), given));
				sb.reverse();
				sb.append('-');
				sb.reverse();
				break;
			}

			if (diff < 0 && i > 0 && !isDigit) {
				sb.append(subtract(padder.toString(), given));
				sb.reverse();
				sb.append('-');
				sb.reverse();
				break;
			}

			if (diff < 0 && i > 0 && isDigit) {
				sb.append(subtract(padder.toString(), given));
			}

		}
		return sb.toString();
	}

	// The multiply method accepts two natural numbers
	// represented as character strings and returns their
	// multiplication as a character string .
	public static String multiply(String num1, String num2) throws IllegalArgumentException {
		int len1 = num1.length();
		int len2 = num2.length();
		int value1 = 0, value2 = 0;

		for (int i = len1 - 1; i >= 0; i--) { // run trough each char starting from the left and scaling it to decimal
												// and adding the next char

			if (!Character.isDigit(num1.charAt(i))) // check on each char of the string to see if it is a digit
				throw new IllegalArgumentException("char not a digit");
			int actualValue = Character.getNumericValue(num1.charAt(i));
			value1 = value1 + (int) ((Math.pow(10, (len1 - i - 1))) * (actualValue));
		}
		for (int i = len2 - 1; i >= 0; i--) {
			if (!Character.isDigit(num2.charAt(i))) // check on each char of the string to see if it is a digit
				throw new IllegalArgumentException("char not a digit");
			int actualValue = Character.getNumericValue(num2.charAt(i));
			value2 = value2 + (int) ((Math.pow(10, (len2 - i - 1))) * (actualValue));
		}
		return Integer.toString(value1 * value2);
	}

	// The divide method accepts two natural numbers
	// represented as character strings and returns their
	// division as a character string .
	public static String divide(String num1, String num2) throws IllegalArgumentException {
		int len1 = num1.length();
		int len2 = num2.length();
		int value1 = 0, value2 = 0;

		for (int i = len1 - 1; i >= 0; i--) { // run trough each char starting from the left and scaling it to decimal
												// and adding the next char

			if (!Character.isDigit(num1.charAt(i))) // check on each char of the string to see if it is a digit
				throw new IllegalArgumentException("char not a digit");
			int actualValue = Character.getNumericValue(num1.charAt(i));
			value1 = value1 + (int) ((Math.pow(10, (len1 - i - 1))) * (actualValue));
		}
		for (int i = len2 - 1; i >= 0; i--) {
			if (!Character.isDigit(num2.charAt(i))) // check on each char of the string to see if it is a digit
				throw new IllegalArgumentException("char not a digit");
			int actualValue = Character.getNumericValue(num2.charAt(i));
			value2 = value2 + (int) ((Math.pow(10, (len2 - i - 1))) * (actualValue));
		}
		if (value1 == 0)
			return "not defined";
		return Integer.toString(value1 / value2);
	}

//The show method presents two natural numbers , an
//operator and the result string .
	public static void show(String num1, String num2, String result, char operator) {
//set an appropriate length on numbers and result
		int len1 = num1.length();
		int len2 = num2.length();
		int len = result.length();
		int maxLen = Math.max(Math.max(len1, len2), len);
		num1 = setLen(num1, maxLen - len1);
		num2 = setLen(num2, maxLen - len2);
		result = setLen(result, maxLen - len);
//show the expression
		out.println(" " + num1);
		out.println("" + operator + " " + num2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print("-");
		out.println();
		out.println(" " + result + "\n");
	}

//The setLen method prepends the supplied number of
//spaces to the beginning of a string
	public static String setLen(String s, int nofSpaces) {
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < nofSpaces; i++)
			sb.insert(0, " ");
		return sb.toString();
	}
}
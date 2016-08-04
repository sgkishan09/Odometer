public class Odometer {
	public static void main(String[] args) {
		System.out.println(difference(6789, 1234));
		runTests();

	}

	public static void runTests() {
		testisValid();
		testgenerateLargest();
		testdifference();
		testgenerateLowest();
		testgenerateNext();
		testgeneratePrevious();
		testgenerateNth();
	}

	public static int digits(int input) {
		return (int) Math.ceil(Math.log10(input));
	}

	public static void testisValid() {
		assert isValid(12345678) == true;
		assert isValid(1233) == false;
	}

	public static void testgenerateNext() {
		assert generateNext(12345678) == 12345679;
	}

	public static void testgeneratePrevious() {
		assert generatePrevious(1235) == 1234;
	}

	public static void testgenerateLowest() {
		assert generateLowest(1) == 1;
	}

	public static void testgenerateNth() {
		assert generateNth(1234, 2) == 1236;
	}

	public static void testdifference() {
		assert difference(1234, 1236) == 2;
	}

	public static void testgenerateLargest() {
		assert generateLargest(9) == 123456789;
	}

	public static boolean isValid(int input) {
		String toCheck = Integer.toString(input);
		int prev = -1;
		for (int i = 0; i < toCheck.length(); i++) {
			if (toCheck.charAt(i) <= prev)
				return false;
			prev = toCheck.charAt(i);
		}
		return true;
	}

	public static int generateNext(int input) {
		int start = digits(input);
		input++;
		while (!isValid(input))
			input++;
		if (digits(input) != start)
			return generateLowest(start);
		return input;
	}

	public static int generatePrevious(int input) {
		int start = digits(input);
		input--;
		while (!isValid(input))
			input--;
		if (digits(input) != start)
			return generateLargest(start);
		return input;
	}

	public static int generateLowest(int digit) {
		int number = 0;
		for (int i = 1; i <= digit; i++)
			number = number * 10 + i;
		return number;
	}

	public static int generateLargest(int digit) {
		int number = 0;
		for (int i = 10 - digit; i <= 9; i++) {
			number = number * 10 + i;
		}
		return number;
	}

	public static int generateNth(int initial, int N) {
		int i = 0;
		int answer = initial;
		while (i < N) {
			if (isValid(answer++))
				i++;
		}
		return answer;
	}

	public static int difference(int start, int end) {
		int count = 0;
		while (start != end) {
			start = generateNext(start);
			count++;
		}
		return count;
	}
}

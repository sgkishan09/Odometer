public class Odometer {
	public static void main(String[] args) {
		runTests();
	}
	public static void runTests()
	{
		testisValid();
		testgenerateLargest();
		testdifference();
		testgenerateLowest();
		testgenerateNext();
		testgeneratePrevious();
		testgenerateNth();
	}
	public static void testisValid() {
		assert isValid(1234) == true;
		assert isValid(1233) == false;
	}

	public static void testgenerateNext() {
		assert generateNext(1234) == 1235;
	}

	public static void testgeneratePrevious() {
		assert generatePrevious(1235) == 1234;
	}

	public static void testgenerateLowest() {
		assert generateLowest(4) == 1234;
	}

	public static void testgenerateNth() {
		assert generateNth(1234, 2) == 1236;
	}

	public static void testdifference() {
		assert difference(1234, 1236) == 2;
	}
	public static void testgenerateLargest(){
		assert generateLargest(4)==6789;
	}
	public static boolean isValid(int input) {

	}

	public static int generateNext(int input) {

	}

	public static int generatePrevious(int input) {

	}

	public static int generateLowest(int digits) {

	}

	public static int generateNth(int initial, int N) {

	}

	public static int difference(int start, int end) {

	}

	public static int generateLargest(int N) {

	}

}

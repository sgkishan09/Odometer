import java.util.*;

public class WarAndPeace {
	public static void main(String[] args) {
		final String path = "C:\\Projects\\WarAndPeace.txt";
		final int N = 10;
		Map<String, Integer> frequencyMap = countWords(tokenizer(readFile(path)));
		printMap(mostFrequentWords(frequencyMap, N), frequencyMap);
	}
	public static void printMap(List<String> words, Map<String, Integer> frequencyMap) {

	}

	public static String readFile(String path) {
		return "";
	}

	public static Map<String, Integer> countWords(LinkedList<String> tokens) {
		return null;
	}

	public static LinkedList<String> tokenizer(String input) {
		return null;
	}

	public static List<String> mostFrequentWords(Map<String, Integer> frequencyMap, int N) {
		return null;
	}
}

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Map.Entry;

public class WarAndPeace {
	public static void main(String[] args) {
		String filePath = "C:\\Projects\\sowpods.txt";
		try {
			printMap(generateCluster(readFile(filePath)));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static String sortByChar(String word) {
		char[] chars = word.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

	public static Map<String, List<String>> generateCluster(List<String> words) {
		Map<String, List<String>> clusters = new HashMap<>();
		for (String word : words) {
			String sortedWord = sortByChar(word);
			if (clusters.containsKey(sortedWord))
				clusters.get(sortedWord).add(word);
			else {
				ArrayList<String> cluster = new ArrayList<>();
				cluster.add(word);
				clusters.put(sortedWord, cluster);
			}
		}
		return clusters;
	}

	public static void printMap(Map<String, List<String>> clusterMap) {
		for (String token : clusterMap.keySet())
			if (clusterMap.get(token).size() > 1)
				System.out.println(clusterMap.get(token));
	}

	public static ArrayList<String> readFile(String path) throws Exception {
		return (ArrayList<String>) Files.readAllLines(Paths.get(path));
	}
}

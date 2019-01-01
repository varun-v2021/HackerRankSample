import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result {

	/*
	 * Complete the 'cutSticks' function below.
	 *
	 * The function is expected to return an INTEGER_ARRAY. The function accepts
	 * INTEGER_ARRAY lengths as parameter.
	 */
	static int shortest = 0;
	static List<Integer> noOfSticksList = new ArrayList<>();

	public static List<Integer> cutSticks(List<Integer> lengths) {

		// Write your code here
		cutSticksHelper(lengths);
		return noOfSticksList;
	}

	public static void cutSticksHelper(List<Integer> lengths) {
		noOfSticksList.add(lengths.size());
		List<Integer> newlengths = new ArrayList<>();
		Collections.sort(lengths);
		shortest = lengths.get(0);
		for (int i = 0; i < lengths.size(); i++) {
			if ((lengths.get(i) - shortest) != 0)
				newlengths.add(lengths.get(i) - shortest);
		}
		if(!newlengths.isEmpty())
		cutSticksHelper(newlengths);
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int lengthsCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> lengths = new ArrayList<>();

		for (int i = 0; i < lengthsCount; i++) {
			int lengthsItem = Integer.parseInt(bufferedReader.readLine().trim());
			lengths.add(lengthsItem);
		}

		List<Integer> result = Result.cutSticks(lengths);

		for (int i = 0; i < result.size(); i++) {
			// bufferedWriter.write(String.valueOf(result.get(i)));
			System.out.println(String.valueOf(result.get(i)));
			if (i != result.size() - 1) {
				// bufferedWriter.write("\n");
				System.out.println("\n");
			}
		}

		// bufferedWriter.newLine();

		bufferedReader.close();
		// bufferedWriter.close();
	}
}

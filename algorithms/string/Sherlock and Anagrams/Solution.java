import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
	Function<String, String> sort_chars = item -> {
            char[] chars = item.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        };

        List<String> subStrings = new ArrayList<>();
        for (int i = 1; i <= s.length() - 1; i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                subStrings.add(s.substring(j, j + i));
            }
        }

        return (int) subStrings.stream()
                .map(sort_chars)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getValue)
                .map(item -> item * (item - 1) / 2)
                .mapToLong(Long::longValue)
                .sum();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}

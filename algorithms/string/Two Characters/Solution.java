import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the alternate function below.
    static int alternate(String s) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            charSet.add(s.charAt(i));
        }
        Character[] chars = charSet.toArray(new Character[charSet.size()]);
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (i == j)
                    continue;
                else {
                    char a = chars[i];
                    char b = chars[j];
                    char prev = '\0';
                    boolean flag = true;
                    int len = 0;
                    for (char ch : s.toCharArray()) {
                        if (ch != a && ch != b) {
                            continue;
                        } else {
                            boolean rule = (prev == a && ch == b) ||
                                    (prev == b && ch == a) ||
                                    prev == '\0';
                            if (!rule) {
                                flag = false;
                                break;
                            }
                            len++;
                        }
                        prev = ch;
                    }
                    if (flag) {
                        if (max < len) {
                            max = len;
                        }
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

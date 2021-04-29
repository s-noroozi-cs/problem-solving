import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the highestValuePalindrome function below.
    static String highestValuePalindrome(String s, int n, int k) {
        int min = minimumChangesToMakePalindrome(s);
        if (k < min)
            return "-1";
        int numberOfDoubleChanges = k - min;
        char[] ans = s.toCharArray();
        for (int i = 0; i < n / 2 + n % 2; i++) {
            int leftIndex = i;
            int rightIndex = n - i - 1;
            char left = ans[leftIndex];
            char right = ans[rightIndex];
            if (left == right) {
                if (leftIndex == rightIndex) {
                    if (numberOfDoubleChanges > 0) {
                        ans[leftIndex] = '9';
                    }
                } else {
                    if (numberOfDoubleChanges > 1 && left != '9') {
                        ans[leftIndex] = '9';
                        ans[rightIndex] = '9';
                        numberOfDoubleChanges -= 2;
                    }
                }
            } else {
                if (left != '9' && right != '9' && numberOfDoubleChanges > 0) {
                    numberOfDoubleChanges--;
                    ans[leftIndex] = '9';
                    ans[rightIndex] = '9';
                } else {
                    if (left > right)
                        ans[rightIndex] = left;
                    else
                        ans[leftIndex] = right;
                }
            }
        }
        return new String(ans);
    }
    
    static int minimumChangesToMakePalindrome(String s) {
        int changes = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1))
                changes++;
        }
        return changes;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String s = scanner.nextLine();

        String result = highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

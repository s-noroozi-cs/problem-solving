import java.util.Scanner;

public class JavaAnagrams {

    static boolean isAnagram(String a, String b) {
        // Complete the function
        boolean out = false;
        if(a.length() == b.length()) {
            int[] count = new int[26];
            for (int i=0; i<a.length(); i++){
                int indexA = Character.toLowerCase(a.charAt(i))-'a';
                int indexB = Character.toLowerCase(b.charAt(i))-'a';
                count[indexA]++;
                count[indexB]--;
            }
            out = true;
            for(int i=0; i<count.length;i++){
                if(count[i] != 0){
                    out = false;
                    break;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}

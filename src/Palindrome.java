
import java.util.HashSet;
import java.util.Set;

public class Palindrome {
    public int longestPalindrome(String s) {
        int result = 0;
        if (s.length() == 1) return 1;
        Set<Character> set = new HashSet<Character>();
        for (char c : s.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else if (set.contains(c)) {
                set.remove(c);
                result += 2;
            }
        }
        if (set.size() >= 1) {
            result++;
            // toUpperCase() checks to see if c is upper case or lower case; What I want is if the set contains the upper case
            // version or the lower case version of c
            for (char c : set) if (set.contains(Character.toUpperCase(c))) result = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        System.out.println("Test 1 - Expecting 0; Getting: " + palindrome.longestPalindrome("Aa"));
        System.out.println("Test 2 - Expecting 7; Getting: " + palindrome.longestPalindrome("abccccdd"));
        System.out.println("Test 3 - Expecting 1; Getting: " + palindrome.longestPalindrome("a"));
        System.out.println("Test 4 - Expecting 2; Getting: " + palindrome.longestPalindrome("bb"));
        System.out.println("Test 5 - Expecting 0; Getting: " + palindrome.longestPalindrome(""));
        System.out.println("Test 6 - Expecting 3; Getting: " + palindrome.longestPalindrome("ccc"));
        System.out.println("Test 6 - Expecting 1; Getting: " + palindrome.longestPalindrome("AB"));
    }
}

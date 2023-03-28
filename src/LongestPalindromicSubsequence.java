import java.util.Arrays;


/* Code from GeeksForGeeks https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/ */
public class LongestPalindromicSubsequence {
    static int max(int i, int j) {
        return (i > j) ? i : j;
    }

    static int lps(char[] seq, int i, int j) {// O(2^n) time complexity,
        if (i == j) return 1;
        if (seq[i] == seq[j] && i + 1 == j) return 2;
        if (seq[i] == seq[j]) return lps(seq, i + 1, j - 1) + 2;
        return max(lps(seq, i, j - 1), lps(seq, i + 1, j));
    }

    static int lps(String seq) {
        int n = seq.length();
        int i, j, cl;
        int[][] L = new int[n][n];
        for (i = 0; i < n; i++) {
            L[i][i] = 1;
        }
        for (cl = 2; cl <= n; cl++) {
            for (i = 0; i < n - cl + 1; i++) {
                j = i + cl - 1;
                if (seq.charAt(i) == seq.charAt(j) && cl == 2) {
                    L[i][j] = 2;
                } else if (seq.charAt(i) == seq.charAt(j)) {
                    L[i][j] = L[i + 1][j - 1] + 2;
                } else {
                    L[i][j] = max(L[i][j - 1], L[i + 1][j]);
                }
            }
        }
        return L[0][n - 1];
    }

    static int lps(char[] seq, int i, int j, int dp[][]) {
        if (i == j) return dp[i][j] = 1;
        if (seq[i] == seq[j] && i + 1 == j) return dp[i][j] = 2;
        // avoid an extra call for already calculated values; just return the same answer. Memoization of Dynamic Programming
        if (dp[i][j] != -1) return dp[i][j];
        if (seq[i] == seq[j]) return dp[i][j] = lps(seq, i + 1, j - 1, dp) + 2;
        // if the chars in dp[i] and dp[j] are not equal, then return the max of i, j-1 and i+1, j
        return dp[i][j] = max(lps(seq, i, j - 1, dp), lps(seq, i + 1, j, dp));
    }

    static int[][] matrix = new int[1001][1001];

    static int lps(String s, int n1, int n2) {
        if (n1 == 0 || n2 == 0) return 0;
        if (matrix[n1][n2] != -1) return matrix[n1][n2];
        // reverse of s is also s[n-1-n2]
        if (s.charAt(n1 - 1) == s.charAt(s.length() - n2)) return matrix[n1][n2] = 1 + lps(s, n1 - 1, n2 - 1);
        else return matrix[n1][n2] = max(lps(s, n1 - 1, n2), lps(s, n1, n2 - 1));
    }

    public static void main(String[] args) {
        String seq = "GEEKSFORGEEKS";
        int n = seq.length();
        System.out.printf("Expecting 5, Getting: %d\n", lps(seq.toCharArray(), 0, n - 1));
        System.out.println("Expecting 5: Getting: " + lps(seq));
        int[][] dp = new int[n][n];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        System.out.println("Expecting 5, Getting: " + lps(seq.toCharArray(), 0, n - 1, dp));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = -1;
            }
        }
        System.out.println("Expecting: 5, Getting: " + lps(seq, n, n));
    }
}

package Medium.Dynamic_Programming;

/*
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:

Input: s = "cbbd"
Output: "bb"

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

public class Longest_Palindromic_Substring {

    public static String longestPalindrome(String s){
        int max = -1;
        int start = -1;
        int end = -1;
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int k = 0; k < len; k++){
            for(int i = 0; i < len-k; i++){
                int j = i + k;
                if(i == j)
                    dp[i][j] = 1;

                else if(j == i+1 && s.charAt(j) == s.charAt(i))
                    dp[i][j] = 2;

                else if(j == i+1 && s.charAt(j) != s.charAt(i))
                    dp[i][j] = 1;

                else if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == j-i-1){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);

                if(max < dp[i][j]) {
                    max = dp[i][j];
                    start = i;
                    end = j;
                }
            }
        }
        return s.substring(start, end+1);
    }
}
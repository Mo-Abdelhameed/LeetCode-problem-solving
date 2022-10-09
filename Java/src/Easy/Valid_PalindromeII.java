package Easy;
/*
Given a string s, return true if the s can be palindrome after deleting at most one character from it.

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false

Constraints:

1 <= s.length <= 105
s consists of lowercase English letters.
*/
public class Valid_PalindromeII {

    public static boolean isValid(String s){
        for(int i = 0, j = s.length()-1; i <= j; i++, j--){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static boolean validPalindrome(String s) {
        if(isValid(s))
            return true;
        int i, j;
        for(i = 0, j = s.length()-1; i < s.length(); i++, j--){
           if(s.charAt(i) != s.charAt(j))
               break;
        }
        return isValid(s.substring(i, j)) || isValid(s.substring(i+1, j+1));
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("a"));
    }
}

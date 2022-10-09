package Medium.Hashtables;

/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.


Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.

*/

import java.util.HashMap;

class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> set = new HashMap<>();
        int max = 0, count = 0;
        boolean unsavedChange = false;
        int index = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            if(!set.containsKey(c) || set.get(c) < index){
                count++;
                unsavedChange = true;
                set.put(c, i);
            }
            else{
                if(max < count) max = count;
                count = i - set.get(c);
                index = set.get(c) + 1;
                set.put(c, i);
                unsavedChange = false;
            }
        }
        if(unsavedChange && max < count)
            max = count;
        return max;
    }

    public static void main(String[]args){

        int res = lengthOfLongestSubstring("tmmzuxt");
        System.out.println(res);
    }
}
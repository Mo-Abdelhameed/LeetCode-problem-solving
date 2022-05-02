package Medium.Dynamic_Programming;

/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Word_Break {
    static HashSet<String> set = new HashSet<>();
    static int [] dp;
    public static boolean wordBreak(String s, List<String> wordDict) {
        set.clear();
        dp = new int[s.length()];
        for(String word : wordDict)
            set.add(word);
        return helper(s, 0);
    }

    public static boolean helper(String s, int k){
        if(dp[k] == 1) return true;
        if(dp[k] == -1) return false;
        if(set.contains(s)) {
            dp[k] = 1;
            return true;
        }
        if(s.equals("")){
            dp[k] = -1;
            return false;
        }


        for(int i = 0 ; i < s.length(); i++){
            if(set.contains(s.substring(0, i))) {
                if (helper(s.substring(i), i+k))
                    dp[k] = 1;
                else if(dp[k] != 1)
                    dp[k] = -1;
            }
        }
        return dp[k] == 1;
    }

    public static void main(String[] args) {
        String s = "catsandogcat";
        ArrayList<String> list = new ArrayList<>();
        list.add("cats");
        list.add("dog");
        list.add("sand");
        list.add("and");
        list.add("an");
        list.add("cat");
        System.out.println(wordBreak(s, list));
        System.out.println(Arrays.toString(dp));
    }
}

package Hard.Hashtables;

/*
You are given a string s and an array of strings words of the same length. Return all starting indices of substring(s) in s that is a concatenation of each word in words exactly once, in any order, and without any intervening characters.
You can return the answer in any order.

Example 1:

Input: s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:

Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []

Example 3:

Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]

Constraints:

1 <= s.length <= 104
s consists of lower-case English letters.
1 <= words.length <= 5000
1 <= words[i].length <= 30
words[i] consists of lower-case English letters.
*/

import java.util.*;

public class Substring_with_Concatenation_of_All_Words {

    public static boolean isValid(HashMap<String, Integer> set, String s, int lengthOfWord, int setSize){
        HashMap<String, Integer> used = new HashMap<>();
        for(int i = 0 ; i < s.length(); i += lengthOfWord) {
            int j = i + lengthOfWord;
            if (j > s.length())
                break;
            String substring = s.substring(i, j);

            if (!set.containsKey(substring))
                return false;

            if (!used.containsKey(substring)) {
                used.put(substring, 1);
                setSize--;
            }

            else if (used.get(substring) == set.get(substring))
                return false;

            else {
                used.put(substring, used.get(substring) + 1);
                setSize--;
            }
        }
        return setSize == 0;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String, Integer> set = new HashMap<>();
        int lengthOfWord = words[0].length();
        int lengthOfAnswer = words.length * lengthOfWord;
        for(String word : words){
            if(set.containsKey(word))
                set.put(word, set.get(word) + 1);
            else
                set.put(word, 1);
        }

        for(int i = 0 ; i < s.length(); i++){
            int j = i + lengthOfAnswer;
            if(j > s.length())
                break;
            if(isValid(set, s.substring(i, j), lengthOfWord, words.length))
                result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> set = new HashMap<>();
        set.put("foo", 1);
        set.put("bar",1);
        set.put("the",1);
        String[]words = {"foo", "the", "bar"};
        String[]word1 = {"word", "good", "best", "good"};
        System.out.println(isValid(set, "barthefoo", 3, 3));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", word1));
    }
}

package Medium.Hashtables;

/*
You are playing the Bulls and Cows game with your friend.
You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

The number of "bulls", which are digits in the guess that are in the correct position.
The number of "cows", which are digits in the guess that are in your secret number but are located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.
Given the secret number secret and your friend's guess guess, return the hint for your friend's guess.

The hint should be formatted as "xAyB", where x is the number of bulls and y is the number of cows. Note that both secret and guess may contain duplicate digits.

Example 1:

Input: secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1807"
  |
"7810"

Example 2:

Input: secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: Bulls are connected with a '|' and cows are underlined:
"1123"        "1123"
  |      or     |
"0111"        "0111"
Note that only one of the two unmatched 1s is counted as a cow since the non-bull digits can only be rearranged to allow one 1 to be a bull.

Constraints:

1 <= secret.length, guess.length <= 1000
secret.length == guess.length
secret and guess consist of digits only.
*/

import java.util.HashMap;
import java.util.Map;

public class Bulls_and_Cows {
    public static String getHint(String secret, String guess) {
        HashMap<Character, Integer> ss = new HashMap<>();
        HashMap<Character, Integer> gg = new HashMap<>();
        int bull = 0, cow = 0;
        for(int i = 0; i < secret.length();i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g)
                bull++;
            else{
                if(ss.containsKey(s))
                    ss.put(s, ss.get(s)+1);
                else
                    ss.put(s,1);
                if(gg.containsKey(g))
                    gg.put(g, gg.get(g)+1);
                else
                    gg.put(g,1);
            }
        }
        System.out.println(ss);
        System.out.println(gg);
        for(Map.Entry<Character, Integer> e : gg.entrySet()){
            char key = e.getKey();
            int value = e.getValue();
            if(ss.containsKey(key))
                cow += Math.min(value, ss.get(key));


        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        System.out.println(getHint("1807","7810"));
    }
}

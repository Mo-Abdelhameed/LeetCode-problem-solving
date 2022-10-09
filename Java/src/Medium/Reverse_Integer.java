package Medium;
/*
Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21

Constraints:
-231 <= x <= 231 - 1
*/
public class Reverse_Integer {

    public static boolean isGreaterThanInfinity(String x, boolean negative){
        final String infinity = negative ? (Integer.MIN_VALUE + "").substring(1): Integer.MAX_VALUE + "";
        if(x.length() < infinity.length())
            return false;
        int i;
        for(i = 0; i < x.length(); i++){
            if(x.charAt(i) > infinity.charAt(i))
                return true;
            else if(x.charAt(i) < infinity.charAt(i))
                return false;
        }
        if(Integer.parseInt(x) == Integer.MAX_VALUE)
            return false;
        return i == infinity.length();
    }

    public static int reverse(int x) {
        boolean negative = x < 0;
        String s = x + "";
        int result = 0;
        String reverse = "";
        for(int i = negative ? 1 : 0; i < s.length(); i++)
            reverse = s.charAt(i) + reverse;

        if(isGreaterThanInfinity(reverse, negative))
            return 0;
        return negative ? -Integer.parseInt(reverse) : Integer.parseInt(reverse);
    }

    public static void main(String[] args) {
        System.out.println(isGreaterThanInfinity("321", false));
        int max = Integer.MAX_VALUE;
        //2147483647
        String x = "2147483647";
        System.out.println(reverse(123));
    }
}

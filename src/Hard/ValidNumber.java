package Hard;

/*
A valid number can be split up into these components (in order):

A decimal number or an integer.
(Optional) An 'e' or 'E', followed by an integer.
A decimal number can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
One of the following formats:
One or more digits, followed by a dot '.'.
One or more digits, followed by a dot '.', followed by one or more digits.
A dot '.', followed by one or more digits.
An integer can be split up into these components (in order):

(Optional) A sign character (either '+' or '-').
One or more digits.
For example, all the following are valid numbers: ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"], while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].

Given a string s, return true if s is a valid number.

Example 1:

Input: s = "0"
Output: true

Example 2:

Input: s = "e"
Output: false

Example 3:

Input: s = "."
Output: false


Constraints:

1 <= s.length <= 20
s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot
* */


public class ValidNumber {

    public static boolean isInteger(String s){
        if(s.length() == 0)
            return false;
        if(s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);
        if(s.length() == 0)
            return false;

        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if(!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public static boolean isDecimal(String s){
        if(s.length() == 0)
            return false;
        if(s.charAt(0) == '-' || s.charAt(0) == '+')
            s = s.substring(1);

        if(s.length() == 0 || s.equals("."))
            return false;
        int pointIndex = -1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '.' && pointIndex == -1)
                pointIndex = i;

            else if(c == '.' && pointIndex != -1)
                return false;

            else if(!Character.isDigit(c))
                return false;
        }
        return true;
    }

    public static int indexOfE(String s){
        int index = -1;
        for(int i = 0; i < s.length(); i++)
            if(s.charAt(i) == 'e'|| s.charAt(i) == 'E')
                if(index == -1)
                    index = i;
                else
                    return Integer.MAX_VALUE;

        return index;
    }

    public static boolean isNumber(String s) {

        int e = indexOfE(s);
        if(e == Integer.MAX_VALUE)
            return false;
        if(e == -1)
            return isInteger(s) || isDecimal(s);

        String base = s.substring(0, e);
        String exponent = s.substring(e+1);

        return (isDecimal(base) || isInteger(base)) && isInteger(exponent);
    }

}

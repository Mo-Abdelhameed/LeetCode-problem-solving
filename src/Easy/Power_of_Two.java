package Easy;
/*
Given an integer n, return true if it is a power of two. Otherwise, return false.
An integer n is a power of two, if there exists an integer x such that n == 2x.

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1

Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16

Example 3:

Input: n = 3
Output: false

Constraints:

-231 <= n <= 231 - 1
*/
public class Power_of_Two {
    public static boolean isPowerOfTwo(int n) {
        int log2 = (int)(Math.log(n) / Math.log(2));
        return (n != 0) && Math.pow(2, log2) == n;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(536870912));
    }
}

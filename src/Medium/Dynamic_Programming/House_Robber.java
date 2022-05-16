package Medium.Dynamic_Programming;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12

Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
*/
import java.util.Arrays;

public class House_Robber {
    static int[] dp;
    static final int infinity = Integer.MAX_VALUE;
    public static int rob(int[] nums) {
        dp = new int[nums.length+2];
        Arrays.fill(dp, infinity);
        return rob(nums, nums.length-1);
    }

    public static int rob(int[] nums, int i) {
        if(i == 0)
            return nums[0];

        if(i < 0)
            return 0;

        if(dp[i] != infinity)
            return dp[i];

        int x1 = nums[i] + rob(nums, i-2);
        int x2 = rob(nums, i-1);
        dp[i] = Math.max(x1, x2);
        return dp[i];
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,1};
        System.out.println(rob(x));
    }
}

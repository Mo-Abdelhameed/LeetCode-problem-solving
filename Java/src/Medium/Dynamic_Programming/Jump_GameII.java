package Medium.Dynamic_Programming;

import java.util.Arrays;

/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:

Input: nums = [2,3,0,1,4]
Output: 2

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
*/

public class Jump_GameII {
    static int[] dp;
    public static int jump(int[] nums, int i) {
        if(i == 0)
            return 0;
        if(dp[i] != 0)
            return dp[i];

        int res = Integer.MAX_VALUE;
        for(int j = i-1; j >= 0; j--){
            int temp = jump(nums, j);
            int stepsNeeded = i-j;
            if(nums[j] >= stepsNeeded)
                res = Math.min(res, temp+1);
        }
        dp[i] = res;
        return res;
    }

    public static int jump(int[] nums) {
        dp = new int[nums.length];
        return jump(nums, nums.length-1);
    }

    public static void main(String[] args) {
        int[] x = {2};
        System.out.println(jump(x));
        System.out.println(Arrays.toString(dp));
    }
}

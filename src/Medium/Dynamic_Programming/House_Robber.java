package Medium.Dynamic_Programming;

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

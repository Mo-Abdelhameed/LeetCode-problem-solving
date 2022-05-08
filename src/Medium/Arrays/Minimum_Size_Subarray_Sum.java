package Medium.Arrays;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105
*/

public class Minimum_Size_Subarray_Sum {

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        int temp = 0;
        while(i < nums.length){

            if(j < nums.length && temp < target)
                temp += nums[j++];
            else
                temp -= nums[i++];

            if(temp >= target && min > (j-i))
                min = (j-i);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int [] x = {1,4,4};
        System.out.println(minSubArrayLen(4,x));
    }
}

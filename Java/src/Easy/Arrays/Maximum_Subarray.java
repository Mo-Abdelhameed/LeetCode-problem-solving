package Easy.Arrays;

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Example 2:

Input: nums = [1]
Output: 1

Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
*/

public class Maximum_Subarray {

    public static int allNegative(int[]x){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < x.length; i++){
            if(x[i] > 0)
                return Integer.MIN_VALUE;
            if(x[i] > max)
                max = x[i];
        }
        return max;
    }

    public static int maxSubArray(int[] nums) {
        int isNegative = allNegative(nums);
        if(isNegative != Integer.MIN_VALUE)
            return isNegative;
        int result = 0;
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            if(temp + nums[i] > result)
                temp += nums[i];

            else if(temp + nums[i] < temp && temp + nums[i] <= 0)
                temp = 0;

            else if(temp + nums[i] < temp && temp + nums[i] > 0)
                temp += nums[i];

            else
                temp += nums[i];

            if(result < temp)
                result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        int[]x = {8,-19,5,-4,20};
        //System.out.println(allNegative(x));
        System.out.println(maxSubArray(x));
    }
}

package Hard.Arrays;
/*
Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.

Example 1:

Input: nums = [1,2,0]
Output: 3

Example 2:

Input: nums = [3,4,-1,1]
Output: 2

Example 3:

Input: nums = [7,8,9,11,12]
Output: 1


Constraints:

1 <= nums.length <= 5 * 105
-231 <= nums[i] <= 231 - 1
*/
public class First_Missing_Positive {

    public int firstMissingPositive(int[] nums) {
        boolean f = false;
        for(int n : nums)
            if(n == nums.length) {
                f = true;
                break;
            }

        for(int i = 0 ; i < nums.length ; i++){
            int number = nums[i];
            while(number >= 0 && number < nums.length){
                int newNumber = nums[number];
                nums[number] = Integer.MIN_VALUE;
                number = newNumber;
            }
        }

        for(int i = 1; i < nums.length ; i++){
            if(nums[i] != Integer.MIN_VALUE)
                return i;
        }

        if(f)
            return nums.length+1;
        return nums.length;
    }

}

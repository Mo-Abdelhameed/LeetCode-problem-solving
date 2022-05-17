package Medium.Arrays;
/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
*/
public class Sort_Colors {

    public static void sortColors(int[] nums) {
        int zeros = 0, ones = 0, twos = 0;
        for(int num : nums){
            if(num == 0)
                zeros++;
            else if(num == 1)
                ones++;
            else
                twos++;
        }
        int i = 0;

        while (zeros-- > 0)
            nums[i++] = 0;

        while (ones-- > 0)
            nums[i++] = 1;

        while (twos-- > 0)
            nums[i++] = 2;
    }
}

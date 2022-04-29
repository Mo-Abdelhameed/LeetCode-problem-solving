package Easy;

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].

Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

*/

import java.util.Arrays;
public class Squares_of_a_Sorted_Array {

    public static int search(int[]nums){
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(Math.abs(nums[i]) < Math.abs(nums[i+1]))
                return i;
        }
        return nums.length-1;
    }

    public static int[] sortedSquares(int[] nums) {

        int index = search(nums);
        int[]result = new int[nums.length];
        result[0] = (int) Math.pow(nums[index], 2);
        int currentIndex = 1;
        for(int i = index - 1, j = index + 1; i >= 0 || j < nums.length ; currentIndex++){
            if(i >= 0 && j < nums.length){
                if(Math.abs(nums[i]) > Math.abs(nums[j])){
                    result[currentIndex] = (int) Math.pow(nums[j], 2);
                    j++;
                }
                else if(Math.abs(nums[i]) < Math.abs(nums[j])){
                    result[currentIndex] = (int) Math.pow(nums[i], 2);
                    i--;
                }
                else{
                    result[currentIndex] = (int) Math.pow(nums[i], 2);
                    result[currentIndex+1] = (int) Math.pow(nums[i], 2);
                    i--;
                    j++;
                    currentIndex++;
                }
            }

            else if(i >= 0){
                result[currentIndex] = (int) Math.pow(nums[i], 2);
                i--;
            }
            else if(j < nums.length){
                result[currentIndex] = (int) Math.pow(nums[j], 2);
                j++;
            }
        }
        return result;
    }

}

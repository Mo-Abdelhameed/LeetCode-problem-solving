package Medium.Arrays;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]


Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


Example 3:

Input: nums = [], target = 0
Output: [-1,-1]

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
*/

import java.util.Arrays;
public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public static int searchForIndex(int[] nums, int target){
        int low = 0, high = nums.length-1;
        while (low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;

            if(low == high && nums[low] != target)
                return -1;
        }
        return -1;
    }


    public static int[] optimizeIndex(int[] nums, int index){
        int target = nums[index];
        int low = 0, high = nums.length - 1, start = -1, end = -1;
        int targetIndex = index;
        while(low <= index){
            int mid = (low + index)/2;
            if(nums[mid] != target)
                low = mid + 1;
            else if(mid == 0 || (mid - 1 >= 0 && nums[mid-1] < target)){
                start = mid;
                break;
            }
            else
                index = mid - 1;
        }
        index = targetIndex;
        while(index <= high){
            int mid = (index + high)/2;
            if(nums[mid] != target)
                high = mid - 1;
            else if(mid == nums.length-1 || (mid+1 < nums.length && nums[mid+1] > target)){
                end = mid;
                break;
            }
            else
                index = mid + 1;
        }
        int [] result = {start, end};
        return result;
    }

    public static int[] searchRange(int[] nums, int target) {
        int index = searchForIndex(nums, target);
        if(index == -1){
            int [] res = {-1, -1};
            return res;
        }
        int [] result = optimizeIndex(nums, index);
        return result;
    }

    public static void main(String[] args) {
        int[]x = {1,1,3,4,4,4,4,6,6};
        System.out.println(Arrays.toString(searchRange(x, 3)));
    }
}

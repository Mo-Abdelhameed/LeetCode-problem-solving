package Easy.BinarySearch;

/*
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
*/

public class Search_Insert_Position {

    public static int searchInsert(int[] nums, int target) {
        if(nums[0] > target)
            return 0;
        if(nums[nums.length-1] < target)
            return nums.length;
        int low = 0, high = nums.length-1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target || (mid - 1 >= 0 && nums[mid] > target && nums[mid-1] < target))
                return mid;

            if(mid + 1 < nums.length && nums[mid] < target && nums[mid+1] > target)
                return mid+1;

            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {1,2,4,5,6};
        System.out.println(searchInsert(x, 3));
    }
}

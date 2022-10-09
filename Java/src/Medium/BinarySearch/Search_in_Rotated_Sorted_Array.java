package Medium.BinarySearch;
/*
* There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
* */
public class Search_in_Rotated_Sorted_Array {

    public static int binarySearch(int[]arr, int target, int start, int end){
        while (start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] > target)
                end = mid - 1;
            else if(arr[mid] < target)
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static int indexOfRotation(int[] nums){
        int start = 0, end = nums.length - 1;
        while (start < end){
            int mid = (start + end)/2;
            if(mid+1 < nums.length && nums[mid] > nums[mid+1])
                return mid+1;
            else if(mid-1 >=0 && nums[mid] < nums[mid-1])
                return mid;
            else if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else if(nums[mid] < nums[start]){
                end = mid - 1;
            }
            else
                break;
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int indexOfRotation = indexOfRotation(nums);
        int result = -1;

        if(indexOfRotation == -1)
            return binarySearch(nums, target, 0, nums.length-1);

        int res1 = binarySearch(nums, target, 0, indexOfRotation-1);
        int res2 = binarySearch(nums, target, indexOfRotation, nums.length-1);
        return Math.max(res1, res2);
    }

    public static void main(String[] args) {
        int x [] = {3,4,5,0,1,2};
        System.out.println(search(x, 5));
    }
}

package Medium.Arrays;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Example 2:

Input: nums = []
Output: []

Example 3:

Input: nums = [0]
Output: []

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {

    public static ArrayList<ArrayList<Integer>> twoSum(int[] arr, int start, int end, int target){
        int i = start, j = end;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (i < j){
            if(arr[i] + arr[j] > target)
                j--;
            else if (arr[i] + arr[j] < target)
                i++;
            else{
                ArrayList<Integer> r = new ArrayList<>();
                r.add(arr[i]);
                r.add(arr[j]);
                result.add(r);
                i++;
                j--;
                while (i < arr.length && arr[i-1] == arr[i])
                    i++;

                while (j >= 0 && arr[j+1] == arr[j])
                    j--;
            }
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length-2; i++){
            int target = -nums[i];
            ArrayList<ArrayList<Integer>> r = twoSum(nums, i+1, nums.length-1, target);
            for(ArrayList<Integer> array : r) {
                array.add(nums[i]);
                result.add(array);
            }
            while(i+1 < nums.length && nums[i+1] == nums[i])
                i++;
        }
        return result;
    }
}

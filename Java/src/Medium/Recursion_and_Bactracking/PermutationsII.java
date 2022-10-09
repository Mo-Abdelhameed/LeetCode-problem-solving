package Medium.Recursion_and_Bactracking;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]

Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class PermutationsII {

    public static int[] arrayToList(int[] arr, int index){
        int[]res = new int[arr.length-1];
        for(int i = 0, j = 0; i < arr.length && j < res.length; i++, j++) {
            if (i == index) {
                j--;
                continue;
            }
            res[j] = arr[i];
        }
        return res;
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 1){
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);
            list.add(l);
            return list;
        }
        if(nums.length == 2){
            List<List<Integer>> list = new ArrayList<>();
            List<Integer> l1 = new ArrayList<>();
            List<Integer> l2 = new ArrayList<>();
            l1.add(nums[0]);
            l1.add(nums[1]);
            list.add(l1);
            if(nums[0] == nums[1])
                return list;
            l2.add(nums[1]);
            l2.add(nums[0]);
            list.add(l2);
            return list;
        }
        List<List<Integer>> result = new ArrayList<>();
        HashSet<Integer> used = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(used.contains(nums[i]))
                continue;
            used.add(nums[i]);
            int[] temp = arrayToList(nums, i);
            List<List<Integer>> p = permuteUnique(temp);
            for(List<Integer> l : p){
                l.add(nums[i]);
                result.add(l);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[]x = {1,1,2};
        System.out.println(permuteUnique(x));
    }
}

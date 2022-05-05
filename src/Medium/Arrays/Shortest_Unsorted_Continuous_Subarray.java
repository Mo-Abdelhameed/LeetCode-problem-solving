package Medium.Arrays;

/*
Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
Return the shortest such subarray and output its length.



Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.

Example 2:

Input: nums = [1,2,3,4]
Output: 0

Example 3:

Input: nums = [1]
Output: 0


Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
*/

import java.util.Collections;
import java.util.LinkedList;

public class Shortest_Unsorted_Continuous_Subarray {
    public static int findUnsortedSubarray(int[] nums) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int num : nums)
            list.add(num);
        Collections.sort(list);

        int i = 0, j = nums.length;
        while(!list.isEmpty()){
            if(nums[i] == list.peekFirst()){
                list.removeFirst();
                i++;
            }
            else
                break;
        }
        while(!list.isEmpty()){
            if(nums[j-1] == list.peekLast()){
                list.removeLast();
                j--;
            }
            else
                break;
        }
        return j - i;
    }
}

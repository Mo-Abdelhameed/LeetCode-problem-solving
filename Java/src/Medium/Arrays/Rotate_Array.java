package Medium.Arrays;

/*
Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105
*/

import java.util.LinkedList;

public class Rotate_Array {
    public static void rotate(int[] nums, int k) {
        int rotations = k % nums.length;
        LinkedList<Integer> list = new LinkedList<>();
        for(int number : nums){
            list.add(number);
        }

        while (rotations-- > 0){
            list.addFirst(list.removeLast());
        }
        for(int i = 0; i < nums.length; i++)
            nums[i] = list.removeFirst();
    }
}

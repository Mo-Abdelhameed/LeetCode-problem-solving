package Medium.Hashtables;

/*
You are given an integer array nums and an integer k.
In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.

Example 1:

Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:

Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= k <= 109
*/

import java.util.HashMap;
public class Max_Number_of_K_Sum_Pairs {

    public static int maxOperations(int[] nums, int k) {
        if(nums.length == 1)
            return 0;
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            if(map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        System.out.println(map);
        for(int num : nums){
            int current = num;
            int target = k - current;
            int currentOccurred = map.get(num);
            int targetOccurred = map.containsKey(target) ? map.get(target) : -1;

            if(targetOccurred == -1 || currentOccurred == 0)
                continue;

            if(current == target && currentOccurred > 1){
                result++;
                map.put(current, map.get(current) - 2);
            }

            else if(current != target && targetOccurred > 0){
                result++;
                map.put(current, currentOccurred - 1);
                map.put(target, targetOccurred - 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int x [] = {2,1,3,1,1,2,1,2,2,3,2,2};
        int k = 3;
        System.out.println(maxOperations(x,k));

    }
}

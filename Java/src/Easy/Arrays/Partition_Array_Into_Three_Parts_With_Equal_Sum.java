package Easy.Arrays;
/*
Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.

Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

Example 1:

Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

Example 2:

Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false

Example 3:

Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4

Constraints:

3 <= arr.length <= 5 * 104
-104 <= arr[i] <= 104
*/
public class Partition_Array_Into_Three_Parts_With_Equal_Sum {

    public static boolean canThreePartsEqualSum(int[] arr) {

        boolean zeros = true;
        int sum = 0;
        for(int num : arr) {
            sum += num;
            if(zeros && num != 0)
                zeros = false;
        }
        if(zeros)
            return true;
        if(sum % 3 != 0)
            return false;

        int target = sum/3;

        int temp = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            temp += arr[i];
            if(temp == target) {
                count++;
                temp = 0;
            }
        }
        return count == 3;
    }

    public static void main(String[] args) {
        int[] x =
                {0,0,0,0};
        System.out.println(canThreePartsEqualSum(x));
    }
}

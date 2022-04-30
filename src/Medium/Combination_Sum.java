package Medium;

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.



Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.


Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]


Example 3:

Input: candidates = [2], target = 1
Output: []

Constraints:

1 <= candidates.length <= 30
1 <= candidates[i] <= 200
All elements of candidates are distinct.
1 <= target <= 500
*/

import java.util.*;

public class Combination_Sum {

    static List<List<Integer>> result = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        combinationSum(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    public static void combinationSum(int[] candidates, int target, ArrayList<Integer> res, int i) {

        if(i == candidates.length || target < 0)
            return;

        combinationSum(candidates, target, res, i+1);

        if(target - candidates[i] > 0){
            res.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], res, i);
            res.remove(res.size()-1);
        }
        else if(target - candidates[i] == 0){
            res.add(candidates[i]);
            result.add((ArrayList)res.clone());
            res.remove(res.size()-1);
        }
    }

    public static void main(String[] args) {
        int [] c = {2,3,6,7};
        int target = 7;
        combinationSum(c, target);
        System.out.println(result);
    }
}

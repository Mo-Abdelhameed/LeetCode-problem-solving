from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) == 1:
            return [nums]
        first_num = nums.pop(0)
        rest = nums.copy()

        rest_perm = self.permute(rest)

        result = []
        for perm in rest_perm:
            for i in range(len(perm) + 1):
                perm_copy = perm.copy()
                perm_copy.insert(i, first_num)
                result.append(perm_copy)

        return result

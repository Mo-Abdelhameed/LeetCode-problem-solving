from typing import List


class Solution:
    def rowAndMaximumOnes(self, mat: List[List[int]]) -> List[int]:
        i = 0
        max_sum = -1
        for i, row in enumerate(mat):
            row_sum = sum(row)
            if max_sum < row_sum:
                max_sum = row_sum
                max_index = i

        return [max_index, max_sum]

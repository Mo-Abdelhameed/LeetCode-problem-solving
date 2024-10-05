from typing import List


class Solution:
    def maxDivScore(self, nums: List[int], divisors: List[int]) -> int:
        max_score = 0
        max_d = divisors[0]
        for d in divisors:
            score = 0
            for n in nums:
                if n % d == 0:
                    score += 1

            if max_score == score:
                max_d = min(max_d, d)

            if max_score < score:
                max_score = score
                max_d = d

        return max_d

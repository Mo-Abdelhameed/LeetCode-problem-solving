from typing import List


class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        left, result = 0, 0
        product = 1
        for right in range(len(nums)):
            product *= nums[right]

            while product >= k and left <= right:
                product /= nums[left]
                left += 1

            result += right - left + 1

        return result


s = Solution()

x = s.numSubarrayProductLessThanK([10, 5, 2, 6], k=100)
print(x)

from typing import List


class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        pos, neg = 0, 0
        start = 0
        end = len(nums) - 1

        if nums[-1] < 0:
            return len(nums)

        while start <= end:
            mid = (start + end) // 2
            current = nums[mid]

            if current >= 0:
                end = mid - 1
            elif nums[mid + 1] >= 0:
                neg += mid + 1
                break
            else:
                start = mid + 1

        nums = nums[neg:]
        start = 0
        end = len(nums) - 1

        if nums[0] > 0:
            pos = len(nums)
            return max(neg, pos)

        while start <= end:
            mid = (start + end) // 2
            current = nums[mid]

            if current == 0:
                start = mid + 1
            elif nums[mid - 1] > 0:
                end = mid - 1
            else:
                pos += len(nums[mid:])
                break

        return max(neg, pos)

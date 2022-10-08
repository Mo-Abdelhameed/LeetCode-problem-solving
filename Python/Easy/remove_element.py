class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        number_of_targets = 0
        index = 0
        for i in nums:
            if i == val:
                number_of_targets += 1
            else:
                nums[index] = i
                index += 1
        return len(nums) - number_of_targets
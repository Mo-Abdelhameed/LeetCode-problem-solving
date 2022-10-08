class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        index_map = {} 
        for (index, item) in enumerate(nums):
            index_map[item] = index

        for (index, item) in enumerate(nums):
            if(target - item in index_map and index_map[target-item] != index):
                return [index, index_map[target-item]]
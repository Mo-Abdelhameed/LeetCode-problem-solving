from typing import Optional, List


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def averageOfLevels(self, root: Optional[TreeNode]) -> List[float]:
        results = []
        current_list, temp_list, values = [root], [], []
        while len(current_list) != 0:
            node = current_list.pop(0)
            if node is None:
                continue

            if node.left is not None:
                temp_list.append(node.left)

            if node.right is not None:
                temp_list.append(node.right)

            values.append(node.val)

            if len(current_list) == 0:
                avg = sum(values) / len(values)
                results.append(avg)
                current_list = temp_list.copy()
                temp_list, values = [], []

        return results

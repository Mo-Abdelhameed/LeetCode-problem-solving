from typing import List


class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 1:
            return strs[0]

        sorted_str = sorted(strs)
        first = sorted_str[0]
        last = sorted_str[-1]

        longest_common_prefix = ""

        if first == "":
            return ""

        for i in range(max(len(first), len(last))):
            if i < len(first) and i < len(last):
                if first[i] == last[i]:
                    longest_common_prefix += first[i]
                else:
                    return longest_common_prefix
            else:
                return longest_common_prefix

        return longest_common_prefix

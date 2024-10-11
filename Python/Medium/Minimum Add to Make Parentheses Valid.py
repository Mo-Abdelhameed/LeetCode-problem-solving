class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        if s == "":
            return 0
        insert = 0
        stack = []
        for char in s:
            if char == "(":
                stack.append(char)
            elif len(stack) > 0:
                stack.pop(-1)
            else:
                insert += 1

        insert += len(stack)
        return insert

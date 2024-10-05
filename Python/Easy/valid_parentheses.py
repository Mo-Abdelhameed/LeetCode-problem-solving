class Solution:

    def match(self, c1, c2) -> bool:
        if c1 == "(" and c2 == ")":
            return True
        if c1 == "[" and c2 == "]":
            return True
        if c1 == "{" and c2 == "}":
            return True
        return False

    def isValid(self, s: str) -> bool:
        stack = []
        open = {"(", "{", "["}

        for bracket in s:
            if bracket in open:
                stack.append(bracket)
            else:
                if len(stack) == 0:
                    return False

                top_stack = stack.pop(-1)
                if not self.match(top_stack, bracket):
                    return False
        return len(stack) == 0

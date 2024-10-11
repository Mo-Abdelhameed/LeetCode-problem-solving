class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False
        total_chars = len(s1)
        letter_occur = {}
        for char in s1:
            if char in letter_occur:
                letter_occur[char] += 1
            else:
                letter_occur[char] = 1

        for window_start in range(0, len(s2) - total_chars + 1):
            window_end = window_start + total_chars
            substring = s2[window_start:window_end]

            letter_occur_copy = letter_occur.copy()
            valid_windows = True
            for char in substring:
                if char in letter_occur_copy:
                    letter_occur_copy[char] -= 1
                    if letter_occur_copy[char] == 0:
                        del letter_occur_copy[char]
                else:
                    valid_windows = False
                    break

            if valid_windows:
                return True

        return False


s = Solution()
x = s.checkInclusion("ab", "dcdakjbkjnc")
print(x)

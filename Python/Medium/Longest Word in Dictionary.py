from typing import List


class Solution:
    def longestWord(self, words: List[str]) -> str:
        longest_length = 0
        for word in words:
            longest_length = max(longest_length, len(word))

        word_map = {k: set() for k in range(1, longest_length + 1)}

        for word in words:
            word_map[len(word)].add(word)

        best_word = ""
        for word in words:
            found = True
            for i in range(1, len(word)):
                subword = word[:i]
                if subword not in word_map[len(subword)]:
                    found = False
                    break
            if found and (
                (len(word) > len(best_word))
                or (len(word) == len(best_word) and word < best_word)
            ):
                best_word = word

        return best_word

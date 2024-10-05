class Solution:

    def perform_operation(self, word):
        result = ""
        for char in word:
            next_char = chr(ord(char) + 1)
            if char == "z":
                next_char == "a"

            result += next_char

        return word + result

    def kthCharacter(self, k: int) -> str:
        word = "a"
        while len(word) < k:
            word = self.perform_operation(word)

        return word[k - 1]

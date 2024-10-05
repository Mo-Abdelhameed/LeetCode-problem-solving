class Solution:

    def RLE(self, str_number: str):

        if len(str_number) == 1:
            return "1" + str_number

        i = 0
        result = ""
        current_count = 0
        while i < len(str_number):
            current = str_number[i]

            if i + 1 < len(str_number):
                next = str_number[i + 1]
            else:
                next = None

            current_count += 1

            if next != current:
                result += str(current_count) + current
                current_count = 0

            i += 1

        if current_count > 0:
            result += current_count + current

        return result

    def countAndSay(self, n: int) -> str:
        return "1" if n == 1 else self.RLE(str(self.countAndSay(n - 1)))

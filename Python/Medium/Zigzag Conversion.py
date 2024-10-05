from typing import Tuple


class Solution:

    def get_next_row(self, row: int, num_rows: int, direction: str) -> Tuple[int, str]:
        if direction == "down":
            if row < num_rows - 1:
                row += 1
            else:
                row -= 1
                direction = "up"
        else:
            if row > 0:
                row -= 1
            else:
                row += 1
                direction = "down"
        return row, direction

    def convert(self, s: str, numRows: int) -> str:
        matrix = [[] for i in range(numRows)]
        row_index = 0
        direction = "down"
        for char in s:
            matrix[row_index].append(char)
            row_index, direction = self.get_next_row(row_index, numRows, direction)

        result = ""
        for row in matrix:
            result += "".join(row)

        return result

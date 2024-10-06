from typing import List, Tuple


class Solution:

    def expand(
        self,
        grid: List[List[int]],
        visited: List[List[int]],
        expanded_cell: Tuple[int, int],
    ):
        cells = [expanded_cell]
        expanded_neighbors = []
        result = 0

        while len(cells) != 0:
            i, j = cells.pop(0)
            result += 1
            visited[i][j] = True

            if i > 0 and grid[i - 1][j] == 1 and not visited[i - 1][j]:  # Looking Above
                expanded_neighbors.append((i - 1, j))
                visited[i - 1][j] = True

            if (
                i < len(grid) - 1 and grid[i + 1][j] == 1 and not visited[i + 1][j]
            ):  # Looking Below
                expanded_neighbors.append((i + 1, j))
                visited[i + 1][j] = True

            if j > 0 and grid[i][j - 1] == 1 and not visited[i][j - 1]:  # Looking Left
                expanded_neighbors.append((i, j - 1))
                visited[i][j - 1] = True

            if (
                j < len(grid[0]) - 1 and grid[i][j + 1] == 1 and not visited[i][j + 1]
            ):  # Looking Right
                expanded_neighbors.append((i, j + 1))
                visited[i][j + 1] = True

            if len(cells) == 0:
                cells = expanded_neighbors.copy()
                expanded_neighbors = []

        return result

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        area = 0
        visited = [[False] * len(grid[0]) for i in range(len(grid))]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                current_value = grid[i][j]

                if current_value == 1 and not visited[i][j]:
                    area = max(self.expand(grid, visited, (i, j)), area)

        return area

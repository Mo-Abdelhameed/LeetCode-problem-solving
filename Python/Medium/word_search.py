"""
Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.

https://leetcode.com/problems/word-search/

"""
class Solution(object):

    def search_for_answer(self, board, word, start):
        queue = []
        search_index = 1
        used = set()
        i, j = start
        used.add(start)
        queue.append((i, j, search_index, used))

        while(len(queue) != 0):
            i, j, search_index, used = queue.pop(-1)
            if(search_index == len(word)):
                return True

            if i > 0 and (not (i-1, j) in used) and board[i-1][j] == word[search_index]:
                clone_used = set(used)
                clone_used.add((i-1, j))
                queue.append((i-1, j, search_index + 1, clone_used))

            if i < len(board) - 1 and (not (i+1, j) in used) and board[i+1][j] == word[search_index]:
                clone_used = set(used)
                clone_used.add((i+1, j))
                queue.append((i+1, j, search_index + 1, clone_used))
                
            if j > 0 and (not (i, j-1) in used) and board[i][j-1] == word[search_index]:
                clone_used = set(used)
                clone_used.add((i, j-1))
                queue.append((i, j-1, search_index + 1, clone_used))
                

            if j < len(board[0]) - 1 and (not (i, j+1) in used) and board[i][j+1] == word[search_index]:
                clone_used = set(used)
                clone_used.add((i, j+1))
                queue.append((i, j+1, search_index + 1, clone_used))
            
        return False

    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """

        first = word[0]
        starting_points = []
        for i in range(0, len(board)):
            for j in range(0, len(board[0])):
                if board[i][j] == first:
                    starting_points.append((i, j))

        for starting_point in starting_points:
            if self.search_for_answer(board, word, starting_point):
                return True
        return False



            

 



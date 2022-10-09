class Solution(object):
    def generateMatrix(n):
        """
        :type n: int
        :rtype: List[List[int]]
        """
        direction = 'right'
        result = [ [None]*n for i in range(n) ]
        row = column = 0
        for i in range(1, n**2 + 1):
            result[row][column] = i
            if direction == 'right':
                if column + 1 < n and result[row][column+1] == None:
                    column += 1
                else:
                    direction = 'down'
                    row += 1

            elif direction == 'down':
                if row + 1 < n and result[row+1][column] == None:
                    row += 1
                else:
                    direction = 'left'
                    column -=1

            elif direction == 'left':
                if column - 1 >= 0 and result[row][column-1] == None:
                    column -= 1
                else:
                    direction = 'up'
                    row -= 1
            
            elif direction == 'up':
                if row - 1 >= 0 and result[row-1][column] == None:
                    row -= 1
                else:
                    direction = 'right'
                    column += 1
        return result
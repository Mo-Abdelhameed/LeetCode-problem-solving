class Solution(object):
    dp = []
    def uniquePaths(self, m, n):
        """
        :type m: int
        :type n: int
        :rtype: int
        """
        self.dp = [[0] * n for i in range(m)]
        return self.find_path(m, n, 0, 0) 
    

    def find_path(self, m, n, i, j):
        if self.dp[i][j] != 0:
            return self.dp[i][j]

        if i == m - 1 and j == n - 1:
            self.dp[i][j] = 1
            return 1
        
        right = down = 0
        if i + 1 < m:
            down = self.dp[i+1][j] = self.find_path( m, n, i+1, j)
        if j + 1 < n:
            right = self.dp[i][j+1] = self.find_path(m, n, i, j+1)
        self.dp[i][j] = right + down
        return self.dp[i][j]

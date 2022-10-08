class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        array = list(str(x))
        while(len(array) > 1):
            first = array.pop(0)
            last = array.pop(len(array)-1)
            if first != last:
                return False
        return True
class Solution(object):
    def plusOne(digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        s = ''
        for i in digits:
            s += str(i)
        s = int(s)
        s += 1
        s = str(s)
        digits = [int(item) for item in s]
        return digits
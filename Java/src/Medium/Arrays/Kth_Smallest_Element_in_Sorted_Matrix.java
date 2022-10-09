package Medium.Arrays;

/*
Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

You must find a solution with a memory complexity better than O(n2).



Example 1:

Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
Output: 13
Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13

Example 2:

Input: matrix = [[-5]], k = 1
Output: -5

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 300
-109 <= matrix[i][j] <= 109
All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
1 <= k <= n2
*/

import java.util.Arrays;
import java.util.PriorityQueue;

public class Kth_Smallest_Element_in_Sorted_Matrix {

    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[] indices = new int[matrix.length];
        for(int i = 0; i < indices.length; i++){
            int number = matrix[i][0];
            int row = i;
            Pair p = new Pair(number, row);
            q.add(p);
        }
        int i = 0;
        while(i < k){
            Pair p = q.poll();
            int number = p.number;
            int row = p.row;
            int column = ++indices[row];
            if(column < matrix.length)
                q.add(new Pair(matrix[row][column], row));
            i++;
            if(i == k)
                return number;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;

        System.out.println(kthSmallest(matrix, k));
    }
}

class Pair implements Comparable{
    int number;
    int row;

    public Pair(int number, int row){
        this.number = number;
        this.row = row;
    }

    @Override
    public int compareTo(Object o) {
        Pair p = (Pair)o;
        int n = this.number;
        int m = p.number;
        return n - m;
    }
}

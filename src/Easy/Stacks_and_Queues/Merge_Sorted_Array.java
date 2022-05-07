package Easy.Arrays;

import java.util.*;

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
       Queue<Integer> q = new LinkedList<>();
       int j = 0;
       for(int i = 0; i < m; i++)
           q.add(nums1[i]);

       for(int i = 0; i < m+n; i++){
           if(q.isEmpty())
               nums1[i] = nums2[j++];
           else if(j == n)
               nums1[i] = q.poll();
           else if(q.peek() <= nums2[j])
               nums1[i] = q.poll();
           else
               nums1[i] = nums2[j++];
       }
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,0,0,0};
        int[] y = {2,5,6};
        merge(x,3,y,3);
        System.out.println(Arrays.toString(x));
    }
}

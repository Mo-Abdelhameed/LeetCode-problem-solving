package Medium.Stacks_and_Queues;

/*
*Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).


Example 1:

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].


Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.


Constraints:

1 <= k <= points.length <= 104
-104 < xi, yi < 104
*/


import java.util.Arrays;
import java.util.PriorityQueue;
public class K_Closes_Points_to_Origin {

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt((Math.pow(x, 2) + (Math.pow(y, 2))));
            Node n = new Node(points[i], distance);
            q.add(n);
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++)
            result[i] = q.poll().node;
        return result;
    }

    public static void main(String[] args) {
        int k = 1;
        int[][] l = {{1, 3}, {-2, 2}};
        System.out.println(Arrays.toString(kClosest(l, k)[0]));
    }
}
class Node implements Comparable{

    int[] node;
    double distanceFromOrigin;

    public Node(int[] node, double distanceFromOrigin){
        this.node = node;
        this.distanceFromOrigin = distanceFromOrigin;
    }

    @Override
    public int compareTo(Object o) {
        Node n = (Node)o;
        return (this.distanceFromOrigin > n.distanceFromOrigin ) ? 1 : -1;
    }
}

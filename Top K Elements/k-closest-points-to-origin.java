// Source: LeetCode
// https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> Double.compare(b.distance, a.distance));

        for (int[] point : points) {
            Point p = new Point(point[0], point[1]);

            if (pq.size() == k && p.distance < pq.peek().distance)
                pq.poll();

            if (pq.size() < k)
                pq.add(p);
        }

        int[][] result = new int[pq.size()][2];

        int j = 0;

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            result[j] = new int[] { p.X, p.Y };
            j++;
        }

        return result;
    }
}

public class Point {
    public double distance;
    public int X;
    public int Y;

    public Point(int x, int y) {
        this.X = x;
        this.Y = y;
        this.distance = calculateDistance(x, y);
    }

    private double calculateDistance(int x, int y) {
        return Math.sqrt((x * x) + (y * y));
    }
}
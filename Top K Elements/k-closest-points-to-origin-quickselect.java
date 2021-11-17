// Source: LeetCode
// https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int left = 0, right = points.length - 1;

        Random rand = new Random();
        while (left <= right) {

            // partition the array around a random pivot
            int randomVal = left + rand.nextInt(right - left + 1);
            int finalPivotLocation = partition(points, left, right, randomVal);

            // if the pivot is at the Kth position, we are finished
            if (finalPivotLocation == K)
                break;

            if (finalPivotLocation < K) { // if the pivot location is less than k, partition again to the right of the
                                          // pivot
                left = finalPivotLocation + 1;
            } else { // if the pivot location is greater than k, partition again to the left of the
                     // pivot
                right = finalPivotLocation - 1;
            }
        }
        return Arrays.copyOfRange(points, 0, K);
    }

    private int partition(int[][] points, int left, int right, int pivotIndex) {
        // store pivot value and tail end of left subarray
        int pivotValue = distance(points[pivotIndex]);
        int finalPivotLocation = left;

        // swap pivot into right
        swap(pivotIndex, right, points);

        // partition the array
        for (int i = left; i < right; i++) {
            if (distance(points[i]) < pivotValue) {
                swap(i, finalPivotLocation, points);
                finalPivotLocation++;
            }
        }

        // swap pivot value into its correct place
        swap(finalPivotLocation, right, points);

        // return the final pivot location
        return finalPivotLocation;
    }

    private int distance(int[] point) {
        int dist = point[0] * point[0] + point[1] * point[1];
        return dist;
    }

    // swaps values of array at indices a and b
    private void swap(int a, int b, int[][] points) {
        int[] temp = points[a];
        points[a] = points[b];
        points[b] = temp;
    }
}
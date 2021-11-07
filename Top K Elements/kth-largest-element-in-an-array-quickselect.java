// Source: LeetCode
// https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    int[] nums;

    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;
        // kth largest is N-kth smallest element when chosen as pivot
        return quickselect(0, size - 1, size - k);
    }

    public int quickselect(int left, int right, int k) {
        if (left == right)
            return this.nums[left];

        // choose a random pivot
        Random rand = new Random();
        int pivotIndex = left + rand.nextInt(right - left);

        // partition array such that left of pivot is <= pivot, right of pivot is >
        // pivot
        pivotIndex = partition(left, right, pivotIndex);

        // if the pivot index is the kth smallest element return it
        if (k == pivotIndex)
            return this.nums[k];
        else if (k < pivotIndex) // if the pivot position is greater than k recurse into left half
            return quickselect(left, pivotIndex - 1, k);
        else // if the pivot position is less than k recurse into the right half
            return quickselect(pivotIndex + 1, right, k);
    }

    // partition function
    public int partition(int left, int right, int pivot) {
        int pivotNum = this.nums[pivot];

        // move pivot all the way right
        swap(right, pivot);

        // store the index that represents the end of the left partition
        int leftPart = left;

        for (int i = left; i <= right; i++) {
            if (this.nums[i] < pivotNum) {
                swap(leftPart, i);
                leftPart++;
            }
        }

        // move the pivot to its correct location
        swap(leftPart, right);

        return leftPart;
    }

    // swap function
    public void swap(int first, int second) {
        int tmp = this.nums[first];
        this.nums[first] = this.nums[second];
        this.nums[second] = tmp;
    }
}
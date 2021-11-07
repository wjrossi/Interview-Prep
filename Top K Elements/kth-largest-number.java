// Source: LeetCode
// https://leetcode.com/problems/kth-largest-element-in-an-array/ 

class Solution {
    public int findKthLargest(int[] nums, int k) {

        // use a min heap of size k to store the K largest numbers
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> a - b);

        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k)
                heap.poll();
        }

        // return the root of the heap which is the kth largest number
        return heap.poll();
    }
}
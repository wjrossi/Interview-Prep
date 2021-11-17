// Source: Educative
// https://www.educative.io/courses/grokking-the-coding-interview/myAqDMyRXn3

class KthSmallestInMSortedArrays {

    public static int findKthSmallest(List<Integer[]> lists, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));
        int maxLen = 0;

        // calculate the maximum length we need
        for (Integer[] list : lists) {
            maxLen = Math.max(list.length, maxLen);
        }

        // take ith index of each list and add it to heap if val < root
        int i = 0;
        while (i < maxLen) {
            for (Integer[] list : lists) {
                // skip the list if we're past its upper bound
                if (list.length <= i)
                    continue;

                // add the ith index of the list to the heap if the heap size is < k
                // or the heap size is >= k and the value is less than the root of the heap
                if (maxHeap.size() >= k) {
                    if (list[i] < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.offer(list[i]);
                    }
                } else {
                    maxHeap.offer(list[i]);
                }
            }
            i++;
        }

        // return the root of the heap of size k, which will be the kth smallest number
        return maxHeap.peek();
    }
}

// Source: Educative
// https://www.educative.io/courses/grokking-the-coding-interview/gxxPGn8vE8G

import java.util.*;

class KthSmallestNumber {

  public static int findKthSmallestNumber(int[] nums, int k) {


    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a, b) -> b - a);

    for (int num : nums) {
      heap.add(num);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    return heap.peek();
  }
}

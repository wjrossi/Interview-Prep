// Source: LeetCode
// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        // create a min heap based on the values of the ListNodes
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((a, b) -> Integer.compare(a.val, b.val));

        // add the first ListNode from each list to the minheap (these will have the
        // smallest values)
        for (ListNode node : lists) {
            if (node != null)
                minHeap.offer(node);
        }

        ListNode head = null;
        ListNode currHead = null;

        while (!minHeap.isEmpty()) {
            // get the ListNode with the smallest value
            ListNode curr = minHeap.poll();

            // add its next value to the heap if it exists
            if (curr.next != null) {
                minHeap.offer(curr.next);
            }

            // add it to the result list
            if (currHead == null) {
                head = new ListNode(curr.val);
                currHead = head;
            } else {
                currHead.next = curr;
                currHead = currHead.next;
            }
        }

        // return the head of the resulting list
        return head;
    }
}
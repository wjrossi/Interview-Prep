// Source: LeetCode
// https://leetcode.com/problems/rearrange-string-k-distance-apart/

class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0)
            return s;

        // create character frequency map
        HashMap<Character, Integer> freq = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        // all all characters to a maxHeap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue((a, b) -> Integer.compare(freq.get(b), freq.get(a)));
        maxHeap.addAll(freq.keySet());

        StringBuilder result = new StringBuilder();

        // attempt to place characters starting with most frequent
        while (!maxHeap.isEmpty()) {

            // get the current character, decrement its frequency,
            // and add it to the result
            char c = maxHeap.poll();
            freq.put(c, freq.get(c) - 1);
            result.append(c);

            // Characters are added back in the heap in the order they were removed, AFTER we have moved a safe distance
            // Whenever all the instances of a particular char is exhausted, then the heap
            // size is reduced as it is not added back in the heap
            if (result.length() >= k) {
                if (freq.get(result.charAt(result.length() - k)) > 0)
                    maxHeap.offer(result.charAt(result.length() - k));
            }
        }

        return result.length() == s.length() ? result.toString() : "";
    }
}
// Source: LeetCode
// https://leetcode.com/problems/top-k-frequent-elements/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length)
            return nums;

        // create a map of element -> frequency
        HashMap<Integer, Integer> map = new HashMap();

        for (int num : nums) { // calculate frequency of each element
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // create buckets from the frequencies and add the numbers to their respective
        // buckets
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }

        // now buckets is a mapping of frequency -> numbers with that frequency
        // where the index of buckets is the frequency

        int resultCount = 0;
        int[] result = new int[k];

        // go through the buckets backwards (so we start with greatest frequency) and
        // add numbers to result array
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    if (resultCount < k) {
                        result[resultCount] = num;
                        resultCount++;
                    }
                }
            }
        }

        return result;
    }
}
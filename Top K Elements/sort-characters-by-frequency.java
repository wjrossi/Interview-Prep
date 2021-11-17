// Source: LeetCode
// https://leetcode.com/problems/sort-characters-by-frequency/

class Solution {
    public String frequencySort(String s) {
        // lower bound
        if (s.length() <= 1)
            return s;

        // create the frequency map
        HashMap<Character, Integer> freq = new HashMap<Character, Integer>();

        // populate the frequency map
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // create the bucket array
        List<Character>[] buckets = new List[s.length() + 1];

        // populate the buckets such that each index represents a frequency
        // and contains a list of chars with that frequency
        for (Character c : freq.keySet()) {
            int charFrequency = freq.get(c);
            if (buckets[charFrequency] == null)
                buckets[charFrequency] = new ArrayList<Character>();
            buckets[charFrequency].add(c);
        }

        StringBuilder result = new StringBuilder();
        // for every index in buckets (decreasing order), append <index> number of the
        // chars at that index
        // to the result string
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null)
                continue;
            for (Character c : buckets[i]) {
                for (int j = 0; j < i; j++) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
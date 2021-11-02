// Source: Leetcode

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        // return first letter in circular array if target > last letter
        if (letters[letters.length - 1] <= target)
            return letters[0];

        // search for the target
        int start = 0, end = letters.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // at this point start will be the smallest letter greater than target or equal
        // to the target
        return letters[start] > target ? letters[start] : letters[start + 1];
    }
}
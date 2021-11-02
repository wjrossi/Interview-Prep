// Source: Leetcode

class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, char[]> digitToChar = new HashMap();
        List<String> result = new LinkedList();

        // null case
        if (digits == null || digits.isEmpty()) {
            return result;
        }

        // create digit to char map
        digitToChar.put('2', new char[] { 'a', 'b', 'c' });
        digitToChar.put('3', new char[] { 'd', 'e', 'f' });
        digitToChar.put('4', new char[] { 'g', 'h', 'i' });
        digitToChar.put('5', new char[] { 'j', 'k', 'l' });
        digitToChar.put('6', new char[] { 'm', 'n', 'o' });
        digitToChar.put('7', new char[] { 'p', 'q', 'r', 's' });
        digitToChar.put('8', new char[] { 't', 'u', 'v' });
        digitToChar.put('9', new char[] { 'w', 'x', 'y', 'z' });

        findCombination(digits, digitToChar, new StringBuilder(), 0, result);

        return result;
    }

    public void findCombination(String digits, Map<Character, char[]> digitToChar, StringBuilder combo, int index,
            List<String> result) {
        if (index == digits.length()) {
            result.add(combo.toString());
            return;
        }

        for (char c : digitToChar.get(digits.charAt(index))) {
            // get the original length of the combo
            int len = combo.length();

            // add the letter
            combo.append(c);

            // move to the next digit
            findCombination(digits, digitToChar, combo, index + 1, result);

            // backtrack by resetting combo to original length
            combo.setLength(len);
        }
    }
}
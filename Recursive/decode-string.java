// Source: LeetCode
// https://leetcode.com/problems/decode-string/

class Solution {
    int index = 0;

    String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index))) {
                result.append(s.charAt(index));
                index++;
            } else {
                int k = 0;
                // build k while next character is a digit (for larger than single digits)
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + s.charAt(index) - '0';
                    index++;
                }

                // ignore the opening bracket '['
                index++;
                String decodedString = decodeString(s);
                // ignore the closing bracket ']'
                index++;
                // build k[decodedString] and append to the result
                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return new String(result);
    }
}
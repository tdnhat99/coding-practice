package org.tdnhat99;

import java.util.HashMap;
import java.util.Map;

/**
 * https://neetcode.io/problems/longest-substring-without-duplicates/question?list=neetcode150
 * Longest Substring Without Repeating Characters (Medium)
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingChar {

    /**
     * Longest Substring Without Repeating Characters (Medium)
     * Given a string s, find the length of the longest substring without repeating characters.
     * <p>
     * 012345678
     * abcdabcef
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // Map to store the last seen index of each character
        // Key: Character, Value: Index
        Map<Character, Integer> charIndexMap = new HashMap<>();

        int maxLength = 0;
        int left = 0;

        // 'right' pointer iterates through the string
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If duplicates found AND the duplicate is within the current window
            if (charIndexMap.containsKey(currentChar)) {
                // Move left pointer to the right of the previous instance of this character
                // We use Math.max to prevent 'left' from moving backward
                // (e.g., in "abba", when we see the second 'a', 'left' is already at index 2)
                left = Math.max(left, charIndexMap.get(currentChar) + 1);
            }

            // Update the latest index of the character
            charIndexMap.put(currentChar, right);

            // Calculate current window size and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

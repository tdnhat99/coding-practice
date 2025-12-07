package org.tdnhat99;

/**
 * https://leetcode.com/problems/valid-palindrome/description/
 * <p>
 * https://neetcode.io/problems/is-palindrome/question?list=neetcode150
 * Valid Palindrome (Easy)
 * Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
 * <p>
 * Note: Alphanumeric characters consist of letters (A-Z, a-z) and numbers (0-9).
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        // Use while(left < right) to stop when pointers meet
        while (left < right) {
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);

            // 1. Skip ALL consecutive non-alphanumeric chars from the left
            if (!Character.isLetterOrDigit(charLeft)) {
                left++;
            }
            // 2. Skip ALL consecutive non-alphanumeric chars from the right
            else if (!Character.isLetterOrDigit(charRight)) {
                right--;
            }
            // 3. Compare characters if both are valid
            else {
                if (Character.toLowerCase(charLeft) != Character.toLowerCase(charRight)) {
                    return false;
                }
                // Only move pointers inward after a successful comparison
                left++;
                right--;
            }
        }
        return true;
    }
}

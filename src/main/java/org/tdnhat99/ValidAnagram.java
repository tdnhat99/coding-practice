package org.tdnhat99;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Valid Anagram (Easy)
 * https://neetcode.io/problems/is-anagram/question?list=neetcode150
 */
public class ValidAnagram {

    /**
     * Brute force approach: sort both strings and compare
     * Time complexity: O(N log N)
     * Space complexity: O(N)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramBruteForce(String s, String t) {
        if (s.equals(t)){
            return true;
        }
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        if (sc.length != tc.length){
            return false;
        }
        Arrays.sort(tc);
        Arrays.sort(sc);
        return Arrays.equals(sc, tc);
    }

    /**
     * Using frequency counter array to count the frequency of each character
     * Time complexity: O(N)
     * Space complexity: O(1) since the size of the frequency counter is fixed (26 for lowercase letters)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramFrequencyCounter(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        // Convert char to int index: 'a' -> 0, 'b' -> 1, ..., 'z' -> 25
        // This works because char in Java is store as ASCII value, with a = 97, b = 98, ...
        // So 'a' - 'a' = 0, 'b' - 'a' = 1, ...
        int[] frequencyCounter = new int[26];
        for (int i = 0; i < s.length(); i++){
            frequencyCounter[s.charAt(i) - 'a']++;
            frequencyCounter[t.charAt(i) - 'a']--;
        }
        for (int count : frequencyCounter){
            if (count != 0){
                return false;
            }
        }
        return true;
    }


    /**
     * Using frequency counter map to count the frequency of each character
     * Time complexity: O(N)
     * Space complexity: O(1) since the size of the frequency counter is at most 26 (for lowercase letters)
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagramFrequencyCounterWithMap(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        // Convert char to int index: 'a' -> 0, 'b' -> 1, ..., 'z' -> 25
        // This works because char in Java is store as ASCII value, with a = 97, b = 98, ...
        // So 'a' - 'a' = 0, 'b' - 'a' = 1, ...
        Map<Character, Integer> frequencyCounter = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++){
            frequencyCounter.put(s.charAt(i), frequencyCounter.getOrDefault(s.charAt(i), 0) + 1);
            frequencyCounter.put(t.charAt(i), frequencyCounter.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int count : frequencyCounter.values()){
            if (count != 0){
                return false;
            }
        }
        return true;
    }
}

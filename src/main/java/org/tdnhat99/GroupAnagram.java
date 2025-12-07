package org.tdnhat99;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Group Anagram (Medium)
 <a href="https://neetcode.io/problems/anagram-groups/question?list=neetcode150">Link</a>
 */
public class GroupAnagram {

    /**
     * Using hash map to group anagrams together by frequency count as key
     * Time complexity: O(N * K), N is the number of strings, K is the maximum length of a string
     * Space complexity: O(N * K) for the output list
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        for (String str : strs){
            int[] frequencyCounter = new int[26];
            for (char c : str.toCharArray()){
                frequencyCounter[c - 'a']++;
            }
            String key = Arrays.toString(frequencyCounter);
            anagramGroups.putIfAbsent(key, new java.util.ArrayList<>());
            anagramGroups.get(key).add(str);
        }

        return anagramGroups.values().stream().toList();
    }
}

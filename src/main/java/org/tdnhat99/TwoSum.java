package org.tdnhat99;

import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum (Easy)
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 */
public class TwoSum {

    /**
     * Using a map to store value -> index mapping. For each element, check if target - x exists in the map.
     * Time complexity: O(N)
     * Space complexity: O(N)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>(nums.length);
        int[] result = new int[2];
        for (int i = 0; i <= nums.length - 1; i++){
            valueIndexMap.put(nums[i], i);
            int potentialMatch = target - nums[i];
            if (valueIndexMap.containsKey(potentialMatch)){
                result[0] = i;
                result[1] = valueIndexMap.get(potentialMatch);
            }
        }

        return result;
    }
}

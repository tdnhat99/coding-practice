package org.tdnhat99;

import java.util.Set;

/**
 * Given an array of integers arr[],
 * The task is to find the index of first repeating element in it
 * i.e. the element that occurs more than once and whose index of the first occurrence is the smallest.
 */
public class FirstRepeatingInArray {

    public int firstRepeatingElement(int[] arr, int n) {
        // Store a set of element, then iterate through the array to find the first element that already exists in the set
        Set<Integer> seen = new java.util.HashSet<>();
        for (int i = 0; i <= n - 1; i++) {
            boolean notRepeating = seen.add(arr[i]);
            if (!notRepeating) {
                return i;
            }
        }
        return -1;
    }
}

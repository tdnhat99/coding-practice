package org.tdnhat99;

/**
 * https://www.geeksforgeeks.org/dsa/find-second-largest-element-array/
 * Given an array of positive integers arr[] of size n, the task is to find second-largest distinct element in the array.
 * <p>
 * Note: If the second largest element does not exist, return -1.
 */
public class SecondLargestInArray {

    /**
     * O(n) solution using single traversal.
     *
     * @param arr
     * @return
     */
    public int getSecondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i <= arr.length - 1; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }
}

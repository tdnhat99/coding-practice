package org.tdnhat99;

/**
 * Kth Largest Element in an Array (Medium)
 * https://neetcode.io/problems/kth-largest-element-in-an-array/question?list=neetcode150
 *
 * Given an unsorted array of integers nums and an integer k, return the kth largest element in the array.
 *
 * By kth largest element, we mean the kth largest element in the sorted order, not the kth distinct element.
 *
 * Follow-up: Can you solve it without sorting?
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,5,4], k = 2
 *
 * Output: 4
 * Example 2:
 *
 * Input: nums = [2,3,1,1,5,5,4], k = 3
 *
 * Output: 4
 * Constraints:
 *
 * 1 <= k <= nums.length <= 10000
 * -1000 <= nums[i] <= 1000
 */
public class KthLargestInArray {

    /**
     * Naive approach: sort the array and return the kth largest element
     * Time complexity: O(N log N), Space complexity: O(N)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestNaive(int[] nums, int k) {
        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);
        return sorted[sorted.length - k];
    }

    // Using Min-Heap of size k to keep track of the k largest elements.
    // Time complexity: O(N log k), Space complexity: O(k)
    public int findKthLargestMinHeap(int[] nums, int k) {
        java.util.PriorityQueue<Integer> minHeap = new java.util.PriorityQueue<>(k);
        for (int num : nums){
            minHeap.add(num);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    /**
     * Using Quickselect algorithm. Average time complexity: O(N), Worst-case time complexity: O(N^2)
     * Space complexity: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestQuickSelect(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        int targetIndex = nums.length - k;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        throw new IllegalArgumentException("k is out of bounds");
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

package org.example.dsa.twopointer;

public class MaximumSumSubarrayKElements {
    public long maximumSubarraySum(int[] nums, int k) {
        int sum = 0;
//        sum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        for (int i = 1; i < nums.length-k; i++) {
            sum = Math.max(sum, sum - nums[i-1] + nums[i+k-1]);
        }
        return sum;
    }
}

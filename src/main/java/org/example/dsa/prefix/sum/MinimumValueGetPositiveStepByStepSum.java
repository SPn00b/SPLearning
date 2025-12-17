package org.example.dsa.prefix.sum;

public class MinimumValueGetPositiveStepByStepSum {
    public int minStartValue(int[] nums) {
        int min = 0;
        boolean allPositive = true;
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < prefixSum.length; i++) {
            if (i == 0) {
                prefixSum[i] = 0 + nums[i];
            }
            else {
                prefixSum[i] = prefixSum[i-1] + nums[i];
            }
            if (prefixSum[i] < 0 && prefixSum[i] < min) {
                min = prefixSum[i];
                allPositive = false;
            }
        }
        if (allPositive) {
            return 1;
        }
        else {
            return Math.abs(min)+1;
        }
    }
}

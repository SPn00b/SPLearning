package org.example.dsa.twopointer;

import java.util.Arrays;

public class MaximumSumSubarraySumLessThanOrEqualToGivenSum {
    public static int maximumSumSubarray(int[] nums, int k) {

        int i = 0;
        int j = 0;
        int sum = 0;
        int n = nums.length;

        while (i <= j && j < n) {
            int currentSum = sum;
            if (sum <= k) {
                j++;
                sum = sum + nums[j];
            }
            else {
                sum = sum - nums[i];
                i++;
            }

            //incomplete

        }

        return 0;
    }

    // can be done easily with sliding windows and prefix sum

    public static int maximumSumSubarrayPrefixSum(int[] nums, int k) {

        int sum = 0;
        int sumArr[] = new int[nums.length+1];
        Arrays.fill(sumArr, 0);

        int count = 1;
        sumArr[0] = 0;
        for (int i: nums) {
            sumArr[count] = 0;
            if (count == 0) {
                sumArr[count] = nums[count-1];
                count++;
            }
            else {
                sumArr[count] = sumArr[count - 1] + nums[count-1];
                count++;
            }
        }

        sum = 0;

        int i = 0;
        int j = 0;
        int n = sumArr.length;
        int currentSum = 0;

        while (i <= j && j < n) {

            if (sum <= k) {
                if (i == 0 && j == 0) {
                    currentSum = sumArr[i];
                }
                else {
                    currentSum = sumArr[j] - sumArr[i];
                }
                if (currentSum <= k) {
                    sum = Math.max(sum, currentSum);
                }
                j++;
            }
            else {
                if (i == 0 && j == 0) {
                    currentSum = sumArr[i];
                }
                else {
                    currentSum = sumArr[j] - sumArr[i];
                }
                i++;
            }

        }
        return sum;
    }

}

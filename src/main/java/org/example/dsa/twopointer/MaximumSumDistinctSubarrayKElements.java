package org.example.dsa.twopointer;

import java.util.ArrayList;
import java.util.HashSet;

public class MaximumSumDistinctSubarrayKElements {
    public long maximumSubarraySum(int[] nums, int k) {
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]) {
                integers.add(nums[i]);
            }
        }

        int[] numbers = new int[integers.size()];

        for (int i = 0; i < integers.size(); i++) {
            numbers[i] =  integers.get(i);
        }

        int sum = 0;
        for (int i = 0; i < integers.size(); i++) {
            sum = sum + integers.get(i);
        }

        if (integers.size() < k) {
            return 0;
        }

        // if (integers.size() <= k) {
        //     return sum;
        // }

        sum = 0;
//        sum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < k; i++) {
            sum = sum + numbers[i];
        }

        if (k > 1) {
            for (int i = 1; i < numbers.length-k+1; i++) {
                sum = Math.max(sum, sum - numbers[i-1] + numbers[i+k-1]);
            }
        }
        else {
            for (int i = 0; i < numbers.length; i++) {
                sum = Math.max(sum, numbers[i]);
            }
        }


        return sum;
    }
}

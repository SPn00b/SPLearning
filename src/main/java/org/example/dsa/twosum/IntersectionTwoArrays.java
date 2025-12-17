package org.example.dsa.twosum;

import java.util.HashSet;

public class IntersectionTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return intersectionSwapedInput(nums2, nums1);
        }
        else {
            return intersectionSwapedInput(nums1, nums2);
        }
    }

    public int[] intersectionSwapedInput(int[] nums1, int[] nums2) {
        HashSet<Integer> sets = new HashSet<>();
        HashSet<Integer> sets1 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            sets.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (sets.contains(nums2[i])) {
                sets1.add(nums2[i]);
            }
        }

        int[] result = new int[sets1.size()];

        int count = 0;
        for (Integer val : sets1) {
            result[count++] = val;
        }

        return result;

    }

}

package org.example.dsa.twopointer;

import java.util.*;

public class IntersectionTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            hashMap1.put(nums1[i], hashMap1.getOrDefault(nums1[i], 0)+1);
        }

        for (int i = 0; i < nums2.length; i++) {
            hashMap2.put(nums2[i], hashMap2.getOrDefault(nums2[i], 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : hashMap1.entrySet()) {
            if (hashMap2.containsKey(entry.getKey())) {
                if (hashMap2.get(entry.getKey()) == (entry.getValue())) {
                    integerHashMap.put(entry.getKey(), entry.getValue());
                }
                else if (hashMap2.get(entry.getKey()) < (entry.getValue())) {
                    integerHashMap.put(entry.getKey(), hashMap2.get(entry.getKey()));
                }
                else if (hashMap2.containsKey(entry.getKey()) && hashMap2.get(entry.getKey()) > (entry.getValue())) {
                    integerHashMap.put(entry.getKey(), entry.getValue());
                }
            }
        }

        int count = 0;

        int size = 0;
        for (Map.Entry<Integer, Integer> integer : integerHashMap.entrySet()) {
            for (int i = 0; i < integer.getValue(); i++) {
                size = size + 1;
            }
        }

        int[] intersection = new int[size];
        for (Map.Entry<Integer, Integer> integer : integerHashMap.entrySet()) {
            for (int i = 0; i < integer.getValue(); i++) {
                intersection[count++] = integer.getKey();
            }
        }

        return intersection;
    }
}

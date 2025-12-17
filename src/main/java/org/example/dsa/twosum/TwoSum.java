package org.example.dsa.twosum;

import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i]) && i != hashMap.get(target - nums[i])) {
                res[0] = i;
                res[1] = hashMap.get(target - nums[i]);
                break;
            }
        }
        return res;
    }
}

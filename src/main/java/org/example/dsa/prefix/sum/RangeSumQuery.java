package org.example.dsa.prefix.sum;

public class RangeSumQuery {
    int[] preSumArray;

    public RangeSumQuery(int[] nums) {
        preSumArray = new int[nums.length+1];
        preSumArray[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSumArray[i+1] = preSumArray[i] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        return (preSumArray[right+1] - preSumArray[left]);
    }
}

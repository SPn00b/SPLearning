package org.example.dsa.twosum;

public class RemoveDuplicatesSortedArray {

    public int removeDuplicates(int[] nums) {
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] != nums[i]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}

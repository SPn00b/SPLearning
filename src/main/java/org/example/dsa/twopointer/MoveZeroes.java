package org.example.dsa.twopointer;

import java.util.logging.Logger;

public class MoveZeroes {
    Logger  logger = Logger.getLogger(MoveZeroes.class.getName());
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        while (i < n && j < n) {
            if (j < i) {
                j++;
            } else if (nums[j] != 0 && nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            } else if (nums[i] != 0) {
                i++;
            } else {
                j++;
            }
        }
//        for (int k = 0; k < nums.length; k++) {
//            logger.info("moveZeroes : "+ nums[k]);
//        }
        logger.info("move zeroes : "+ nums.toString());
    }
}

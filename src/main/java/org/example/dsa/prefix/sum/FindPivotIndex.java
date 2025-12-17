package org.example.dsa.prefix.sum;

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {

        int[] preSumArray = new int[nums.length+1];
        preSumArray[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            preSumArray[i+1] = preSumArray[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (isPreSumPivotValid(preSumArray, i)) {
                return i;
            }
        }
        return -1;
    }

    boolean isPreSumPivotValid(int[] preSumArray, int pivot) {
        if (pivot == 0) {
            if (preSumArray[pivot] == preSumArray[preSumArray.length - 1] - preSumArray[pivot+1]) {
                return true;
            }
        }
        else if (pivot == preSumArray.length - 1) {
            return preSumArray[pivot] == 0;
        }
        else {
            if (preSumArray[pivot] == preSumArray[preSumArray.length - 1] - preSumArray[pivot+1]) {
                return true;
            }
        }
        return false;
    }
}

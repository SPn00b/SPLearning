package org.example.dsa.twosum;

public class SortColors {
    public void sortColors(int[] nums) {
        int czero = 0;
        int cone = 0;
        int ctwo = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                czero++;
            }
            else if (nums[i] == 1) {
                cone++;
            }
            else if (nums[i] == 2) {
                ctwo++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (czero > 0) {
                nums[i] = 0;
                czero--;
            }
            else if (cone > 0) {
                nums[i] = 1;
                cone--;
            }
            else if (ctwo > 0) {
                nums[i] = 2;
                ctwo--;
            }
        }
    }
}

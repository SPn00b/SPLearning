package org.example.dsa.twosum;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums3 = new int[nums1.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < (nums1.length-nums2.length) && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            }
            else {
                nums3[k++] = nums2[j++];
            }
        }

        for (int l = i; l < (nums1.length-nums2.length); l++) {
            nums3[k++] = nums1[l];
        }

        for (int o = j; o < nums2.length; o++) {
            nums3[k++] = nums2[o];
        }

        nums1 = nums3;

        for (int p = 0; p < nums3.length; p++) {
            System.out.print(nums3[p] + " ");
        }

        System.out.println();

        for (int p = 0; p < nums3.length; p++) {
            System.out.print(nums1[p] + " ");
        }

        System.out.println();

    }
}

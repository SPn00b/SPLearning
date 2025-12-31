package org.example.dsa.twopointer;

public class MedianTwoSortedArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int nums3[] = new int[nums1.length+nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                nums3[k++] = nums1[i++];
            }
            else {
                nums3[k++] = nums2[j++];
            }
        }

        for (int l = i; l < nums1.length; l++) {
            nums3[k++] = nums1[l];
        }

        for (int o = j; o < nums2.length; o++) {
            nums3[k++] = nums2[o];
        }

        if (nums3.length % 2 == 0) {
            return (nums3[nums3.length/2]+nums3[(nums3.length/2)-1])/2.0;
        }
        else {
            return nums3[nums3.length/2];
        }
    }
}

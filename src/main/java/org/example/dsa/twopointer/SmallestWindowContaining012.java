package org.example.dsa.twopointer;

public class SmallestWindowContaining012 {
    public static int smallestWindow(String str) {
        int i = 0;
        int j = 0;
        int n = str.length();
        int minLength = Integer.MAX_VALUE;
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        if (str.charAt(0) == 48) {
            count0++;
        }
        else if (str.charAt(0) == 49) {
            count1++;
        }
        else if (str.charAt(0) == 50) {
            count2++;
        }

        while (i <= j && j < n) {

            if (count0 >= 1 && count1 >= 1 && count2 >= 1) {
                minLength = Math.min(minLength, j - i + 1);
                i++;
                if (i < j) {
                    if (str.charAt(i - 1) == 48 && count0 != 0) {
                        count0--;
                    } else if (str.charAt(i - 1) == 49 && count0 != 0) {
                        count1--;
                    } else if (str.charAt(i - 1) == 50 && count0 != 0) {
                        count2--;
                    }
                }
            }
            else {
                j++;
                if (j < n) {
                    if (str.charAt(j) == 48) {
                        count0++;
                    } else if (str.charAt(j) == 49) {
                        count1++;
                    } else if (str.charAt(j) == 50) {
                        count2++;
                    }
                }
            }
        }
        return minLength;
    }
}

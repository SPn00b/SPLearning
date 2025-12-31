package org.example.dsa.twopointer;

import java.util.Arrays;

public class CheckPermutationPatternSubstring {

    static final int MAX_CHAR = 26;

    static boolean checkValid(int[] frq) {
        for (int i = 0; i < MAX_CHAR; i++) {
            if (frq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean permutationPattern(String str, String pattern) {

        int n = str.length();
        int m = pattern.length();

        int[] frq = new int[MAX_CHAR];

        Arrays.fill(frq, 0);

        for (int i = 0; i < m; i++) {
            frq[str.charAt(i) - 'a']++;
            frq[pattern.charAt(i) - 'a']--;
        }

        if (checkValid(frq)) {
            return true;
        }

        for (int i = m; i < n; i++) {
            frq[str.charAt(i) - 'a']++;
            frq[str.charAt(i - m) - 'a']--;

            if (checkValid(frq)) {
                return true;
            }
        }

        return false;

    }

}

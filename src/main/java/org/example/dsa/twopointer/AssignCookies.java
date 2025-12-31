package org.example.dsa.twopointer;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0;
        int j = 0;
        int k = g.length;
        int l = s.length;

        Arrays.sort(s);
        Arrays.sort(g);

        while (i < k && j < l) {
            if (g[i] <= s[j]) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i;
    }
}

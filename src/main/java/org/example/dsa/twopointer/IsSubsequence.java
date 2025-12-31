package org.example.dsa.twopointer;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;
        int m = s.length()-1;
        int n = t.length()-1;
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        while (i <= m && j <= n) {
            boolean flag = false;
            if (sChar[i] != tChar[j]) {
                j++;
            }
            else {
                j++;
                i++;
                flag = true;
            }
            if (sChar[m] != tChar[n]) {
                n--;
            }
            else {
                if (!flag) {
                    m--;
                    n--;
                }
            }
        }
        if (i > m) {
            return true;
        }
        else {
            return false;
        }
    }
}

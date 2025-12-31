package org.example.dsa.twopointer;

public class PalindromeAlphaNumricConversion {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder s1 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                s1.append(s.charAt(i));
            }
        }
        int i = 0;
        int j = s1.length()-1;
        while (i < j) {
            if (s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }
}

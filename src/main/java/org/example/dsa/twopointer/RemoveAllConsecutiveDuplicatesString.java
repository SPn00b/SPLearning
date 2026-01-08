package org.example.dsa.twopointer;

public class RemoveAllConsecutiveDuplicatesString {
    public static String removeDuplicates(String str) {

        int i = 0;
        int j = 0;
        int n = str.length();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str.charAt(0));

        while (i <= j && j < n ) {
            if (str.charAt(i) != str.charAt(j)) {
                stringBuilder.append(str.charAt(j));
                i = j;
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
        }

        return stringBuilder.toString();
    }
}

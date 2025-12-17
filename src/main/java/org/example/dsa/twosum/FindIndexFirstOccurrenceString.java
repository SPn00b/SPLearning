package org.example.dsa.twosum;

public class FindIndexFirstOccurrenceString {
    public int strStr(String haystack, String needle) {
        char[] source = haystack.toCharArray();
        char[] target = needle.toCharArray();
        if (source.length < target.length) {
            return -1;
        }
        for (int i = 0; i < source.length; i++) {
            if (source[i] == target[0]) {
                if (match(source, target, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    boolean match(char[] source, char[] target, int index) {
        if (index+target.length > source.length) {
            return false;
        }
        int count = 0;
        boolean flag = true;
        for (int i = index; i < index+target.length; i++) {
            if (source[i] == target[count]) {
                count++;
            }
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

package org.example.dsa.twopointer;

public class ReverseVowelString {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        int k = 0;
        char[] ch = s.toCharArray();
        while (i < j) {
            if ((s.charAt(i) == 'a' || s.charAt(i) == 'A' || s.charAt(i) == 'e' || s.charAt(i) == 'E' || s.charAt(i) == 'i' || s.charAt(i) == 'I' || s.charAt(i) == 'o' || s.charAt(i) == 'O' || s.charAt(i) == 'u' || s.charAt(i) == 'U') && (s.charAt(j) == 'a' || s.charAt(j) == 'A' || s.charAt(j) == 'e' || s.charAt(j) == 'E' || s.charAt(j) == 'i' || s.charAt(j) == 'I' || s.charAt(j) == 'o' || s.charAt(j) == 'O' || s.charAt(j) == 'u' || s.charAt(j) == 'U')) {
                char temp = ch[i];
                ch[i++] = ch[j];
                ch[j--] = temp;
            }
            else {
                if (s.charAt(i) != 'a' && s.charAt(i) != 'A' && s.charAt(i) != 'e' && s.charAt(i) != 'E' && s.charAt(i) != 'i' && s.charAt(i) != 'I' && s.charAt(i) != 'o' && s.charAt(i) != 'O' && s.charAt(i) != 'u' && s.charAt(i) != 'U') {
                    i++;
                }
                if (s.charAt(j) != 'a' && s.charAt(j) != 'A' && s.charAt(j) != 'e' && s.charAt(j) != 'E' && s.charAt(j) != 'i' && s.charAt(j) != 'I' && s.charAt(j) != 'o' && s.charAt(j) != 'O' && s.charAt(j) != 'u' && s.charAt(j) != 'U') {
                    j--;
                }
            }
        }
        return s = new String(ch);
    }
}

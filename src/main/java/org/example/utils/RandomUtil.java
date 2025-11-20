package org.example.utils;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomUtil {

    private static final String VALID_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public static String randomString(int minLength, int maxLength) {
        int targetLength = minLength + SECURE_RANDOM.nextInt(maxLength - minLength +1);
        StringBuilder stringBuilder = new StringBuilder(targetLength);

        for (int i = 0; i < targetLength; i++) {
            int index = SECURE_RANDOM.nextInt(VALID_CHARS.length());
            stringBuilder.append(VALID_CHARS.charAt(index));
        }
        return stringBuilder.toString();
    }

    public static LinkedList<String> generateParallelRandomStrings(int count, int minLength, int maxLength) {
        ForkJoinPool customPool = new ForkJoinPool(8);
        LinkedList<String> randomStrings = customPool.submit(() -> IntStream.range(0, count).parallel().mapToObj(i -> randomString(minLength, maxLength)).collect(Collectors.toCollection(LinkedList::new))).join();
        return randomStrings;
    }

}

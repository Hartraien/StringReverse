package ru.hartraien;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String result = reverseString(str);
        //Time for 1000
        long timeFor1000 = measureTime(Main::reverseString, str, 1000);
        //For 10_000
        long timeFor10000 = measureTime(Main::reverseString, str, 10_000);
        //For 100_000
        long timeFor100000 = measureTime(Main::reverseString, str, 100_000);
        System.out.println(result);
        print(timeFor1000);
        print(timeFor10000);
        print(timeFor100000);
    }

    private static void print(long time) {
        System.out.println(time);
    }

    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return String.valueOf(chars);
    }

    public static long measureTime(UnaryOperator<String> operator, String arg, int count) {
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++) {
            long startTime1 = System.nanoTime();
            operator.apply(arg);
            long endtime1 = System.nanoTime();
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}

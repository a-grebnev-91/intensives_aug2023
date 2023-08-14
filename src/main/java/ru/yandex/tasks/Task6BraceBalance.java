package ru.yandex.tasks;

import java.util.ArrayDeque;

public class Task6BraceBalance {
    public static boolean checkBalance(String sequence) {
        /*
         * sequence - последовательность скобок []{}() длины до 10^5
         * Выход: true/false, является ли строка ПСП
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sequence.length(); i++) {
            char currChar = sequence.charAt(i);
            if (currChar == '(' || currChar == '[' || currChar == '{') {
                stack.addLast(currChar);
            } else {
                if (stack.isEmpty()) return false;
                char lastInStack = stack.peekLast();
                if (lastInStack == ')' || lastInStack == ']' || lastInStack == '}') {
                    stack.addLast(currChar);
                } else {
                    if (currChar == ')' && lastInStack != '(') return false;
                    if (currChar == ']' && lastInStack != '[') return false;
                    if (currChar == '}' && lastInStack != '{') return false;
                    stack.pollLast();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void selfCheck() {
        String test1 = "[({})]{[]}";
        String test2 = "{({})}{";

        assert checkBalance(test1);
        assert !checkBalance(test2);
    }
}

package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        /*
         * numbers: массив целых чисел, -10^5 <= numbers[i] <= 10^5, длина массива до 10^5
         * Выход: отсортированный (сортировкой вставками!) numbers
         */
        // (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ WRITE CODE HERE (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧
        if (numbers == null || numbers.size() < 2) return numbers;
        int sortedIndex = 0;
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = 0; j <= sortedIndex; j++) {
                if (numbers.get(j) > numbers.get(i)) {
                    Integer removed = numbers.remove(i);
                    numbers.add(j, removed);
                    break;
                }
            }
        }
        System.out.println(numbers);
        return numbers;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}

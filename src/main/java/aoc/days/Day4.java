package aoc.days;

import aoc.DayInterface;

public class Day4 implements DayInterface {

    @Override
    public void part1() {
        int number = 264793;
        int max = 803935;

        int res = 0;
        while (number <= max) {

            int[] destructed = deconstruct(number);

            if (sameAdj(destructed) && neverDecrease(destructed)) {
                res++;
            }

            number++;
        }

        System.out.println("Part 1 : " + res);
    }

    @Override
    public void part2() {
        int number = 264793;
        int max = 803935;

        int res = 0;
        while (number <= max) {

            int[] destructed = deconstruct(number);

            if (sameAdjNoGroup(destructed) && neverDecrease(destructed)) {
                res++;
            }

            number++;
        }

        System.out.println("Part 2 : " + res);
    }

    private int[] deconstruct(int number) {
        int[] res = new int[6];
        for (int i = 0; i < 6; i++) {
            res[5 - i] = number % 10;
            number = number / 10;
        }
        return res;
    }

    private boolean sameAdj(int[] array) {
        for (int i = 1; i < 6; i++) {
            if (array[i - 1] == array[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean sameAdjNoGroup(int[] array) {
        for (int i = 1; i < 6; i++) {
            if (array[i - 1] == array[i]) {
                if (i <= 1 || array[i - 2] != array[i]) {
                    if (i >= 5 || array[i + 1] != array[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean neverDecrease(int[] array) {
        for (int i = 1; i < 6; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }
}

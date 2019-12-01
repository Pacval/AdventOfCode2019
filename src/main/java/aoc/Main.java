package aoc;

import aoc.days.Day1;

public class Main {

    public static void main(String[] args) {

        try {
            DayInterface day = new Day1();
            day.part1();
            day.part2();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

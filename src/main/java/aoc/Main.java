package aoc;

import aoc.days.Day6;

public class Main {

    public static void main(String[] args) {

        try {
            DayInterface day = new Day6();
            day.part1();
            day.part2();
        } catch (Exception e) {
            System.out.println("ERROR. Need debug.");
        }
    }
}

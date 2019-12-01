package aoc.days;

import aoc.DayInterface;
import aoc.ExoEntryUtils;

import java.util.Arrays;

public class Day1 implements DayInterface {

    @Override
    public void part1() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(1);

        int res = 0;

        for(String line : entries) {
            res += (Integer.parseInt(line) / 3) - 2;
        }

        System.out.println(res);
    }

    @Override
    public void part2() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(1);

        int res = 0;

        for(String line : entries) {
            int addedFullMass = (Integer.parseInt(line) / 3) - 2;

            while (addedFullMass > 0) {
                res += addedFullMass;

                addedFullMass = (addedFullMass / 3) - 2;
            }
        }

        System.out.println(res);

    }
}

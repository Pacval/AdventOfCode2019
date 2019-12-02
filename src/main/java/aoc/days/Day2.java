package aoc.days;

import aoc.DayInterface;
import aoc.ExoEntryUtils;

import java.util.ArrayList;
import java.util.List;

public class Day2 implements DayInterface {

    @Override
    public void part1() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(2);

        List<Integer> inputs = new ArrayList<>();
        for (String input : entries[0].split(",")) {
            inputs.add(Integer.valueOf(input));
        }

        inputs.set(1, 12);
        inputs.set(2, 2);

        System.out.println("part 1 : " + runProgram(inputs));
    }

    @Override
    public void part2() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(2);

        List<Integer> inputs = new ArrayList<>();
        for (String input : entries[0].split(",")) {
            inputs.add(Integer.valueOf(input));
        }

        int noun = 0;
        int verb = 0;

        inputs.set(1, noun);
        inputs.set(2, verb);

        while (runProgram(new ArrayList<>(inputs)) != 19690720) {
            noun++;
            if (noun > 99) {
                noun = 0;
                verb++;
            }

            inputs.set(1, noun);
            inputs.set(2, verb);
        }

        System.out.println("part 2 : " + (100 * noun + verb));

    }

    private int runProgram(List<Integer> inputs) {
        int count = 0;

        while (inputs.get(count) != 99 && inputs.stream().anyMatch(i -> i <= 99)) {
            switch (inputs.get(count)) {
                case 1:
                    inputs.set(inputs.get(count + 3), inputs.get(inputs.get(count + 1)) + inputs.get(inputs.get(count + 2)));
                    break;
                case 2:
                    inputs.set(inputs.get(count + 3), inputs.get(inputs.get(count + 1)) * inputs.get(inputs.get(count + 2)));
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            count = count + 4;
        }

        return inputs.get(0);
    }
}

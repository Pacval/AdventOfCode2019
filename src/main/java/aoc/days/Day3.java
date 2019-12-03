package aoc.days;

import aoc.DayInterface;
import aoc.ExoEntryUtils;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

// Stockage des positions : x.y
public class Day3 implements DayInterface {

    @Override
    public void part1() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(3);

        Set<String> path = new HashSet<>();

        int x = 0;
        int y = 0;

        path.add(x + "." + y);

        for (String move : entries[0].split(",")) {
            switch (move.charAt(0)) {
                case 'U':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y--;
                        path.add(x + "." + y);
                    }
                    break;
                case 'D':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y++;
                        path.add(x + "." + y);
                    }
                    break;
                case 'R':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x++;
                        path.add(x + "." + y);
                    }
                    break;
                case 'L':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x--;
                        path.add(x + "." + y);
                    }
                    break;
            }
        }

        Set<String> cross = new HashSet<>();
        x = 0;
        y = 0;

        for (String move : entries[1].split(",")) {
            switch (move.charAt(0)) {
                case 'U':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y--;
                        if (path.contains(x + "." + y)) {
                            cross.add(x + "." + y);
                        }
                    }
                    break;
                case 'D':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y++;
                        if (path.contains(x + "." + y)) {
                            cross.add(x + "." + y);
                        }
                    }
                    break;
                case 'R':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x++;
                        if (path.contains(x + "." + y)) {
                            cross.add(x + "." + y);
                        }
                    }
                    break;
                case 'L':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x--;
                        if (path.contains(x + "." + y)) {
                            cross.add(x + "." + y);
                        }
                    }
                    break;
            }
        }

        int res = cross.stream().mapToInt(item -> Math.abs(Integer.parseInt(item.split("\\.")[0])) + Math.abs(Integer.parseInt(item.split("\\.")[1]))).min().getAsInt();

        System.out.println("Part 1 : " + res);

    }

    @Override
    public void part2() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(3);

        Map<String, Integer> path = new HashMap<>();

        int x = 0;
        int y = 0;
        int steps = 0;

        path.put(x + "." + y, steps);

        for (String move : entries[0].split(",")) {
            switch (move.charAt(0)) {
                case 'U':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y--;
                        steps++;
                        path.put(x + "." + y, steps);
                    }
                    break;
                case 'D':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y++;
                        steps++;
                        path.put(x + "." + y, steps);
                    }
                    break;
                case 'R':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x++;
                        steps++;
                        path.put(x + "." + y, steps);
                    }
                    break;
                case 'L':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x--;
                        steps++;
                        path.put(x + "." + y, steps);
                    }
                    break;
            }
        }

        Map<String, Integer> cross = new HashMap<>();
        x = 0;
        y = 0;
        steps = 0;

        for (String move : entries[1].split(",")) {
            switch (move.charAt(0)) {
                case 'U':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y--;
                        steps++;
                        if (path.containsKey(x + "." + y) && !cross.containsKey(x + "." + y)) {
                            cross.put(x + "." + y, path.get(x + "." + y) + steps);
                        }
                    }
                    break;
                case 'D':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        y++;
                        steps++;
                        if (path.containsKey(x + "." + y) && !cross.containsKey(x + "." + y)) {
                            cross.put(x + "." + y, path.get(x + "." + y) + steps);
                        }
                    }
                    break;
                case 'R':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x++;
                        steps++;
                        if (path.containsKey(x + "." + y) && !cross.containsKey(x + "." + y)) {
                            cross.put(x + "." + y, path.get(x + "." + y) + steps);
                        }
                    }
                    break;
                case 'L':
                    for (int i = 0; i < Integer.parseInt(move.substring(1)); i++) {
                        x--;
                        steps++;
                        if (path.containsKey(x + "." + y) && !cross.containsKey(x + "." + y)) {
                            cross.put(x + "." + y, path.get(x + "." + y) + steps);
                        }
                    }
                    break;
            }
        }

        int res = cross.values().stream().mapToInt(i -> i).min().getAsInt();

        System.out.println("Part 2 : " + res);
    }
}

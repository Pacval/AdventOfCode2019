package aoc.days;

import aoc.DayInterface;
import aoc.ExoEntryUtils;

import java.util.*;

public class Day6 implements DayInterface {

    @Override
    public void part1() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(6);

        Map<String, String> parents = new HashMap<>();
        Set<String> allNames = new HashSet<>();

        for (String entry : entries) {
            String p1 = entry.split("\\)")[0];
            String p2 = entry.split("\\)")[1];

            allNames.add(p1);
            allNames.add(p2);

            parents.put(p2, p1);
        }

        int sum = 0;
        for (String p : allNames) {
            int sumP = 0;
            String tempP = p;

            while (parents.containsKey(tempP)) {
                tempP = parents.get(tempP);
                sumP++;
            }

            sum += sumP;
        }

        System.out.println("Part 1 : " + sum);
    }

    @Override
    public void part2() throws Exception {
        String[] entries = ExoEntryUtils.getEntries(6);

        Map<String, String> parents = new HashMap<>();

        for (String entry : entries) {
            String p1 = entry.split("\\)")[0];
            String p2 = entry.split("\\)")[1];

            parents.put(p2, p1);
        }

        List<String> youToCom = new ArrayList<>();
        String tempP = "YOU";
        while (parents.containsKey(tempP)) {
            tempP = parents.get(tempP);
            youToCom.add(tempP);
        }

        List<String> sanToCom = new ArrayList<>();
        tempP = "SAN";
        while (parents.containsKey(tempP)) {
            tempP = parents.get(tempP);
            sanToCom.add(tempP);
        }

        // on récupère le nombre de planètes qui ne sont pas en communs pour remonter jusqu'à COM
        // Le départ / arrivée non comptés (1 cran plus haut) + la planète en commun s'annulent
        long res = youToCom.stream().filter(item -> !sanToCom.contains(item)).count() + sanToCom.stream().filter(item -> !youToCom.contains(item)).count();
        System.out.println("Part 2 : " + res);
    }
}

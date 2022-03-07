package org.crtdev.aoc.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Day1 {

    private List<Integer> input;

    public void read(String fileName) throws IOException {
        this.input = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(String.format("%s.txt", fileName));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(Integer.parseInt(line));
            }
        }
    }

    public Integer solve() {
        int totalFuel = 0;
        for (var v : this.input) {
            totalFuel += Math.floorDiv(v, 3) - 2;
        }

        return totalFuel;
    }

    public Integer solve2() {
        int totalFuel = 0;
        for (var v : this.input) {
            int fuel = Math.floorDiv(v, 3) - 2;
            while (fuel > 0) {
                totalFuel += fuel;
                fuel = Math.floorDiv(fuel, 3) - 2;
            }
        }

        return totalFuel;
    }
}
package org.crtdev.aoc.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day2 {

    private List<Integer> input;

    private String inputFile;

    public void read(String fileName) throws IOException {
        this.inputFile = fileName;
        this.input = new ArrayList<>();
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(String.format("%s.txt", fileName));
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] elements = line.split(",");
                for (String s : elements) {
                    input.add(Integer.parseInt(s));
                }
            }
        }
    }

    public int solve(int noun, int verb) {
        this.input.set(1, noun);
        this.input.set(2, verb);

        for (int i=0; i<this.input.size(); i += 4) {
            int operator = this.input.get(i);
            if (operator == 99) {
                break;
            }

            Integer newValue = null;
            int p1 = this.input.get(i + 1);
            int p2 = this.input.get(i + 2);
            int p3 = this.input.get(i + 3);

            if (operator == 1) {
                newValue = this.input.get(p1) + this.input.get(p2);
            } else if (operator == 2) {
                newValue = this.input.get(p1) * this.input.get(p2);
            } else {
                throw new RuntimeException("Unsupported operation");
            }

            this.input.set(p3, newValue);
        }

        return this.input.get(0);
    }

    public int solve2(int target) throws IOException {
        int limit = 99;
        int noun = 0;
        int verb = 0;

        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int result = this.solve(i,j);
                //System.out.println(String.format("%d : %d %d", result, i, j));
                if (result == target) {
                    noun = i;
                    verb = j;
                    break;
                }
                this.input = new ArrayList<>();
                this.read(this.inputFile);
            }

            if (noun != 0) {
                break;
            }
        }

        return noun * 100 + verb;
    }
}
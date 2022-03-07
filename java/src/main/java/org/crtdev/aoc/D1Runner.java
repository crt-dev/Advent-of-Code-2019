package org.crtdev.aoc;

import org.crtdev.aoc.solution.Day1;

public class D1Runner {
    private static String EXERCISE = "d01";
    private static String EXAMPLE = EXERCISE + "ex";

    public static void main(String[] args) throws Exception {
        solve(EXERCISE, 1); //3266053
        solve(EXERCISE, 2); //4896221
    }

    public static void solve(String input, int part) throws Exception {
        var solution = new Day1();
        solution.read(input);
        var p1 = part == 1 ? solution.solve() : solution.solve2();
        System.out.println(String.format("Part %d%s: %s", part, input.equals(EXAMPLE) ? "ex" : "", p1));
    }
}

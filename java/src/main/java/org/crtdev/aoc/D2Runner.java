package org.crtdev.aoc;

import org.crtdev.aoc.solution.Day2;

public class D2Runner {
    private static String EXERCISE = "d02";
    private static String EXAMPLE = EXERCISE + "ex";

    public static void main(String[] args) throws Exception {
        solve(EXERCISE, 1); //9706670
        solve(EXERCISE, 2); //2552
    }

    public static void solve(String input, int part) throws Exception {
        var solution = new Day2();
        solution.read(input);
        var p1 = part == 1 ? solution.solve(12, 2) : solution.solve2(19690720);
        System.out.println(String.format("Part %d%s: %s", part, input.equals(EXAMPLE) ? "ex" : "", p1));
    }
}

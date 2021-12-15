package testDays;

import days.Day;
import days.Day15;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay15 {

    Day day = new Day15();

    @Test
    public void testPart1() {
            Assertions.assertEquals(40,
                day.part1(Arrays.asList("1163751742",
                        "1381373672",
                        "2136511328",
                        "3694931569",
                        "7463417111",
                        "1319128137",
                        "1359912421",
                        "3125421639",
                        "1293138521",
                        "2311944581")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(315,
                day.part2(Arrays.asList("1163751742",
                        "1381373672",
                        "2136511328",
                        "3694931569",
                        "7463417111",
                        "1319128137",
                        "1359912421",
                        "3125421639",
                        "1293138521",
                        "2311944581")));
    }
}
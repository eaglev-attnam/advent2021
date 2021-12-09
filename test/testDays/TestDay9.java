package testDays;

import days.Day;
import days.Day9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay9 {

    Day day = new Day9();

    @Test
    public void testPart1() {
        Assertions.assertEquals(15,
                day.part1(Arrays.asList("2199943210",
                        "3987894921",
                        "9856789892",
                        "8767896789",
                        "9899965678")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(1134,
                day.part2(Arrays.asList("2199943210",
                        "3987894921",
                        "9856789892",
                        "8767896789",
                        "9899965678")));
    }
}
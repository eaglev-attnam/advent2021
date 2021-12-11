package testDays;

import days.Day;
import days.Day11;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay11 {

    Day day = new Day11();

    @Test
    public void testPart1() {
        Assertions.assertEquals(1656,
                day.part1(Arrays.asList("5483143223",
                        "2745854711",
                        "5264556173",
                        "6141336146",
                        "6357385478",
                        "4167524645",
                        "2176841721",
                        "6882881134",
                        "4846848554",
                        "5283751526")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(195,
                day.part2(Arrays.asList("5483143223",
                        "2745854711",
                        "5264556173",
                        "6141336146",
                        "6357385478",
                        "4167524645",
                        "2176841721",
                        "6882881134",
                        "4846848554",
                        "5283751526")));
    }
}
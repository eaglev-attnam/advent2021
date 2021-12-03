package testDays;

import days.Day;
import days.Day3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay3 {

    Day day = new Day3();

    @Test
    public void testPart1() {
        Assertions.assertEquals(198,
                day.part1(Arrays.asList("00100",
                        "11110",
                        "10110",
                        "10111",
                        "10101",
                        "01111",
                        "00111",
                        "11100",
                        "10000",
                        "11001",
                        "00010",
                        "01010")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(230,
                day.part2(Arrays.asList("00100",
                        "11110",
                        "10110",
                        "10111",
                        "10101",
                        "01111",
                        "00111",
                        "11100",
                        "10000",
                        "11001",
                        "00010",
                        "01010")));
    }
}
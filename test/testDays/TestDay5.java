package testDays;

import days.Day;
import days.Day5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay5 {

    Day day = new Day5();

    @Test
    public void testPart1() {
        Assertions.assertEquals(5,
                day.part1(Arrays.asList("0,9 -> 5,9",
                        "8,0 -> 0,8",
                        "9,4 -> 3,4",
                        "2,2 -> 2,1",
                        "7,0 -> 7,4",
                        "6,4 -> 2,0",
                        "0,9 -> 2,9",
                        "3,4 -> 1,4",
                        "0,0 -> 8,8",
                        "5,5 -> 8,2")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(12,
                day.part2(Arrays.asList("0,9 -> 5,9",
                        "8,0 -> 0,8",
                        "9,4 -> 3,4",
                        "2,2 -> 2,1",
                        "7,0 -> 7,4",
                        "6,4 -> 2,0",
                        "0,9 -> 2,9",
                        "3,4 -> 1,4",
                        "0,0 -> 8,8",
                        "5,5 -> 8,2")));
    }
}
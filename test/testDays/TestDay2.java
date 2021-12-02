package testDays;

import days.Day;
import days.Day2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay2 {

    Day day = new Day2();

    @Test
    public void testPart1() {
        Assertions.assertEquals(150,
                day.part1(Arrays.asList("forward 5",
                        "down 5",
                        "forward 8",
                        "up 3",
                        "down 8",
                        "forward 2")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(900,
                day.part2(Arrays.asList("forward 5",
                        "down 5",
                        "forward 8",
                        "up 3",
                        "down 8",
                        "forward 2")));
    }
}
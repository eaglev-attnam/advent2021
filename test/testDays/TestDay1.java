package testDays;

import days.Day;
import days.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay1 {

    Day day = new Day1();

    @Test
    public void testPart1() {
        Assertions.assertEquals(7,
                day.part1(Arrays.asList("199",
                "200",
                "208",
                "210",
                "200",
                "207",
                "240",
                "269",
                "260",
                "263")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(5, day.part2(Arrays.asList("199",
                "200",
                "208",
                "210",
                "200",
                "207",
                "240",
                "269",
                "260",
                "263")));
    }
}
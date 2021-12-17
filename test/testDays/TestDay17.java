package testDays;

import days.Day;
import days.Day17;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class TestDay17 {

    Day day = new Day17();

    @Test
    public void testPart1() {
        Assertions.assertEquals(45,
                day.part1(Collections.singletonList("target area: x=20..30, y=-10..-5")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(112,
                 day.part2(Collections.singletonList("target area: x=20..30, y=-10..-5")));
    }
}
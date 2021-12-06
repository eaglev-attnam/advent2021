package testDays;

import days.Day;
import days.Day6;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class TestDay6 {

    Day day = new Day6();

    @Test
    public void testPart1() {
        Assertions.assertEquals(5934L,
                day.part1(Collections.singletonList("3,4,3,1,2")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(26984457539L,
                day.part2(Collections.singletonList("3,4,3,1,2")));
    }
}
package testDays;

import days.Day;
import days.Day7;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class TestDay7 {

    Day day = new Day7();

    @Test
    public void testPart1() {
        Assertions.assertEquals(37,
                day.part1(Collections.singletonList("16,1,2,0,4,2,7,1,2,14")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(168,
                day.part2(Collections.singletonList("16,1,2,0,4,2,7,1,2,14")));
    }
}
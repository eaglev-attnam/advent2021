package testDays;

import days.Day;
import days.Day0;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestDay0 {

    Day day = new Day0();

    @Test
    public void testPart1() {
        Assertions.assertEquals(0, day.part1(new ArrayList<>()));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(0, day.part2(new ArrayList<>()));
    }
}
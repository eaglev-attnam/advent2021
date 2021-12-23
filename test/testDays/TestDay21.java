package testDays;

import days.Day;
import days.Day21;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay21 {

    Day day = new Day21();

    @Test
    public void testPart1() {
        Assertions.assertEquals(739785,
                day.part1(Arrays.asList("Player 1 starting position: 4",
                        "Player 2 starting position: 8")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(444356092776315L,
                day.part2(Arrays.asList("Player 1 starting position: 4",
                        "Player 2 starting position: 8")));
    }
}


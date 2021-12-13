package testDays;

import days.Day;
import days.Day13;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay13 {

    Day day = new Day13();

    @Test
    public void testPart1() {
            Assertions.assertEquals(17,
                day.part1(Arrays.asList("6,10",
                        "0,14",
                        "9,10",
                        "0,3",
                        "10,4",
                        "4,11",
                        "6,0",
                        "6,12",
                        "4,1",
                        "0,13",
                        "10,12",
                        "3,4",
                        "3,0",
                        "8,4",
                        "1,10",
                        "2,14",
                        "8,10",
                        "9,0",
                        "",
                        "fold along y=7",
                        "fold along x=5")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals("#####\n#   #\n#   #\n#   #\n#####\n",
                day.part2(Arrays.asList("6,10",
                        "0,14",
                        "9,10",
                        "0,3",
                        "10,4",
                        "4,11",
                        "6,0",
                        "6,12",
                        "4,1",
                        "0,13",
                        "10,12",
                        "3,4",
                        "3,0",
                        "8,4",
                        "1,10",
                        "2,14",
                        "8,10",
                        "9,0",
                        "",
                        "fold along y=7",
                        "fold along x=5")));
    }
}
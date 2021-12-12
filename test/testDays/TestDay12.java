package testDays;

import days.Day;
import days.Day12;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay12 {

    Day day = new Day12();

    @Test
    public void testPart1() {
        Assertions.assertEquals(10,
                day.part1(Arrays.asList("start-A",
                        "start-b",
                        "A-c",
                        "A-b",
                        "b-d",
                        "A-end",
                        "b-end")));
        Assertions.assertEquals(19,
                day.part1(Arrays.asList("dc-end",
                        "HN-start",
                        "start-kj",
                        "dc-start",
                        "dc-HN",
                        "LN-dc",
                        "HN-end",
                        "kj-sa",
                        "kj-HN",
                        "kj-dc")));
        Assertions.assertEquals(226,
                day.part1(Arrays.asList("fs-end",
                        "he-DX",
                        "fs-he",
                        "start-DX",
                        "pj-DX",
                        "end-zg",
                        "zg-sl",
                        "zg-pj",
                        "pj-he",
                        "RW-he",
                        "fs-DX",
                        "pj-RW",
                        "zg-RW",
                        "start-pj",
                        "he-WI",
                        "zg-he",
                        "pj-fs",
                        "start-RW")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(36,
                day.part2(Arrays.asList("start-A",
                        "start-b",
                        "A-c",
                        "A-b",
                        "b-d",
                        "A-end",
                        "b-end")));
        Assertions.assertEquals(103,
                day.part2(Arrays.asList("dc-end",
                        "HN-start",
                        "start-kj",
                        "dc-start",
                        "dc-HN",
                        "LN-dc",
                        "HN-end",
                        "kj-sa",
                        "kj-HN",
                        "kj-dc")));
        Assertions.assertEquals(3509,
                day.part2(Arrays.asList("fs-end",
                        "he-DX",
                        "fs-he",
                        "start-DX",
                        "pj-DX",
                        "end-zg",
                        "zg-sl",
                        "zg-pj",
                        "pj-he",
                        "RW-he",
                        "fs-DX",
                        "pj-RW",
                        "zg-RW",
                        "start-pj",
                        "he-WI",
                        "zg-he",
                        "pj-fs",
                        "start-RW")));
    }
}
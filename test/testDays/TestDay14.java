package testDays;

import days.Day;
import days.Day14;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay14 {

    Day day = new Day14();

    @Test
    public void testPart1() {
            Assertions.assertEquals(1588,
                day.part1(Arrays.asList("NNCB",
                        "",
                        "CH -> B",
                        "HH -> N",
                        "CB -> H",
                        "NH -> C",
                        "HB -> C",
                        "HC -> B",
                        "HN -> C",
                        "NN -> C",
                        "BH -> H",
                        "NC -> B",
                        "NB -> B",
                        "BN -> B",
                        "BB -> N",
                        "BC -> B",
                        "CC -> N",
                        "CN -> C")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(2188189693529L,
                day.part2(Arrays.asList("NNCB",
                        "",
                        "CH -> B",
                        "HH -> N",
                        "CB -> H",
                        "NH -> C",
                        "HB -> C",
                        "HC -> B",
                        "HN -> C",
                        "NN -> C",
                        "BH -> H",
                        "NC -> B",
                        "NB -> B",
                        "BN -> B",
                        "BB -> N",
                        "BC -> B",
                        "CC -> N",
                        "CN -> C")));
    }
}
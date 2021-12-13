package testDays;

import days.Day;
import days.Day10;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestDay10 {

    Day day = new Day10();

    @Test
    public void testPart1() {
        Assertions.assertEquals(26397,
                day.part1(Arrays.asList("[({(<(())[]>[[{[]{<()<>>",
                        "[(()[<>])]({[<{<<[]>>(",
                        "{([(<{}[<>[]}>{[]{[(<()>",
                        "(((({<>}<{<{<>}{[]{[]{}",
                        "[[<[([]))<([[{}[[()]]]",
                        "[{[{({}]{}}([{[{{{}}([]",
                        "{<[[]]>}<{[{[{[]{()[[[]",
                        "[<(<(<(<{}))><([]([]()",
                        "<{([([[(<>()){}]>(<<{{",
                        "<{([{{}}[<[[[<>{}]]]>[]]")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(288957,
                day.part2(Arrays.asList("[({(<(())[]>[[{[]{<()<>>",
                        "[(()[<>])]({[<{<<[]>>(",
                        "{([(<{}[<>[]}>{[]{[(<()>",
                        "(((({<>}<{<{<>}{[]{[]{}",
                        "[[<[([]))<([[{}[[()]]]",
                        "[{[{({}]{}}([{[{{{}}([]",
                        "{<[[]]>}<{[{[{[]{()[[[]",
                        "[<(<(<(<{}))><([]([]()",
                        "<{([([[(<>()){}]>(<<{{",
                        "<{([{{}}[<[[[<>{}]]]>[]]")));
    }
}
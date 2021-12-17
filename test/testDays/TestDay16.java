package testDays;

import days.Day;
import days.Day16;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class TestDay16 {

    Day day = new Day16();

    @Test
    public void testPart1() {
        Assertions.assertEquals(16,
                day.part1(Collections.singletonList("8A004A801A8002F478")));
        Assertions.assertEquals(12,
                day.part1(Collections.singletonList("620080001611562C8802118E34")));
        Assertions.assertEquals(23,
                day.part1(Collections.singletonList("C0015000016115A2E0802F182340")));
        Assertions.assertEquals(31,
                day.part1(Collections.singletonList("A0016C880162017C3686B18A3D4780")));
    }

    @Test
    public void testPart2() {
        Assertions.assertEquals(3,
                day.part2(Collections.singletonList("C200B40A82")));
        Assertions.assertEquals(54,
                day.part2(Collections.singletonList("04005AC33890")));
        Assertions.assertEquals(7,
                day.part2(Collections.singletonList("880086C3E88112")));
        Assertions.assertEquals(9,
                day.part2(Collections.singletonList("CE00C43D881120")));
        Assertions.assertEquals(1,
                day.part2(Collections.singletonList("D8005AC2A8F0")));
        Assertions.assertEquals(0,
                day.part2(Collections.singletonList("F600BC2D8F")));
        Assertions.assertEquals(0,
                day.part2(Collections.singletonList("9C005AC2F8F0")));
        Assertions.assertEquals(1,
                day.part2(Collections.singletonList("9C0141080250320F1802104A08")));
    }
}
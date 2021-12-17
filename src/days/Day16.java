package days;

import common.Coordinate;
import common.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Day16 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 16;
	}

	@Override
	public Object part1(List<String> input) {
		StringBuilder binarySB = new StringBuilder();
		for(char c : input.get(0).toCharArray()) {
			String number = String.format("%4s", Integer.toString(Integer.parseInt(c + "", 16), 2)).replace(' ', '0');
			binarySB.append(number);
		}
		String binary = binarySB.toString();
		return getVersionSumAndUsedLength(binary).getA();
	}

	private Pair<Integer, Integer> getVersionSumAndUsedLength(String binary) {
		int version = Integer.parseInt(binary.substring(0, 3), 2);
		int type = Integer.parseInt(binary.substring(3, 6), 2);
		if(type == 4) {
			int i = 6;
			while(binary.charAt(i) == '1') {
				i += 5;
			}
			return new Pair<>(version, i + 5);
		} else {
			if(binary.charAt(6) == '0') {
				int subLength = Integer.parseInt(binary.substring(7, 22), 2);
				int used = 0;
				while(used < subLength) {
					Pair<Integer, Integer> subVersionLength = getVersionSumAndUsedLength(binary.substring(22 + used, 22 + subLength));
					used += subVersionLength.getB();
					version += subVersionLength.getA();
				}
				return new Pair<>(version, 22 + subLength);
			} else {
				int subPackets = Integer.parseInt(binary.substring(7, 18), 2);
				int used = 18;
				for(int i = 0; i < subPackets; i++) {
					Pair<Integer, Integer> subVersionLength = getVersionSumAndUsedLength(binary.substring(used));
					version += subVersionLength.getA();
					used += subVersionLength.getB();
				}
				return new Pair<>(version, used);
			}
		}
	}

	private Pair<Long, Integer> getValueAndUsedLength(String binary) {
		int type = Integer.parseInt(binary.substring(3, 6), 2);
		if(type == 4) {
			int i = 6;
			StringBuilder sb = new StringBuilder();
			while(binary.charAt(i) == '1') {
				sb.append(binary.substring(i + 1, i + 5));
				i += 5;
			}
			sb.append(binary.substring(i + 1, i + 5));
			long value = Long.parseLong(sb.toString(), 2);
			return new Pair<>(value, i + 5);
		} else {
			List<Long> subValues = new ArrayList<>();
			int length;
			if(binary.charAt(6) == '0') {
				int subLength = Integer.parseInt(binary.substring(7, 22), 2);
				int used = 0;
				while(used < subLength) {
					Pair<Long, Integer> subValueLength = getValueAndUsedLength(binary.substring(22 + used, 22 + subLength));
					used += subValueLength.getB();
					subValues.add(subValueLength.getA());
				}
				length = 22 + subLength;
			} else {
				int subPackets = Integer.parseInt(binary.substring(7, 18), 2);
				int used = 18;
				for(int i = 0; i < subPackets; i++) {
					Pair<Long, Integer> subValueLength = getValueAndUsedLength(binary.substring(used));
					used += subValueLength.getB();
					subValues.add(subValueLength.getA());
				}
				length = used;
			}
			int opcode = Integer.parseInt(binary.substring(3, 6), 2);
			long value = 0;
			switch (opcode) {
				case 0 :
					value = subValues.stream().reduce(0L, Long::sum);
					break;
				case 1 :
					value = subValues.stream().reduce(1L, (a,b) -> a*b);
					break;
				case 2 :
					value = subValues.stream().min(Long::compareTo).orElseThrow();
					break;
				case 3 :
					value = subValues.stream().max(Long::compareTo).orElseThrow();
					break;
				case 5:
					value = (subValues.get(0) > subValues.get(1) ? 1L : 0L);
					break;
				case 6:
					value = (subValues.get(0) < subValues.get(1) ? 1L : 0L);
					break;
				case 7:
					value = (Objects.equals(subValues.get(0), subValues.get(1)) ? 1L : 0L);
					break;
				default:
					throw new RuntimeException();
			}
			return new Pair<>(value, length);
		}
	}

	@Override
	public Object part2(List<String> input) {
		StringBuilder binarySB = new StringBuilder();
		for(char c : input.get(0).toCharArray()) {
			String number = String.format("%4s", Integer.toString(Integer.parseInt(c + "", 16), 2)).replace(' ', '0');
			binarySB.append(number);
		}
		String binary = binarySB.toString();
		return getValueAndUsedLength(binary).getA();
	}
}
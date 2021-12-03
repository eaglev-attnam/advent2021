package days;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day3 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 3;
	}
	
	@Override
	public Object part1(List<String> input) {
		int[] ones = new int[input.get(0).length()];
		int[] zeroes = new int[ones.length];
		for(String s : input) {
			for(int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == '1') {
					ones[i]++;
				} else {
					zeroes[i]++;
				}
			}
		}
		int gamma = 0;
		int epsilon = 0;
		for(int i = 0; i < ones.length; i++) {
			gamma *=2;
			epsilon *= 2;
			if(ones[i] > zeroes[i]) {
				gamma++;
			} else {
				epsilon++;
			}
		}
		return gamma * epsilon;
	}

	@Override
	public Object part2(List<String> input) {
		int o2 = Integer.parseInt(getLastValue(input, true), 2);
		int co2 = Integer.parseInt(getLastValue(input, false), 2);
		return o2 * co2;
	}

	public String getLastValue(List<String> input, boolean keepMostCommon) {
		List<String> copy = new ArrayList<>(input);
		int step = 0;
		while(copy.size() > 1) {
			int zeroes = 0;
			int ones = 0;
			for(String s : copy) {
				if(s.charAt(step) == '1') {
					ones++;
				} else {
					zeroes++;
				}
			}
			char mostCommon = (ones >= zeroes ? '1' : '0');
			final int i = step;
			copy.removeIf(s -> (s.charAt(i) == mostCommon) != keepMostCommon);
			step++;
		}
		return copy.get(0);
	}
}

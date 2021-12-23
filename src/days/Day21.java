package days;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day21 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 21;
	}

	@Override
	public Object part1(List<String> input) {
		int[] pos = new int[]{
				Integer.parseInt(input.get(0).split(": ")[1]) - 1,
				Integer.parseInt(input.get(1).split(": ")[1]) - 1
		};
		int[] score = new int[2];
		int rolls = 0;
		int turn = 0;
		while(score[0] < 1000 && score[1] < 1000) {
			for(int i = 0; i < 3; i++) {
				pos[turn] += (rolls % 100) + 1;
				rolls++;
			}
			pos[turn] %= 10;
			score[turn] += pos[turn] + 1;
			turn = 1 - turn;
		}
		return rolls * Math.min(score[0], score[1]);
	}

	@Override
	public Object part2(List<String> input) {
		int[] pos = new int[]{
				Integer.parseInt(input.get(0).split(": ")[1]) - 1,
				Integer.parseInt(input.get(1).split(": ")[1]) - 1
		};
		long[] wins = wins(new int[]{21,21}, pos, new HashMap<>());
		return Math.max(wins[0], wins[1]);
	}

	int[] universes = new int[]{0,0,0,1,3,6,7,6,3,1};

	private long[] wins(int[] toGo, int[] loc, Map<String, long[]> calculated) {
		String signature = toGo[0] + " " + toGo[1] + " " + loc[0] + " " + loc[1];
		if(calculated.containsKey(signature)) {
			return calculated.get(signature);
		} else if(toGo[0] <= 0) {
			return new long[]{1,0};
		} else if(toGo[1] <= 0) {
			return new long[]{0,1};
		}
		long[] result = new long[2];
		for(int roll = 3; roll <= 9; roll++) {
			int newLoc = (loc[0] + roll) % 10;
			int score = newLoc + 1;
			long[] sub = wins(new int[]{toGo[1], toGo[0] - score}, new int[]{loc[1], newLoc}, calculated);
			result[0] += sub[1] * universes[roll];
			result[1] += sub[0] * universes[roll];
		}
		calculated.put(signature, result);
		return result;
	}
}
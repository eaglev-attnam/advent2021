package days;

import common.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Day14 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 14;
	}

	@Override
	public Object part1(List<String> input) {
		String polymer = input.get(0);
		Map<String, String> replacements = new HashMap<>();
		for(int i = 2; i < input.size(); i++) {
			String[] w = input.get(i).split(" -> ");
			replacements.put(w[0], w[0].charAt(0) + w[1]);
		}
		for(int i = 0; i < 10; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < polymer.length() - 1; j++) {
				sb.append(replacements.get(polymer.substring(j, j+2)));
			}
			sb.append(polymer.substring(polymer.length() - 1));
			polymer = sb.toString();
		}
		Map<Character, Integer> count = new HashMap<>();
		for (char c : polymer.toCharArray()) {
			count.putIfAbsent(c, 0);
			count.put(c, count.get(c) + 1);
		}
		return count.values().stream().max(Integer::compareTo).orElseThrow() - count.values().stream().min(Integer::compareTo).orElseThrow();
	}

	@Override
	public Object part2(List<String> input) {
		String polymer = input.get(0);
		Map<String, String> replacements = new HashMap<>();
		for(int i = 2; i < input.size(); i++) {
			String[] w = input.get(i).split(" -> ");
			replacements.put(w[0], w[0].charAt(0) + w[1] + w[0].charAt(1));
		}
		List<Map<String, Map<Character, Long>>> solutions = new ArrayList<>();
		for(int i = 0; i <= 40; i++) {
			solutions.add(new HashMap<>());
		}
		Map<Character, Long> count = getCount(polymer, replacements, 40, solutions);
		return count.values().stream().max(Long::compareTo).orElseThrow() - count.values().stream().min(Long::compareTo).orElseThrow();
	}

	private Map<Character, Long> getCount(String polymer, Map<String, String> replacements, int iterationsToGo, List<Map<String, Map<Character, Long>>> solutions) {
		if(solutions.get(iterationsToGo).containsKey(polymer)) {
			return solutions.get(iterationsToGo).get(polymer);
		}
		Map<Character, Long> count = new HashMap<>();
		if(iterationsToGo == 0) {
			for (char c : polymer.toCharArray()) {
				count.putIfAbsent(c, 0L);
				count.put(c, count.get(c) + 1);
			}
		} else {
			for (int j = 0; j < polymer.length() - 1; j++) {
				String subPoly = replacements.get(polymer.substring(j, j+2));
				Map<Character, Long> subCount = getCount(subPoly, replacements, iterationsToGo - 1, solutions);
				for(char c : subCount.keySet()) {
					count.putIfAbsent(c, 0L);
					count.put(c, count.get(c) + subCount.get(c));
				}
				if(j != 0) {
					count.put(subPoly.charAt(0), count.get(subPoly.charAt(0)) - 1);
				}
			}
		}
		solutions.get(iterationsToGo).put(polymer, count);
		return count;
	}
}
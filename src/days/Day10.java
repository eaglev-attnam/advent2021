package days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day10 extends Day {

	private static final Map<Character, Character> brackets = new HashMap<>();
	static {
		brackets.put('(', ')');
		brackets.put('[', ']');
		brackets.put('{', '}');
		brackets.put('<', '>');
	}

	@Override
	protected int getChallengeNumber() {
		return 10;
	}

	@Override
	public Object part1(List<String> input) {
		Map<Character, Integer> scores = new HashMap<>();
		scores.put(')', 3);
		scores.put(']', 57);
		scores.put('}', 1197);
		scores.put('>', 25137);
		int score = 0;
		for(String s : input) {
			LinkedList<Character> stack = new LinkedList<>();
			int i = 0;
			while(i < s.length()) {
				char c = s.charAt(i);
				if(brackets.containsKey(c)) {
					stack.push(brackets.get(c));
				} else {
					char o = stack.pop();
					if(o != c) {
						score += scores.get(c);
						i = s.length();
					}
				}
				i++;
			}
		}
		return score;
	}

	@Override
	public Object part2(List<String> input) {
		Map<Character, Integer> scores = new HashMap<>();
		scores.put(')', 1);
		scores.put(']', 2);
		scores.put('}', 3);
		scores.put('>', 4);
		List<Long> lineScores = new ArrayList<>();
		for(String s : input) {
			LinkedList<Character> stack = new LinkedList<>();
			int i = 0;
			boolean incomplete = true;
			while(i < s.length() && incomplete) {
				char c = s.charAt(i);
				if(brackets.containsKey(c)) {
					stack.push(brackets.get(c));
				} else {
					char o = stack.pop();
					if(o != c) {
						incomplete = false;
					}
				}
				i++;
			}
			if(incomplete) {
				long score = 0;
				while(!stack.isEmpty()) {
					score *= 5;
					score += scores.get(stack.pop());
				}
				lineScores.add(score);
			}
		}
		lineScores.sort(Long::compareTo);
		return lineScores.get(lineScores.size() / 2);
	}
}
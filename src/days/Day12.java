package days;

import java.util.*;

public class Day12 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 12;
	}

	@Override
	public Object part1(List<String> input) {
		Map<String, Set<String>> paths = new HashMap<>();
		for(String s : input) {
			String[] w = s.split("-");
			paths.putIfAbsent(w[0], new HashSet<>());
			paths.putIfAbsent(w[1], new HashSet<>());
			paths.get(w[0]).add(w[1]);
			paths.get(w[1]).add(w[0]);
		}
		return getPaths(paths, new HashSet<>(), "start", true);
	}

	private int getPaths(Map<String, Set<String>> map, Set<String> visited, String current, boolean usedDouble) {
		if("end".equals(current)) {
			return 1;
		} else if (visited.contains(current)) {
			if("start".equals(current) || usedDouble) {
				return 0;
			} else {
				usedDouble = true;
			}
		}
		boolean newUsedDouble = usedDouble;
		Set<String> newVisited = new HashSet<>(visited);
		if(current.toLowerCase().equals(current)) {
			newVisited.add(current);
		}
		return map.get(current).stream()
				.mapToInt(next -> getPaths(map, newVisited, next, newUsedDouble)).sum();
	}

	@Override
	public Object part2(List<String> input) {
		Map<String, Set<String>> paths = new HashMap<>();
		for(String s : input) {
			String[] w = s.split("-");
			paths.putIfAbsent(w[0], new HashSet<>());
			paths.putIfAbsent(w[1], new HashSet<>());
			paths.get(w[0]).add(w[1]);
			paths.get(w[1]).add(w[0]);
		}
		return getPaths(paths, new HashSet<>(), "start", false);
	}
}
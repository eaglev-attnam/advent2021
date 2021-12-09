package days;

import common.Coordinate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day9 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 9;
	}

	@Override
	public Object part1(List<String> input) {
		int[][] floor = getFloor(input);
		int sum = 0;
		for(int x = 0; x < floor.length; x++) {
			for(int y = 0; y < floor[0].length; y++) {
				boolean lowest = true;
				for(Coordinate n : new Coordinate(x, y).getNeighbours()) {
					int nx = n.getX();
					int ny = n.getY();
					if(nx >= 0 && ny >= 0 && nx < floor.length && ny < floor[0].length) {
						if(floor[nx][ny] <= floor[x][y]) {
							lowest = false;
						}
					}
				}
				if(lowest) {
					sum += 1 + floor[x][y];
				}
			}
		}
		return sum;
 	}

	private int[][] getFloor(List<String> input) {
		int[][] floor = new int[input.get(0).length()][input.size()];
		for(int x = 0; x < input.get(0).length(); x++) {
			for(int y = 0; y < input.size(); y++) {
				floor[x][y] = Integer.parseInt(input.get(y).substring(x, x+1));
			}
		}
		return floor;
	}

	@Override
	public Object part2(List<String> input) {
		int[][] floor = getFloor(input);
		int sum = 0;
		Map<Coordinate, Coordinate> basins = new HashMap<>();
		for(int x = 0; x < floor.length; x++) {
			for (int y = 0; y < floor[0].length; y++) {
				if(floor[x][y] < 9) {
					basins = findBasins(floor, new Coordinate(x, y), basins);
				}
			}
		}
		Map<Coordinate, Integer> sizes = new HashMap<>();
		basins.forEach((c, l) -> {
			sizes.putIfAbsent(l, 0);
			sizes.put(l, sizes.get(l) + 1);
		});
		List<Integer> sorted = sizes.values().stream().sorted().collect(Collectors.toList());
		return sorted.get(sorted.size() - 1) * sorted.get(sorted.size() - 2) * sorted.get(sorted.size() - 3);
	}

	private Map<Coordinate, Coordinate> findBasins(int[][] floor, Coordinate c, Map<Coordinate, Coordinate> basins) {
		if(basins.containsKey(c)) {
			return basins;
		}
		Coordinate lowest = c;
		for(Coordinate n : c.getNeighbours()) {
			int nx = n.getX();
			int ny = n.getY();
			if(nx >= 0 && ny >= 0 && nx < floor.length && ny < floor[0].length) {
				if(floor[nx][ny] <= floor[lowest.getX()][lowest.getY()]) {
					lowest = new Coordinate(nx, ny);
				}
			}
		}
		if(lowest.equals(c)) {
			basins.put(c, c);
		} else {
			basins = findBasins(floor, lowest, basins);
			basins.put(c, basins.get(lowest));
		}
		return basins;
	}
}
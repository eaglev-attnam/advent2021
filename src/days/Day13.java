package days;

import common.Coordinate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day13 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 13;
	}

	@Override
	public Object part1(List<String> input) {
		Set<Coordinate> coords = new HashSet<>();
		int i = 0;
		while(!input.get(i).isEmpty()) {
			String[] w = input.get(i).split(",");
			Coordinate c = new Coordinate(Integer.parseInt(w[0]), Integer.parseInt(w[1]));
			coords.add(c);
			i++;
		}
		i++;
		String[] w = input.get(i).split("=");
		Set<Coordinate> afterFold = new HashSet<>();
		for(Coordinate c : coords) {
			afterFold.add(fold(c, w[0].contains("x"), Integer.parseInt(w[1])));
		}
		return afterFold.size();
	}

	private Coordinate fold(Coordinate c, boolean vertical, int fold) {
		int x = c.getX();
		int y = c.getY();
		if(vertical) {
			if(x > fold) {
				x = 2 * fold - x;
			}
		} else {
			if(y > fold) {
				y = 2 * fold - y;
			}
		}
		return new Coordinate(x, y);
	}

	@Override
	public Object part2(List<String> input) {
		Set<Coordinate> coords = new HashSet<>();
		int i = 0;
		while(!input.get(i).isEmpty()) {
			String[] w = input.get(i).split(",");
			Coordinate c = new Coordinate(Integer.parseInt(w[0]), Integer.parseInt(w[1]));
			coords.add(c);
			i++;
		}
		i++;
		while(i < input.size()) {
			String[] w = input.get(i).split("=");
			Set<Coordinate> afterFold = new HashSet<>();
			for(Coordinate c : coords) {
				afterFold.add(fold(c, w[0].contains("x"), Integer.parseInt(w[1])));
			}
			coords = afterFold;
			i++;
		}
		int maxX = coords.stream().map(Coordinate::getX).max(Integer::compare).get();
		int maxY = coords.stream().map(Coordinate::getY).max(Integer::compare).get();
		StringBuilder sb = new StringBuilder();
		for(int y = 0; y <= maxY; y++) {
			for(int x = 0; x <= maxX; x++) {
				if(coords.contains(new Coordinate(x, y))) {
					sb.append("#");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
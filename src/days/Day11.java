package days;

import common.Coordinate;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Day11 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 11;
	}

	@Override
	public Object part1(List<String> input) {
		int[][] squids = new int[10][10];
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				squids[x][y] = Integer.parseInt(input.get(y).charAt(x) + "");
			}
		}
		int flashes = 0;
		for(int i = 0; i < 100; i++) {
			flashes += tick(squids).size();
		}
		return flashes;
	}

	private Set<Coordinate> tick(int[][] squids) {
		LinkedList<Coordinate> flashing = new LinkedList<>();
		Set<Coordinate> flashed = new HashSet<>();
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				squids[x][y]++;
				if(squids[x][y] >= 10) {
					flashing.add(new Coordinate(x, y));
				}
			}
		}
		while(!flashing.isEmpty()) {
			Coordinate c = flashing.pop();
			flashed.add(c);
			for(int dx = -1; dx <= 1; dx++) {
				for(int dy = -1; dy <= 1; dy++) {
					int x = c.getX() + dx;
					int y = c.getY() + dy;
					if(x >= 0 && y >= 0 && x < 10 && y < 10) {
						squids[x][y]++;
						if(squids[x][y] >= 10) {
							Coordinate n = new Coordinate(x, y);
							if(!flashed.contains(n) && !flashing.contains(n)) {
								flashing.add(new Coordinate(x, y));
							}
						}
					}
				}
			}
		}
		for(Coordinate c : flashed) {
			squids[c.getX()][c.getY()] = 0;
		}
		return flashed;
	}

	@Override
	public Object part2(List<String> input) {
		int[][] squids = new int[10][10];
		for(int x = 0; x < 10; x++) {
			for(int y = 0; y < 10; y++) {
				squids[x][y] = Integer.parseInt(input.get(y).charAt(x) + "");
			}
		}
		int i = 1;
		while(tick(squids).size() < 100) {
			i++;
		}
		return i;
	}
}
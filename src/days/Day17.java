package days;

import java.util.List;

public class Day17 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 17;
	}

	@Override
	public Object part1(List<String> input) {
		// target area: x=201..230, y=-99..-65
		//      0       1  2    3   4  5    6
		String[] w = input.get(0).split("(: |\\.\\.|=|, )");
		int minY = Integer.parseInt(w[5]);
		int initialY = -minY - 1;
		int timeToFall = 2 * initialY + 1;
		int totalX = 0;
		int initialX = 0;
		int minX = Integer.parseInt(w[2]);
		int maxX = Integer.parseInt(w[3]);
		while(totalX < minX) {
			initialX++;
			totalX += initialX;
		}
		if(initialX < timeToFall && totalX < maxX) {
			return (initialY * (initialY + 1)) / 2;
		}
		return 0;
	}

	@Override
	public Object part2(List<String> input) {
		String[] w = input.get(0).split("(: |\\.\\.|=|, )");
		int minX = Integer.parseInt(w[2]);
		int maxX = Integer.parseInt(w[3]);
		int minY = Integer.parseInt(w[5]);
		int maxY = Integer.parseInt(w[6]);
		int matches = 0;
		for(int x = 0; x <= maxX; x++) {
			for(int y = minY; y <= -minY - 1; y++) {
				if(reaches(x, y, minX, maxX, minY, maxY)) {
					matches++;
				}
			}
		}
		return matches;
	}

	private boolean reaches(int dx, int dy, int minX, int maxX, int minY, int maxY) {
		int x = 0;
		int y = 0;
		while(x <= maxX && y >= minY) {
			x += dx;
			y += dy;
			if(dx > 0) {
				dx--;
			}
			dy--;
			if(x <= maxX && x >= minX && y <= maxY && y >= minY) {
				return true;
			}
		}
		return false;
	}
}
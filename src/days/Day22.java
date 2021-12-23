package days;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Day22 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 22;
	}

	@Override
	public Object part1(List<String> input) {
		return calculate(input, true);
	}

	@Override
	public Object part2(List<String> input) {
		return calculate(input, false);
	}

	private long calculate(List<String> input, boolean smallCube) {
		TreeSet<Integer> xSet = new TreeSet<>();
		TreeSet<Integer> ySet = new TreeSet<>();
		TreeSet<Integer> zSet = new TreeSet<>();
		List<int[]> flips = new ArrayList<>();
		List<Boolean> on = new ArrayList<>();

		for(String s : input) {
			String[] words = s.split("([ ,][xyz]=)|(\\.\\.)");
			int[] flip = new int[6];
			boolean inRange = true;
			for(int i = 0; i < 6; i++) {
				flip[i] = Integer.parseInt(words[i+1]);
				if(Math.abs(flip[i]) > 50) {
					inRange = !smallCube;
				}
				if(i % 2 == 1) {
					flip[i]++;
				}
			}
			if(inRange) {
				on.add("on".equals(words[0]));
				flips.add(flip);
				for (int i = 0; i <= 1; i++) {
					xSet.add(flip[i]);
					ySet.add(flip[i + 2]);
					zSet.add(flip[i + 4]);
				}
			}
		}

		List<Integer> xs = new ArrayList<>(xSet);
		List<Integer> ys = new ArrayList<>(ySet);
		List<Integer> zs = new ArrayList<>(zSet);
		boolean[][][] cubes = new boolean[xs.size() - 1][ys.size() - 1][zs.size() - 1];
		for(int i = 0; i < flips.size(); i++) {
			int[] flip = flips.get(i);
			int startX = xs.indexOf(flip[0]);
			int endX = xs.indexOf(flip[1]);
			int startY = ys.indexOf(flip[2]);
			int endY = ys.indexOf(flip[3]);
			int startZ = zs.indexOf(flip[4]);
			int endZ = zs.indexOf(flip[5]);

			for(int xc = startX; xc < endX; xc++) {
				for(int yc = startY; yc < endY; yc++) {
					for(int zc = startZ; zc < endZ; zc++) {
						cubes[xc][yc][zc] = on.get(i);
					}
				}
			}
		}

		long onTotal = 0;
		for(int x = 0; x < xs.size() - 1; x++) {
			for(int y = 0; y < ys.size() - 1; y++) {
				for(int z = 0; z < zs.size() - 1; z++) {
					if(cubes[x][y][z]) {
						onTotal += 1L * (xs.get(x+1) - xs.get(x)) * (ys.get(y+1) - ys.get(y)) * (zs.get(z+1) - zs.get(z));
					}
				}
			}
		}
		return onTotal;
	}
}
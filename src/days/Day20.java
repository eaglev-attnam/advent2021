package days;

import java.util.*;
import java.util.stream.Collectors;

public class Day20 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 20;
	}

	@Override
	public Object part1(List<String> input) {
		return enhance(input, 2);
	}

	@Override
	public Object part2(List<String> input) {
		return enhance(input, 50);
	}

	private int enhance(List<String> input, int times) {
		List<Boolean> algo = input.get(0).chars().boxed().map(c -> c == '#').collect(Collectors.toList());
		boolean reverse = false;
		boolean[][] image = new boolean[input.get(2).length() + 2*times + 2][input.size() + 2*times];
		for(int y = 0; y < input.size() - 2; y++) {
			for(int x = 0; x < input.get(y+2).length(); x++) {
				image[x+times+1][y+times+1] = input.get(y+2).charAt(x) == '#';
			}
		}
		for(int i = 0; i < times; i++) {
			boolean[][] newImage = new boolean[image.length][image[0].length];
			boolean border = image[0][0];
			boolean borderReplacement = algo.get(border ? 511 : 0);
			for(int x = 0; x < image.length; x++) {
				newImage[x][0] = borderReplacement;
				newImage[x][image[0].length - 1] = borderReplacement;
			}
			for(int y = 0; y < image[0].length; y++) {
				newImage[0][y] = borderReplacement;
				newImage[image.length - 1][y] = borderReplacement;
			}
			for(int x = 1; x < image.length - 1; x++) {
				for(int y = 1; y < image[0].length - 1; y++) {
					int n = 0;
					for(int dy = -1; dy <= 1; dy++) {
						for(int dx = -1; dx <= 1; dx++) {
							n *= 2;
							boolean reversed = reverse && i%2 == 1;
							n += image[x+dx][y+dy] ^ reversed ? 1 : 0;
						}
						newImage[x][y] = algo.get(n) ^ reverse;
					}
				}
			}
			image = newImage;
		}
		int total = 0;
		for(int x = 0; x < image.length; x++) {
			for(int y = 0; y < image[0].length; y++) {
				if(image[x][y]) {
					total++;
				}
			}
		}
		return total;
	}

	private void print(boolean[][] image) {
		for(int x = 0; x < image[0].length; x++) {
			for(int y = 0; y < image.length; y++) {
				System.out.print(image[y][x] ? '#' : '.');
			}
			System.out.println();
		}
		System.out.println();
	}
}
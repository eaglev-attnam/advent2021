package days;

import java.util.List;
import java.util.Map;

public class Day5 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 5;
	}

	@Override
	public Object part1(List<String> input) {
		int[][] points = new int[1000][1000];
		for(String s : input) {
			String[] words = s.split("(,| -> )");
			int[] coords = new int[4];
			for(int i = 0; i < 4; i++) {
				coords[i] = Integer.parseInt(words[i]);
			}
			// { x1, y1, x2, y2 }
			if(coords[0] == coords[2]) {
				int x = coords[0];
				int minY = Math.min(coords[1], coords[3]);
				int maxY = Math.max(coords[1], coords[3]);
				for(int y = minY; y <= maxY; y++) {
					points[x][y]++;
				}
			} else if(coords[1] == coords[3]) {
				int y = coords[1];
				int minX = Math.min(coords[0], coords[2]);
				int maxX = Math.max(coords[0], coords[2]);
				for(int x = minX; x <= maxX; x++) {
					points[x][y]++;
				}
			}
		}
		int sum = 0;
		for(int x = 0; x < points.length; x++) {
			for(int y = 0; y < points.length; y++) {
				if(points[x][y] >= 2) {
					sum++;
				}
			}
		}
		return sum;
 	}

	@Override
	public Object part2(List<String> input) {
		int[][] points = new int[1000][1000];
		for(String s : input) {
			String[] words = s.split("(,| -> )");
			int[] coords = new int[4];
			for(int i = 0; i < 4; i++) {
				coords[i] = Integer.parseInt(words[i]);
			}
			// { x1, y1, x2, y2 }
			if(coords[0] == coords[2]) {
				int x = coords[0];
				int minY = Math.min(coords[1], coords[3]);
				int maxY = Math.max(coords[1], coords[3]);
				for(int y = minY; y <= maxY; y++) {
					points[x][y]++;
				}
			} else if(coords[1] == coords[3]) {
				int y = coords[1];
				int minX = Math.min(coords[0], coords[2]);
				int maxX = Math.max(coords[0], coords[2]);
				for(int x = minX; x <= maxX; x++) {
					points[x][y]++;
				}
			} else {
				int dx = (coords[0] > coords[2] ? -1 : 1);
				int dy = (coords[1] > coords[3] ? -1 : 1);
				for(int t = 0; t <= Math.abs(coords[0] - coords[2]); t++) {
					int x = coords[0] + t * dx;
					int y = coords[1] + t * dy;
					points[x][y]++;
				}
			}
		}
		int sum = 0;
		for(int x = 0; x < points.length; x++) {
			for(int y = 0; y < points.length; y++) {
				if(points[x][y] >= 2) {
					sum++;
				}
			}
		}
		return sum;
	}
}

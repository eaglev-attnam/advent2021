package days;

import common.Pair;

import java.util.*;
import java.util.stream.Collectors;

public class Day19 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 19;
	}

	@Override
	public Object part1(List<String> input) {
		List<Scanner> scanners = getAlignedScanners(input);
		Set<String> coords = new HashSet<>();
		for(Scanner s : scanners) {
			for(int[] c : s.coords) {
				coords.add(c[0] + "," + c[1] + "," + c[2]);
			}
		}
		return coords.size();
	}

	@Override
	public Object part2(List<String> input) {
		List<Scanner> scanners = getAlignedScanners(input);
		int maxDist = 0;
		for(Scanner s1 : scanners) {
			for(Scanner s2 : scanners) {
				int dist = Math.abs(s1.self[0] - s2.self[0]) + Math.abs(s1.self[1] - s2.self[1]) + Math.abs(s1.self[2] - s2.self[2]);
				maxDist = Math.max(dist, maxDist);
			}
		}
		return maxDist;
	}

	private List<Scanner> getAlignedScanners(List<String> input) {
		List<Scanner> scanners = new ArrayList<>();
		Scanner scanner = null;
		for(String s : input) {
			if(s.contains("scanner")) {
				scanner = new Scanner();
				scanners.add(scanner);
			} else if(!s.isBlank()) {
				String[] words = s.split(",");
				scanner.coords.add(new int[] {Integer.parseInt(words[0]), Integer.parseInt(words[1]), Integer.parseInt(words[2])});
			}
		}
		LinkedList<Scanner> toCheck = new LinkedList<>();
		Set<Scanner> checked = new HashSet<>();
		toCheck.add(scanners.get(0));
		while(toCheck.size() + checked.size() < scanners.size()) {
			Scanner base = toCheck.pop();
			checked.add(base);
			for(Scanner second : scanners) {
				if(!checked.contains(second) && !toCheck.contains(second)) {
					if(align(base, second)) {
						toCheck.add(second);
					}
				}
			}
		}
		return scanners;
	}

	private boolean align(Scanner base, Scanner second) {
		Set<String> baseCoordFingerprints = base.coords.stream().map(c -> c[0] + "," + c[1] + "," + c[2]).collect(Collectors.toSet());
		for(int xcol = 0; xcol < 3; xcol++) {
			for(int ycol = 0; ycol < 3; ycol++) {
				if(ycol != xcol) {
					int zcol = 3 - xcol - ycol;
					for (boolean revx : new boolean[]{true, false}) {
						for (boolean revy : new boolean[]{true, false}) {
							for (boolean revz : new boolean[]{true, false}) {
								for (int c = 0; c < second.coords.size() - 12; c++) {
									int[] newC = translate(second.coords.get(c), xcol, ycol, zcol, revx, revy, revz, 0, 0 , 0);
									for (int[] bc : base.coords) {
										int Xoffset = bc[0] - newC[0];
										int Yoffset = bc[1] - newC[1];
										int Zoffset = bc[2] - newC[2];

										List<Integer> matches = new ArrayList<>();
										matches.add(c);
										for (int c2 = c + 1; c2 < second.coords.size(); c2++) {
											int[] newC2 = translate(second.coords.get(c2), xcol, ycol, zcol, revx, revy, revz, Xoffset, Yoffset, Zoffset);
											if (baseCoordFingerprints.contains(newC2[0] + "," + newC2[1] + "," + newC2[2])) {
												matches.add(c2);
											}
										}
										if(matches.size() >= 12) {
											List<int[]> translatedCoords = new ArrayList<>();
											for(int[] coord : second.coords) {
												translatedCoords.add(translate(coord, xcol, ycol, zcol, revx, revy, revz, Xoffset, Yoffset, Zoffset));
												second.coords = translatedCoords;
											}
											second.self = translate(second.self, xcol, ycol, zcol, revx, revy, revz, Xoffset, Yoffset, Zoffset);
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	private int[] translate(int[] coord, int xcol, int ycol, int zcol, boolean revX, boolean revY, boolean revZ, int Xoffset, int Yoffset, int Zoffset) {
		int newX = coord[xcol];
		int newY = coord[ycol];
		int newZ = coord[zcol];
		if(revX) {
			newX = -newX;
		}
		if(revY) {
			newY = -newY;
		}
		if(revZ) {
			newZ = -newZ;
		}
		return new int[] {newX + Xoffset, newY + Yoffset, newZ + Zoffset};
	}

	private class Scanner {
		private List<int[]> coords = new ArrayList<>();
		private int[] self = new int[]{0,0,0};
	}
}
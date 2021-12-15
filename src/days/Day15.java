package days;

import common.Coordinate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Day15 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 15;
	}

	@Override
	public Object part1(List<String> input) {
		int[][] costs = new int[input.get(0).length()][input.size()];
		for(int x = 0; x < input.get(0).length(); x++) {
			for(int y = 0; y < input.size(); y++) {
				costs[x][y] = Integer.parseInt(input.get(y).charAt(x) + "");
			}
		}
		return runAStar(costs);
	}

	private Object runAStar(int[][] costs) {
		TreeSet<State> toCheck = new TreeSet<>();
		toCheck.add(new State(new Coordinate(0,0), null, costs.length + costs[0].length, 0));
		Set<Coordinate> checked = new HashSet<>();
		Coordinate target = new Coordinate(costs.length - 1, costs[0].length - 1);
		while(!toCheck.isEmpty()) {
			State s = toCheck.first();
			toCheck.remove(s);
			if(s.c.equals(target)) {
				return s.costSoFar;
			} else if(!checked.contains(s.c)) {
				checked.add(s.c);
				for (Coordinate n : s.c.getNeighbours()) {
					if (n.getX() >= 0 && n.getY() >= 0 && n.getX() < costs.length && n.getY() < costs[0].length) {
						if (!checked.contains(n)) {
							int costSoFar = s.costSoFar + costs[n.getX()][n.getY()];
							int estCost = costSoFar + (costs.length - n.getX() - 1) + (costs[0].length - n.getY() - 1);
							toCheck.add(new State(n, s, estCost, costSoFar));
						}
					}
				}
			}
		}
		return -1;
	}

	@Override
	public Object part2(List<String> input) {
		int inputWidth = input.get(0).length();
		int inputHeight = input.size();
		int[][] costs = new int[5 * inputWidth][5 * inputHeight];
		for(int xx = 0; xx < 5; xx++) {
			for(int yy = 0; yy < 5; yy++) {
				for(int x = 0; x < inputWidth; x++) {
					for(int y = 0; y < inputHeight; y++) {
						int c = Integer.parseInt(input.get(y).charAt(x) + "") - 1;
						c += xx+yy;
						c %= 9;
						c += 1;
						costs[xx * inputWidth + x][yy * inputHeight + y] = c;
					}
				}
			}
		}
		return runAStar(costs);
	}

	private static class State implements Comparable {
		private Coordinate c;
		private State parent;
		private int estCost;
		private int costSoFar;

		public State(Coordinate c, State parent, int estCost, int costSoFar) {
			this.c = c;
			this.estCost = estCost;
			this.costSoFar = costSoFar;
			this.parent = parent;
		}

		@Override
		public int compareTo(Object o) {
			if(!(o instanceof State)) {
				return 0;
			}
			State s = (State) o;
			int i = Integer.compare(estCost, s.estCost);
			if(i == 0) {
				i = Integer.compare(c.getX(), s.c.getX());
				if(i == 0) {
					i = Integer.compare(c.getY(), s.c.getY());
				}
			}
			return i;
		}
	}
}
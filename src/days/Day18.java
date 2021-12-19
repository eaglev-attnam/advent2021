package days;

import common.Pair;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Day18 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 18;
	}

	@Override
	public Object part1(List<String> input) {
		Number n = getNumber(input.get(0));
		System.out.println(n);
		for(int i = 1; i < input.size(); i++) {
			n = new PairNumber(n, getNumber(input.get(i)));
			simplify(n);
			System.out.println(n);
		}
		return n.getValue();
	}

	@Override
	public Object part2(List<String> input) {
		int best = 0;
		for(int i = 0; i < input.size(); i++) {
			for(int j = 0; j < input.size(); j++) {
				if(i != j) {
					Number n = new PairNumber(getNumber(input.get(i)), getNumber(input.get(j)));
					simplify(n);
					best = Math.max(best, n.getValue());
				}
			}
		}
		return best;
	}

	private Number simplify(Number n) {
		boolean changed = true;
		while(changed) {
			changed = false;

			// Explode
			while(n.shouldExplode(0)) {
				n.explode(0);
				changed = true;
			}

			// Split
			if(n.shouldSplit()) {
				n.split();
				changed = true;
			}
		}
		return n;
	}

	private Number getNumber(String number) {
		if(number.startsWith("[")) {
			int i = 1;
			int brackets = 0;
			while(brackets > 0 || number.charAt(i) != ',') {
				if(number.charAt(i) == '[') {
					brackets++;
				} else if(number.charAt(i) == ']') {
					brackets--;
				}
				i++;
			}
			Number a = getNumber(number.substring(1, i));
			Number b = getNumber(number.substring(i+1, number.length() - 1));
			return new PairNumber(a, b);
		} else {
			return new SimpleNumber(Integer.parseInt(number));
		}
	}

	private abstract class Number {
		int depth;

		abstract int getValue();
		abstract boolean shouldExplode(int depth);
		abstract Pair<Integer, Integer> explode(int depth);
		abstract void addLeft(int i);
		abstract void addRight(int i);
		abstract boolean shouldSplit();
		abstract Number split();
	}

	private class PairNumber extends Number {
		Number a;
		Number b;
		boolean exploded = false;

		private PairNumber(Number a, Number b) {
			this.a = a;
			this.b = b;
		}

		@Override
		int getValue() {
			return 3 * a.getValue() + 2 * b.getValue();
		}

		@Override
		boolean shouldExplode(int depth) {
			return depth >= 4 || a.shouldExplode(depth+1) || b.shouldExplode(depth+1);
		}

		@Override
		Pair<Integer, Integer> explode(int depth) {
			if(depth >= 4 && a instanceof SimpleNumber && b instanceof SimpleNumber) {
				exploded = true;
				return new Pair<>(a.getValue(), b.getValue());
			} else {
				if(a.shouldExplode(depth + 1)) {
					Pair<Integer, Integer> explosion = a.explode(depth + 1);
					b.addLeft(explosion.getB());
					if (((PairNumber) a).exploded) {
						a = new SimpleNumber(0);
					}
					return new Pair<>(explosion.getA(), 0);
				} else if(b.shouldExplode(depth + 1)) {
					Pair<Integer, Integer> explosion = b.explode(depth + 1);
					a.addRight(explosion.getA());
					if (((PairNumber) b).exploded) {
						b = new SimpleNumber(0);
					}
					return new Pair<>(0, explosion.getB());
				} else {
					return new Pair<>(0, 0);
				}
			}
		}

		@Override
		void addLeft(int i) {
			a.addLeft(i);
		}

		@Override
		void addRight(int i) {
			b.addRight(i);
		}

		@Override
		boolean shouldSplit() {
			return a.shouldSplit() || b.shouldSplit();
		}

		@Override
		Number split() {
			if(a.shouldSplit()) {
				a = a.split();
			} else if(b.shouldSplit()) {
				b = b.split();
			}
			return this;
		}

		@Override
		public String toString() {
			return String.format("[%s,%s]", a, b);
		}
	}

	private class SimpleNumber extends Number {
		int value;

		private SimpleNumber(int value) {
			this.value = value;
		}

		@Override
		int getValue() {
			return value;
		}

		@Override
		boolean shouldExplode(int depth) {
			return false;
		}

		@Override
		Pair<Integer, Integer> explode(int depth) {
			return new Pair<>(0,0);
		}

		@Override
		void addLeft(int i) {
			value += i;
		}

		@Override
		void addRight(int i) {
			value += i;
		}

		@Override
		boolean shouldSplit() {
			return value >= 10;
		}

		@Override
		Number split() {
			int a = value / 2;
			int b = value - a;
			return new PairNumber(new SimpleNumber(a), new SimpleNumber(b));
		}

		@Override
		public String toString() {
			return value + "";
		}
	}
}
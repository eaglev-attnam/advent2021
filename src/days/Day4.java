package days;

import common.Coordinate;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 4;
	}
	
	@Override
	public Object part1(List<String> input) {
		List<Integer> pulls = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
		List<BingoCard> cards = new ArrayList<>();

		for(int i = 2; i < input.size(); i++) {
			int[][] card = new int[5][];
			for(int j = 0; j < 5; j++) {
				card[j] = Arrays.stream(input.get(i).trim().split(" +")).filter(s -> !s.isBlank()).map(Integer::parseInt).mapToInt(a -> a).toArray();
				i++;
			}
			cards.add(new BingoCard(card));
		}

		Optional<Integer> score = Optional.empty();
		int pull = 0;
		while(score.isEmpty()) {
			final int p = pull;
			for(BingoCard c : cards) {
				score = score.or(() -> c.winningScoreAfter(pulls.get(p)));
			}
			pull++;
		}
		return score.get();
 	}

	@Override
	public Object part2(List<String> input) {
		List<Integer> pulls = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).collect(Collectors.toList());
		List<BingoCard> cards = new ArrayList<>();

		for(int i = 2; i < input.size(); i++) {
			int[][] card = new int[5][];
			for(int j = 0; j < 5; j++) {
				card[j] = Arrays.stream(input.get(i).trim().split(" +")).filter(s -> !s.isBlank()).map(Integer::parseInt).mapToInt(a -> a).toArray();
				i++;
			}
			cards.add(new BingoCard(card));
		}

		int pull = 0;
		while(cards.size() > 1) {
			List<BingoCard> won = new ArrayList<>();
			for(BingoCard c : cards) {
				if(c.winningScoreAfter(pulls.get(pull)).isPresent()) {
					won.add(c);
				}
			}
			cards.removeAll(won);
			pull++;
		}
		Optional<Integer> score = Optional.empty();
		while(score.isEmpty()) {
			score = cards.get(0).winningScoreAfter(pulls.get(pull));
			pull++;
		}
		return score.get();
	}

	private class BingoCard {
		int[][] numbers;
		boolean[][] hits;
		Map<Integer, Coordinate> mapping = new HashMap<>();

		private BingoCard(int[][] numbers) {
			this.numbers = numbers;
			this.hits = new boolean[numbers.length][numbers.length];
			for(int x = 0; x < numbers.length; x++) {
				for (int y = 0; y < numbers.length; y++) {
					mapping.put(numbers[x][y], new Coordinate(x, y));
				}
			}
		}

		private Optional<Integer> winningScoreAfter(int pull) {
			if(!mapping.containsKey(pull)) {
				return Optional.empty();
			} else {
				Coordinate c = mapping.get(pull);
				hits[c.getX()][c.getY()] = true;
				boolean horizontal = true;
				boolean vertical = true;
				for(int i = 0; i < numbers.length; i++) {
					horizontal &= hits[i][c.getY()];
					vertical &= hits[c.getX()][i];
				}
				if(horizontal || vertical) {
					return Optional.of(getPlainScore() * pull);
				} else {
					return Optional.empty();
				}
			}
		}

		private Integer getPlainScore() {
			int score = 0;
			for(int x = 0; x < numbers.length; x++) {
				for (int y = 0; y < numbers.length; y++) {
					if(!hits[x][y]) {
						score += numbers[x][y];
					}
				}
			}
			return score;
		}
	}
}

package days;

import java.util.List;

public class Day6 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 6;
	}

	@Override
	public Object part1(List<String> input) {
		return countFish(80, input);
 	}

 	private long countFish(int days, List<String> input) {
		long[] fish = new long[7];
		long kids = 0;
		long babies = 0;
		int next = 0;
		for(String w : input.get(0).split(",")) {
			int i = Integer.parseInt(w);
			fish[i]++;
		}
		for(int i = 0; i < days; i++) {
			long newBabies = fish[i % 7];
			fish[i % 7] += kids;
			kids = babies;
			babies = newBabies;
		}
		long sum = kids + babies;
		for(int i = 0; i < 7; i++){
			sum += fish[i];
		}
		return sum;
	}

	@Override
	public Object part2(List<String> input) {
		return countFish(256, input);
	}
}
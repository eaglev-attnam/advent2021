package days;

import java.util.List;
import java.util.stream.Collectors;

public class Day1 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 1;
	}
	
	@Override
	public Object part1(List<String> input) {
		int last = Integer.MAX_VALUE;
		int deeper = 0;
		for(String s: input) {
			int c = Integer.parseInt(s);
			if(c > last) {
				deeper++;
			}
			last = c;
		}
		return deeper;
	}

	@Override
	public Object part2(List<String> input) {
		List<Integer> depths = input.stream().map(Integer::parseInt).collect(Collectors.toList());
		int last = depths.get(0) + depths.get(1) + depths.get(2);
		int deeper = 0;
		for(int i = 0; i + 3 < depths.size(); i++) {
			int current = last - depths.get(i) + depths.get(i+3);
			if(current > last) {
				deeper++;
			}
			last = current;
		}
		return deeper;
	}
}

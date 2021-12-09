package days;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day7 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 7;
	}

	@Override
	public Object part1(List<String> input) {
		List<Integer> sorted = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
		int median = sorted.get(sorted.size() / 2);
		return sorted.stream().map(a -> Math.abs(a - median)).reduce(Integer::sum).orElseThrow();
 	}
	@Override
	public Object part2(List<String> input) {
		List<Integer> sorted = Arrays.stream(input.get(0).split(",")).map(Integer::parseInt).sorted().collect(Collectors.toList());
		int median = sorted.get(sorted.size() / 2);
		int mfc = getExponentialFuelCost(sorted, median);
		int d = 1;
		if(getExponentialFuelCost(sorted, median - 1) < mfc) {
			d = -1;
		}
		int current = mfc;
		int next = getExponentialFuelCost(sorted, median + d);
		while(next < current) {
			median += d;
			current = next;
			next = getExponentialFuelCost(sorted, median + d);
		}
		return current;
	}

	private int getExponentialFuelCost(List<Integer> crabs, int meeting) {
		return crabs.stream().map(a -> Math.abs(a - meeting)).map(a -> ((a+1) * a) / 2).reduce(Integer::sum).orElseThrow();
	}
}
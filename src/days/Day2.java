package days;

import java.util.List;

public class Day2 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 2;
	}
	
	@Override
	public Object part1(List<String> input) {
		int down = 0;
		int forward = 0;
		for(String s : input) {
			String[] words = s.split(" ");
			if("forward".equals(words[0])) {
				forward += Integer.parseInt(words[1]);
			} else if("down".equals(words[0])) {
				down += Integer.parseInt(words[1]);
			} else if("up".equals(words[0])) {
				down -= Integer.parseInt(words[1]);
			} else {
				throw new IllegalArgumentException();
			}
		}
		return down * forward;
	}

	@Override
	public Object part2(List<String> input) {
		int down = 0;
		int forward = 0;
		int aim = 0;
		for(String s : input) {
			String[] words = s.split(" ");
			if("forward".equals(words[0])) {
				int n = Integer.parseInt(words[1]);
				forward += n;
				down += n * aim;
			} else if("down".equals(words[0])) {
				aim += Integer.parseInt(words[1]);
			} else if("up".equals(words[0])) {
				aim -= Integer.parseInt(words[1]);
			} else {
				throw new IllegalArgumentException();
			}
		}
		return down * forward;
	}
}

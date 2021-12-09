package days;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Day8 extends Day {

	@Override
	protected int getChallengeNumber() {
		return 8;
	}

	@Override
	public Object part1(List<String> input) {
		int sum = 0;
		for(String s : input) {
			String[] parts = s.split(" \\| ");
			String[] active = parts[1].split(" ");
			for(String a : active) {
				int l = a.length();
				if(l == 2 || l == 3 || l == 4 || l == 7) {
					sum++;
				}
			}
		}
		return sum;
 	}

	/**
	 *  aa
	 * b  c
	 * b  c
	 *  dd
	 * e  f
	 * e  f
	 *  gg
	 *
	 * CF in 1
	 * BD in 4 but not 1
	 * We know 1, 7, 4, 8
	 * OF THE SIX SEGMENT DIGITS:
	 * 0 misses one of BD
	 * 6 misses one of CF
	 * 9 misses another
	 * OF THE FIVE SEGMENT DIGITS:
	 * 5 is UNION 6/9
	 * 2 has E which is not in 9
	 * 3 is left
	 */

	@Override
	public Object part2(List<String> input) {
		int sum = 0;
		for(String s : input) {
			String[] parts = s.split(" \\| ");
			String[] digits = new String[10];
			String[] defs = parts[0].split(" ");
			for(String d : defs) {
				int l = d.length();
				if(l == 2) {
					digits[1] = sorted(d);
				} else if(l == 3) {
					digits[7] = sorted(d);
				} else if(l == 4) {
					digits[4] = sorted(d);
				} else if(l == 7) {
					digits[8] = sorted(d);
				}
			}
			for(String d : defs) {
				int l = d.length();
				if(l == 6) {
					if(!d.contains(digits[1].substring(0,1)) || !d.contains(digits[1].substring(1))) {
						// Missing one of CF
						digits[6] = sorted(d);
					} else if(!d.contains(digits[4].substring(0,1))
							|| !d.contains(digits[4].substring(1,2))
							|| !d.contains(digits[4].substring(2,3))
							|| !d.contains(digits[4].substring(3))) {
						// Missing one of BDCF
						digits[0] = sorted(d);
					} else {
						// Missing another
						digits[9] = sorted(d);
					}
				}
			}
			for(String d : defs) {
				int l = d.length();
				if(l == 5) {
					boolean subsetOf6 = digits[6].contains(d.substring(0,1)) &&
							digits[6].contains(d.substring(1,2)) &&
							digits[6].contains(d.substring(2,3)) &&
							digits[6].contains(d.substring(3,4)) &&
							digits[6].contains(d.substring(4));
					boolean subsetOf9 = digits[9].contains(d.substring(0,1)) &&
							digits[9].contains(d.substring(1,2)) &&
							digits[9].contains(d.substring(2,3)) &&
							digits[9].contains(d.substring(3,4)) &&
							digits[9].contains(d.substring(4));
					if(subsetOf6 && subsetOf9) {
						digits[5] = sorted(d);
					} else if(subsetOf9) {
						digits[3] = sorted(d);
					} else {
						digits[2] = sorted(d);
					}
				}
			}

			int total = 0;
			for(String digit : parts[1].split(" ")) {
				int d = -1;
				String sorted = sorted(digit);
				int i = 0;
				while(!digits[i].equals(sorted)) {
					i++;
				}
				total *= 10;
				total += i;
			}
			sum += total;
		}
		return sum;
	}

	private String sorted(String d) {
		char[] c = d.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}
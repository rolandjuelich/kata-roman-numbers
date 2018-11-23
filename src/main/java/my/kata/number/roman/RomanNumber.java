package my.kata.number.roman;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.beust.jcommander.internal.Lists;

public class RomanNumber {

	public static String convert(int number) {

		TreeMap<Integer, String> ciphers = new TreeMap<Integer, String>();
		ciphers.put(1, "I");
		ciphers.put(5, "V");
		ciphers.put(10, "X");
		ciphers.put(50, "L");
		ciphers.put(100, "C");
		ciphers.put(500, "D");
		ciphers.put(1000, "M");

		List<Integer> numbers = Lists.newArrayList(ciphers.keySet());
		Collections.reverse(numbers);

		if (number <= 1) {
			if (number < 1) {
				return null;
			}
			return ciphers.get(1);
		}

		if (number <= 10) {
			if (number <= (10 / 2)) {
				if (number < (10 / 2) - 1) {
					return convert(1) + convert(number - 1);
				}
				if (number == (10 / 2) - 1) {
					return convert(1) + convert((10 / 2));
				}
				if (number == (10 / 2)) {
					return ciphers.get((10 / 2));
				}
				return convert((10 / 2) - 1) + convert(number - ((10 / 2) - 1));
			}
			if (number < 10 - 1) {
				return convert((10 / 2)) + convert(number - (10 / 2));
			}
			if (number == 10 - 1) {
				return convert(1) + convert(10);
			}
			if (number == 10) {
				return ciphers.get(10);
			}
			return convert(10 - 1) + convert(number - (10 - 1));
		}

		if (number <= 100) {
			if (number <= (100 / 2)) {
				if (number < (100 / 2) - 10) {
					return convert(10) + convert(number - 10);
				}
				if (number == (100 / 2) - 10) {
					return convert(10) + convert((100 / 2));
				}
				if (number == (100 / 2)) {
					return ciphers.get((100 / 2));
				}
				return convert((100 / 2) - 10) + convert(number - ((100 / 2) - 10));
			}
			if (number < 100 - 10) {
				return convert((100 / 2)) + convert(number - (100 / 2));
			}
			if (number == 100 - 10) {
				return convert(10) + convert(100);
			}
			if (number == 100) {
				return ciphers.get(100);
			}
			return convert(100 - 10) + convert(number - (100 - 10));
		}

		if (number <= 1000) {
			if (number <= (1000 / 2)) {
				if (number < (1000 / 2) - 100) {
					return convert(100) + convert(number - 100);
				}
				if (number == (1000 / 2) - 100) {
					return convert(100) + convert((1000 / 2));
				}
				if (number == (1000 / 2)) {
					return ciphers.get((1000 / 2));
				}
				return convert((1000 / 2) - 100) + convert(number - ((1000 / 2) - 100));
			}
			if (number < 1000 - 100) {
				return convert((1000 / 2)) + convert(number - (1000 / 2));
			}
			if (number == 1000 - 100) {
				return convert(100) + convert(1000);
			}
			if (number == 1000) {
				return ciphers.get(1000);
			}
			return convert(1000 - 100) + convert(number - (1000 - 100));
		}

		return convert(1000) + convert(number - 1000);
	}

}

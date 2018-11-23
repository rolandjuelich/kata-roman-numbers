package my.kata.number.roman;

import java.util.TreeMap;

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

		if (number <= 1) {
			if (number < 1) {
				return null;
			}
			return ciphers.get(1);
		}

		for (int i = 10; i <= 1000; i *= 10) {
			if (number <= i) {
				if (number <= (i / 2)) {
					if (number < (i / 2) - (i / 10)) {
						return convert((i / 10)) + convert(number - (i / 10));
					}
					if (number == (i / 2) - (i / 10)) {
						return convert((i / 10)) + convert((i / 2));
					}
					if (number == (i / 2)) {
						return ciphers.get((i / 2));
					}
					return convert((i / 2) - (i / 10)) + convert(number - ((i / 2) - (i / 10)));
				}
				if (number < i - (i / 10)) {
					return convert((i / 2)) + convert(number - (i / 2));
				}
				if (number == i - (i / 10)) {
					return convert((i / 10)) + convert(i);
				}
				if (number == i) {
					return ciphers.get(i);
				}
				return convert(i - (i / 10)) + convert(number - (i - (i / 10)));
			}
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

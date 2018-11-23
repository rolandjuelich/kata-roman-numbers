package my.kata.number.roman;

import java.util.TreeMap;

public class RomanNumber {

	public static String convert(int number) {

		if (number < 1) {
			return null;
		}

		for (int i = 1; i <= 1000; i *= 10) {
			int n = i == 1 ? 0 : i / 2;
			int m = i == 1 ? 1 : i / 10;

			if (number < n - m) {
				return convert(number, m);
			}
			if (number <= n) {
				return convert(number, n, m);
			}
			if (number < i - m) {
				return convert(number, n);
			}
			if (number <= i) {
				return convert(number, i, m);
			}

		}

		return convert(number, 1000);
	}

	private static String convert(int number, int i, int m) {
		if (number == i - m) {
			return convert(m) + convert(i);
		}
		if (number == i) {
			return ciphers().get(i);
		}
		return convert(number, (i - m));
	}

	private static String convert(int number, int m) {
		return convert(m) + convert(number - m);
	}

	private static TreeMap<Integer, String> ciphers() {
		TreeMap<Integer, String> ciphers = new TreeMap<Integer, String>();
		ciphers.put(1, "I");
		ciphers.put(5, "V");
		ciphers.put(10, "X");
		ciphers.put(50, "L");
		ciphers.put(100, "C");
		ciphers.put(500, "D");
		ciphers.put(1000, "M");
		return ciphers;
	}

}

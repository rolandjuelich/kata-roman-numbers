package my.kata.number.roman;

import java.util.TreeMap;

public class RomanNumber {

	public static String convert(int number) {

		if (number <= 1) {
			if (number < 1) {
				return null;
			}
			return ciphers().get(1);
		}

		for (int i = 10; i <= 1000; i *= 10) {
			int n = i / 2;
			int m = i / 10;

			if (number < n - m) {
				return convert(m) + convert(number - m);
			}
			if (number <= n) {
				if (number == n - m) {
					return convert(m) + convert(n);
				}
				if (number == n) {
					return ciphers().get(n);
				}
				return convert(n - m) + convert(number - (n - m));
			}
			
			if (number < i - m) {
				return convert(n) + convert(number - n);
			}
			if (number <= i) {
				if (number == i - m) {
					return convert(m) + convert(i);
				}
				if (number == i) {
					return ciphers().get(i);
				}
				return convert(i - m) + convert(number - (i - m));
			}
			
		}

		return convert(1000) + convert(number - 1000);
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

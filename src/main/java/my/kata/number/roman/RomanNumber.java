package my.kata.number.roman;

import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import com.beust.jcommander.internal.Lists;

public class RomanNumber {

	public static String convert(int number) {

		if (number < 1) {
			return null;
		}

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

		if (number < 20) {
			for (Integer arabic : numbers) {
				if (number >= arabic - 1) {
					if (number < arabic) {
						return convert(1) + convert(arabic);
					}
					if (number == arabic) {
						return ciphers.get(arabic);
					}
					return convert(arabic) + convert(number - arabic);
				}
			}
		}

		if (number < 40) {
			for (Integer arabic : numbers) {
				if (number >= arabic - 10) {
					if (number < arabic) {
						return convert(10) + convert(arabic);
					}
					if (number == arabic) {
						return ciphers.get(arabic);
					}
					return convert(arabic) + convert(number - arabic);
				}
			}
		}

		if (number < 90) {
			if (number < 50) {
				if (number == 50 - 10) {
					return convert(10) + convert(50);
				}
				if (number > (50 - 10)) {
					return convert(50 - 10) + convert(number - (50 - 10));
				}
			}
			if (number == 50) {
				return ciphers.get(50);
			}
			if (number > 50) {
				return convert(50) + convert(number - 50);
			}
		}

		if (number <= 100) {
			if (number == 90) {
				return convert(10) + convert(100);
			}
			if (number == 100) {
				return ciphers.get(100);
			}
			return convert(90) + convert(number - 90);
		}

		if (number <= 400) {
			if (number == 400) {
				return convert(100) + convert(500);
			}
			return convert(100) + convert(number - 100);
		}

		if (number < 500) {
			return convert(400) + convert(number - 400);
		}

		if (number == 500) {
			return ciphers.get(500);
		}

		if (number < 900) {
			return convert(500) + convert(number - 500);
		}

		if (number == 900) {
			return convert(100) + convert(1000);
		}

		if (number == 1000) {
			return ciphers.get(1000);
		}
		if (number < 1000) {
			return convert(900) + convert(number - 900);
		}
		if (number > 1000) {
			return convert(1000) + convert(number - 1000);
		}

		return null;
	}

}

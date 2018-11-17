package my.kata.number.roman;

import static java.lang.Integer.valueOf;
import static java.nio.charset.Charset.defaultCharset;
import static org.apache.commons.io.FileUtils.readLines;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;

@RunWith(Parameterized.class)
public class RomanNumberAcceptanceTest {

	@Parameter(0)
	public Integer arabic;

	@Parameter(1)
	public String roman;

	@Parameters(name = "{0} => \"{1}\"")
	public static Collection<Object[]> data() throws IOException {
		final File file = new File("src/test/resources", "testdata3000.csv");
		final Collection<Object[]> examples = Lists.newArrayList();
		readLines(file, defaultCharset()).forEach(line -> {
			final String[] split = line.split(",");
			final Integer arabic = valueOf(split[0].trim());
			final String roman = split[1].trim();
			examples.add(new Object[] { arabic, roman });
		});
		return examples;
	}

	@Test
	public void shouldConvertArabicToRomanNumber() {
		// given
		final int given = arabic;
		final String expected = roman;

		// when
		final String actual = convert(given);

		// then
		assertThat(actual).isEqualTo(expected);
	}

	private String convert(int number) {
		return null;
	}

}

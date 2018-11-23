package my.kata.number.roman;

import java.util.ArrayList;
import java.util.List;

import org.approvaltests.Approvals;
import org.junit.Test;

/**
 * @see <a href=
 *      "https://github.com/approvals/ApprovalTests.Java#examples">ApprovalTests
 *      on Github</a>
 */
public class RomanNumberUnitTest {

	@Test
	public void shouldConvertArabicToRomanNumber() {

		final List<String> romanNumbers = new ArrayList<String>();

		for (int i = 0; i <= 3000; i++) {
			romanNumbers.add(RomanNumber.convert(i));
		}

		Approvals.verifyAll("", romanNumbers);
	}

}

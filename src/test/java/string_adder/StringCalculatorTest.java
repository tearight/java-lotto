package string_adder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void setUp() {
		stringCalculator = new StringCalculator();
	}

	@Test
	void sum_null() {
		assertThat(stringCalculator.sum(null)).isEqualTo(0);
	}

	@Test
	void sum_빈문자열() {
		assertThat(stringCalculator.sum("")).isEqualTo(0);
	}

	@ParameterizedTest
	@CsvSource(value = {"0=0", "1=1", "999=999"}, delimiter = '=')
	void sum_숫자한개(String number, int expected) {
		assertThat(stringCalculator.sum(number)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,1=1", "2,999=1001"}, delimiter = '=')
	void sum_숫자두개(String twoNumbers, int expected) {
		assertThat(stringCalculator.sum(twoNumbers)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"0,1,2=3", "2,1,0,5,1000=1008"}, delimiter = '=')
	void sum_숫자여러개(String multipleNumbers, int expected) {
		assertThat(stringCalculator.sum(multipleNumbers)).isEqualTo(expected);
	}

}

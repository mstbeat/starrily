package starrily.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import starrily.annotation.NonExistentDay;

public class NonExistentDayValidation implements ConstraintValidator<NonExistentDay, String> {

	/**
	 * 最初に呼ばれるメソッド.
	 */
	@Override
	public void initialize(NonExistentDay nonExistentDay) {
	}

	/**
	 * 存在しない日なのかチェック
	 */
	@Override
	public boolean isValid(String input, ConstraintValidatorContext cxt) {

		if (input.isEmpty()) {
			return true;
		}

		try {
			LocalDate.parse(input.replace('/', '-'),
					DateTimeFormatter.ofPattern("uuuu-MM-dd").withResolverStyle(ResolverStyle.STRICT));
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}

}

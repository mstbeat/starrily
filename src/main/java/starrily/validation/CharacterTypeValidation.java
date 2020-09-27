package starrily.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import starrily.annotation.CharacterType;

public class CharacterTypeValidation implements ConstraintValidator<CharacterType, String[]> {

	@Override
	public void initialize(CharacterType characterType) {

	}

	@Override
	public boolean isValid(String[] input, ConstraintValidatorContext cxt) {

		for (String s : input) {
			if (!(s.matches("^[\\p{Alnum}|\\p{Punct}]*$"))) {
				return false;
			}
		}
		return true;
	}

}

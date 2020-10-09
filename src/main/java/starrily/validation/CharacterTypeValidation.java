package starrily.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import starrily.annotation.CharacterType;

public class CharacterTypeValidation implements ConstraintValidator<CharacterType, String[]> {

	/**
	 * 最初に呼ばれるメソッド.
	 */
	@Override
	public void initialize(CharacterType characterType) {
	}
	/**
	 * 全角、半角カナチェック
	 */
	@Override
	public boolean isValid(String[] input, ConstraintValidatorContext cxt) {

		for (String check : input) {
			if (!(check.matches("^[\\p{Alnum}|\\p{Punct}]*$"))) {
				return false;
			}
		}
		return true;
	}

}

package starrily.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import starrily.annotation.ArraySize;

/**
 * 配列の文字数をチェックするバリデーションクラス.
 * @author tateyahajime
 *
 */
public class ArraySizeValidation implements ConstraintValidator<ArraySize, String[]> {

	/**
	 * 文字数最大サイズ.
	 */
	private int size;

	/**
	 * 最初に動くメソッド(sizeに渡ってきた20の値を代入).
	 */
	@Override
	public void initialize(ArraySize arraySize) {
		this.size = arraySize.size();
	}

	/**
	 * 文字数チェックメソッド.
	 * @return false バリデーションエラー true　エラーなし
	 */
	@Override
	public boolean isValid(String[] input, ConstraintValidatorContext cxt) {
		for (String s : input) {
			if (s.length() > size) {
				return false;
			}
		}
		return true;
	}

}

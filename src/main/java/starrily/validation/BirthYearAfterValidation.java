package starrily.validation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import starrily.annotation.BirthYearAfter;

/**
 * 生年月日が現在の年以降のバリデーション.
 * @author Masato Yasuda
 */
public class BirthYearAfterValidation implements ConstraintValidator<BirthYearAfter, Date> {

	/** 現在の年の設定 */
	private String year;

	/**
	 * 初期化処理
	 * @param annotation アノテーション
	 */
	@Override
	public void initialize(BirthYearAfter annotation) {
		year = annotation.year();
	}

	/**
	 * 生年月日が現在の年より後の場合はエラー
	 * @param userBirthday 生年月日
	 * @param context コンテキスト
	 * @return 制約を満たす場合はtrue、満たさない場合はfalse
	 */
	@Override
	public boolean isValid(Date userBirthday, ConstraintValidatorContext context) {
		if (userBirthday != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(java.sql.Date.valueOf(year + "-01-01"));
			calendar.add(Calendar.YEAR, 1);
			if (!userBirthday.before(calendar.getTime())) {
				return false;
			}
		}
		return true;
	}
}

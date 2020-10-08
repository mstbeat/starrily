package starrily.validation;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import starrily.annotation.BirthYearBefore;

/**
 * 生年月日が1950年以前のバリデーション.
 * @author Masato Yasuda
 */
public class BirthYearBeforeValidation implements ConstraintValidator<BirthYearBefore, Date> {

	/** 過去の年（1950年）の設定 */
	private String year;

	/**
	 * 初期化処理
	 * @param annotation アノテーション
	 */
	@Override
	public void initialize(BirthYearBefore annotation) {
		year = annotation.year();
	}

	/**
	 * 生年月日が1950年より前の場合はエラー
	 * @param userBirthday 生年月日
	 * @param context コンテキスト
	 * @return 制約を満たす場合はtrue、満たさない場合はfalse
	 */
	@Override
	public boolean isValid(Date userBirthday, ConstraintValidatorContext context) {
		if (userBirthday != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(java.sql.Date.valueOf(year + "-12-31"));
			calendar.add(Calendar.YEAR, -1);
			if (!userBirthday.after(calendar.getTime())) {
				return false;
			}
		}
		return true;
	}
}

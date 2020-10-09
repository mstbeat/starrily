package starrily.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import starrily.validation.NonExistentDayValidation;

@Constraint(validatedBy = NonExistentDayValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface NonExistentDay {

	/**
	 * バリデーションのメッセージメソッド.
	 * @return エラーメッセージ
	 */
	String message() default "{EMSG002}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}

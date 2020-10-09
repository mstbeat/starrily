package starrily.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import starrily.validation.BirthYearAfterValidation;

/**
 * 生年月日が現在の年以降のバリデーションのアノテーション設定.
 * @author Masato Yasuda
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = BirthYearAfterValidation.class)
public @interface BirthYearAfter {

	String message() default "{EMSG108}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String year();
}

package starrily.annotation;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import starrily.validation.BirthYearBeforeValidation;

/**
 * 生年月日が1950年以前のバリデーションのアノテーション設定.
 * @author Masato Yasuda
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = BirthYearBeforeValidation.class)
public @interface BirthYearBefore {

	String message() default "{EMSG109}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String year();
}

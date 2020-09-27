package starrily.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import starrily.validation.ArraySizeValidation;

/**
 * 配列のサイズをチェックするアノテーションクラス.
 * @author tateyahajime
 *
 */
@Constraint(validatedBy = ArraySizeValidation.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ArraySize {

	/**
	 * 埋め込み文字{1}、桁数{1}を入力するメソッド.
	 * @return 埋め込み文字、桁数
	 */
	String PADCH();

	/**
	 * 最大サイズの数字を取得メソッド.
	 * @return 最大サイズ
	 */
	int size();

	/**
	 * バリデーションのメッセージメソッド.
	 * @return エラーメッセージ
	 */
	String message() default "{EMSG006}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};


}

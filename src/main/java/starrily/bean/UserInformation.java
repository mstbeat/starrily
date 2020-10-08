package starrily.bean;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;
import starrily.validation.UserInfoGroup;
import starrily.validation.UserInformationGroup;

@Data
public class UserInformation implements Serializable {

	/** シリアルバージョンUID. */
	private static final long serialVersionUID = 7783915365374534702L;

	/** ユーザーID */
	private int userId;

	/** パスワード */
	private String password;

	/** 権限 */
	private String authority;

	/** 権限 (int型)*/
	private int authorityInt;

	/** 事業部 */
	private String division;

	/** 会社名 */
	private String companyName;

	/** 担当営業 */
	private String salesRepresentative;

	/** 稼働状況 */
	private String operationStatus;

	/** メールアドレス */
	@NotBlank(message = "{EMSG001}" , groups = {UserInfoGroup.class})
	@Pattern(regexp = "^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]*$", message = "{EMSG011}" , groups = {UserInfoGroup.class})
	private String userMail;

	/** 氏名 */
	 @NotBlank(message="{EMSG001}" , groups = {UserInformationGroup.class , UserInfoGroup.class})
	 @Size(max=20,message="{EMSG003}" , groups = {UserInformationGroup.class, UserInfoGroup.class})
	 @Pattern(regexp = "^[あ-ん]*$", message="{EMSG010}" ,groups = {UserInformationGroup.class})
	private String userName;

	/** フリガナ */
	@NotBlank(message = "{EMSG001}" , groups = {UserInfoGroup.class})
	@Size(max = 20, message = "{EMSG003}" , groups = {UserInfoGroup.class})
	private String userPhonetic;

	/** 最終ログイン日時 */
	private String userLastLogin;

	/** 登録日時 */
	private String registeredDate;

	/** 更新日時 */
	private String updateDate;

	/** 削除フラグ */
	private String deleteFlg;

	/** 全てのスキル*/
	private String allSkill;
}
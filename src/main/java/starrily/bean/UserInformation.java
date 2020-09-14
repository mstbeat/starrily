package starrily.bean;

import java.io.Serializable;

import lombok.Data;

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
	/** 事業部 */
	private String division;
	/** 会社名 */
	private String companyName;
	/** 担当営業 */
	private String salesRepresentative;
	/** 稼働状況 */
	private String operationStatus;
	/** メールアドレス */
	private String userMail;
	/** 氏名 */
	private String userName;
	/** フリガナ */
	private String userPhonetic;
	/** 最終ログイン日時 */
	private String userLastLogin;
	/** 登録日時 */
	private String registeredDate;
	/** 更新日時 */
	private String updateDate;
	/** 削除フラグ */
	private String deleteFlg;

}
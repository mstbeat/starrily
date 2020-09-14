package starrily.bean;

import java.io.Serializable;
import java.sql.Date;

import lombok.Data;

@Data
public class SkillSheet implements Serializable {

	/** シリアルバージョンUID. */
	private static final long serialVersionUID = -5549487585343137022L;

	/** DBの全ての情報　*/
	public String allDb;
	/** FwNwの全ての情報　*/
	public String allFwNw;
	/** Osの全ての情報　*/
	public String allOs;
	/** 言語の全ての情報　*/
	public String allLang;
	/** その他の全ての情報　*/
	public String allOther;

	/** 権限　*/
	private int userRole;
	/** ユーザーID */
	private int userId;
	/** 経歴ID */
	private int careerId;
	/** 氏名 */
	private String userName;
	/** フリガナ */
	private String userPhonetic;
	/** イニシャルネーム */
	private String userInitialName;
	/** 性別 */
	private String userSex;
	/** 生年月日 */
	private Date userBirthday;

	/** 最終学歴 */
	private String userFinalEducation;
	/** 現住所 */
	private String userAddress;
	/** 年齢のカラム */
	private int userAge;
	/** 最寄駅_線 */
	private String userStationLine;
	/** 最寄駅_駅 */
	private String userStation;
	/** アピールポイント */
	private String userAppeal;
	/** 保有資格 */
	private String userCertification;
	/** 備考 */
	private String userRemarks;
	/** 開始年月 */
	private String startDate;
	/** 終了年月 */
	private String finishDate;
	/** 期間 */
	private int periodDate;
	/** 業務名 */
	private String businessName;
	/** 業界 */
	private String industry;
	/** チーム人数 */
	private int teamNumber;
	/** ポジション */
	private String position;
	/** 担当フェーズ */
	private String chargePhase;
	/** 業務内容 */
	private String businessContent;

	/** データベース 名前＋バージョン */
	private String dbAll;
	/** データベース 名前 */
	private String db;
	/** データベース 名前 画面から配列で受け取る用. */
	private String[] dbArray;
	/** データベース バージョン */
	private String dbVer;
	/** データベース　バージョン 画面から配列で受け取る用. */
	private String[] dbVerArray;
	/** データベース 期間 */
	private int dbPeriod;

	/** FW_NW 名前＋バージョン */
	private String fwNwAll;
	/** FW_NW 名前 */
	private String fwNw;
	/** FW_NW 名前 画面から配列で受け取る用. */
	private String[] fwNwArray;
	/** FW_NW バージョン */
	private String fwNwVer;
	/** FW_NW バージョン 画面から配列で受け取る用. */
	private String[] fwNwVerArray;
	/** FW_NW 期間 */
	private int fwNwPeriod;

	/** 言語 名前＋バージョン */
	private String languageAll;
	/** 言語 名前 */
	private String language;
	/** 言語 名前 画面から配列で受け取る用. */
	private String[] languageArray;
	/** 言語 バージョン */
	private String languageVer;
	/** 言語 バージョン 画面から配列で受け取る用. */
	private String[] languageVerArray;
	/** 言語 期間 */
	private int languagePeriod;

	/** OS 名前＋バージョン */
	private String osAll;
	/** OS 名前 */
	private String os;
	/** os 名前　画面から配列で受け取る用 */
	private String[] osArray;
	/** OS バージョン */
	private String osVer;
	/**  os バージョン 画面から配列で受け取る用 */
	private String[] osVerArray;
	/** OS 期間 */
	private int osPeriod;

	/** その他 名前＋バージョン */
	private String otherAll;
	/** その他 名前 */
	private String other;
	/**  その他 名前 画面から配列で受け取る用*/
	private String[] otherArray;
	/** その他 バージョン */
	private String otherVer;
	/**  その他 バージョン 画面から配列で受け取る用*/
	private String[] otherVerArray;
	/** その他 期間 */
	private int otherPeriod;

	/** チーム人数(文字列) */
	private String teamNumberString;
	/** 担当フェーズ 画面からcontrollerへ渡す用.*/
	private String checkboxfaze;

	/** 登録日時 */
	private String registeredDate;
	/** 更新日時 */
	private String updateDate;
	/** 削除フラグ */
	private String deleteFlg;

}

package starrily.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import starrily.annotation.ArraySize;
import starrily.annotation.BirthYearAfter;
import starrily.annotation.BirthYearBefore;
import starrily.annotation.CharacterType;
import starrily.annotation.NonExistentDay;
import starrily.validation.SkillsheetGroup;

@Data
public class SkillSheet implements Serializable {

	/** シリアルバージョンUID. */
	private static final long serialVersionUID = -5549487585343137022L;

	/** DBの全ての情報 */
	public String allDb;
	/** FwNwの全ての情報 */
	public String allFwNw;
	/** Osの全ての情報 */
	public String allOs;
	/** 言語の全ての情報 */
	public String allLang;
	/** その他の全ての情報 */
	public String allOther;
	/** 権限 */
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
	@NotBlank(message = "{EMSG001}" , groups = {SkillsheetGroup.class})
	@Pattern(regexp = "[a-zA-Z0-9.]*", message = "{EMSG005}", groups = {SkillsheetGroup.class})
	@Size(max = 3, message = "{EMSG009}", groups = {SkillsheetGroup.class})
	private String userInitialName;

	/** 性別 */
	@NotBlank(message = "{EMSG001}" ,groups = {SkillsheetGroup.class})
	private String userSex;

	/** 生年月日 */
	@NotNull(message = "{EMSG001}", groups = {SkillsheetGroup.class})
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@BirthYearAfter(year = "2020", groups = {SkillsheetGroup.class})
	@BirthYearBefore(year = "1950",groups = {SkillsheetGroup.class})
	private Date userBirthday;

	/** 最終学歴 */
	private String userFinalEducation;

	/** 現住所 */
	@NotBlank(message = "{EMSG001}", groups = {SkillsheetGroup.class})
	@Size(max = 20, message = "{EMSG003}", groups = {SkillsheetGroup.class})
	private String userAddress;

	/** 年齢のカラム */
	private int userAge;
	/** 最寄駅_線 */
	@NotBlank(message = "{EMSG001}", groups = {SkillsheetGroup.class})
	@Size(max = 20, message = "{EMSG003}", groups = {SkillsheetGroup.class})
	private String userStationLine;
	/** 最寄駅_駅 */
	@NotBlank(message = "{EMSG001}", groups = {SkillsheetGroup.class})
	@Size(max = 20, message = "{EMSG003}", groups = {SkillsheetGroup.class})
	private String userStation;
	/** アピールポイント */
	@NotBlank(message = "{EMSG001}", groups = {SkillsheetGroup.class})
	@Size(max = 1000, message = "{EMSG003}", groups = {SkillsheetGroup.class})
	private String userAppeal;
	/** 保有資格 */
	@Size(max = 1000, message = "{EMSG003}", groups = {SkillsheetGroup.class})
	private String userCertification;
	/** 備考 */
	@Size(max = 500, message = "{EMSG003}", groups = {SkillsheetGroup.class})
	private String userRemarks;
	/** 開始年月 */
	@NotBlank(message="{EMSG001}")
	@NonExistentDay
	private String startDate;
	@AssertTrue(message="{EMSG107}")
	public boolean checkFinishiDate() {
		if (finishDate.isEmpty()) {
			return true;
		}
		if (finishDate.compareTo(startDate) < 0) {
			return false;
		} else {
			return true;
		}
	}
	/** 終了年月 */
	@NonExistentDay
	private String finishDate;
	/** 終了年月が開始年月より過去日になっていないかチェック */
	@AssertTrue(message="{EMSG107}")
	public boolean isDateValid() {
		if (finishDate.isEmpty()) {
			return true;
		}
		if (finishDate.compareTo(startDate) < 0) {
			return false;
		} else {
			return true;
		}
	}
	/** 期間 */
	private int periodDate;
	/** 業務名 */
	@Size(max=100, message="{EMSG003}")
	@NotBlank(message="{EMSG001}")
	private String businessName;
	/** 業界 */
	@Size(max=20, message="{EMSG003}")
	private String industry;
	/** チーム人数 */
	private int teamNumber;
	/** チーム人数 画面からcontrollerへ渡す用. */
	@Size(max=4, message="{EMSG003}")
	@Pattern(regexp = "^[0-9]*$", message="{EMSG004}")
	private String teamNumberString;
	/** ポジション */
	private String position;

	/** 担当フェーズ */
	private String chargePhase;

	/** 業務内容 */
	@Size(max=1000, message="{EMSG003}")
	private String businessContent;

	/** データベース 名前＋バージョン */
	private String dbAll;
	/** データベース 名前 */
	@Size(max = 20, message = "{EMSG003}")
	private String db;
	/** データベース 名前(プルダウン)画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}")
	private String[] dbPulArray;
	/** データベース 名前 画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}", PADCH="20")
	private String[] dbArray;
	/** データベース バージョン */
	private String dbVer;
	/** データベース バージョン(プルダウン) 画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] dbVerPulArray;
	/** データベース　バージョン 画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] dbVerArray;
	/** データベース 期間 */
	private int dbPeriod;
	/** FW_NW 名前＋バージョン */
	private String fwNwAll;
	/** FW_NW 名前 */
	private String fwNw;
	/** FW_NW 名前 画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}", PADCH="20")
	private String[] fwNwArray;
	/** FW_NW バージョン */
	private String fwNwVer;
	/** FW_NW バージョン 画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] fwNwVerArray;
	/** FW_NW 期間 */
	private int fwNwPeriod;

	/** 言語 名前＋バージョン */
	private String languageAll;
	/** 言語 名前 */
	private String language;
	/** 言語 名前(プルダウン)画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}")
	private String[] languagePulArray;
	/** 言語 名前 画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}", PADCH="20")
	private String[] languageArray;
	/** 言語 バージョン */
	private String languageVer;
	/** 言語 バージョン(プルダウン)画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] languageVerPulArray;
	/** 言語 バージョン 画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] languageVerArray;
	/** 言語 期間 */
	private int languagePeriod;

	/** OS 名前＋バージョン */
	private String osAll;
	/** OS 名前 */
	private String os;
	/** os 名前(プルダウン)画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}", size=20, PADCH="20")
	private String[] osPulArray;
	/** os 名前　画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}", PADCH="20")
	private String[] osArray;
	/** OS バージョン */
	private String osVer;
	/**  os バージョン(プルダウン)画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] osVerPulArray;
	/**  os バージョン 画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] osVerArray;
	/** OS 期間 */
	private int osPeriod;

	/** その他 名前＋バージョン */
	private String otherAll;
	/** その他 名前 */
	private String other;
	/** その他 名前 画面から配列で受け取る用. */
	@ArraySize(message="{EMSG003}", PADCH="20")
	private String[] otherArray;
	/** その他 バージョン */
	private String otherVer;
	/** その他 バージョン 画面から配列で受け取る用. */
	@CharacterType
	@ArraySize(PADCH="バージョン")
	private String[] otherVerArray;
	/** その他 期間 */
	private int otherPeriod;
	/** 登録日時 */
	private String registeredDate;
	/** 更新日時 */
	private String updateDate;
	/** 削除フラグ */
	private String deleteFlg;

	private String allSkill;

}

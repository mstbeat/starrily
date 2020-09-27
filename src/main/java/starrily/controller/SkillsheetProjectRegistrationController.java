package starrily.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import starrily.bean.SkillSheet;
import starrily.service.StarrilyService;

/**
 * 新規案件追加クラス
 *
 * @author yu.yamamoto
 * @version 1.0.0
 */
@Controller
public class SkillsheetProjectRegistrationController {

	// StarrilyServiceクラスのインスタンス化
	@Autowired
	StarrilyService service;

	@Autowired
	HttpSession session;

	/**
	 * ValidationMessagesの情報を扱えるようになる
	 */
	@Autowired
	MessageSource messageSource;

	/**
	 * ValidationMessagesから情報を取得.
	 */
	MessageSourceResolvable PADCH027 = new DefaultMessageSourceResolvable("PADCH027");

	//スキルシート参照画面の案件追加ボタンを押した時の処理
	/**
	 * 新規案件追加画面を表示
	 * @return 新規案件追加画面に返す。
	 */
	@PostMapping("/skillsheet_project_registration")
	public String projectAdd(Model model, SkillSheet skillSheet, RedirectAttributes redirectAttribute) {
		// SkillSheetのインスタンスを渡す
		model.addAttribute("skillSheet", new SkillSheet());
		// 権限取得 マージした時用
		// model.addAttribute("role", service.getUserRole(skillSheet.getUserId()));
		// userIdを取得
		// 案件追加画面に情報を送る マージした時用
		// model.addAttribute("userID", skillSheet.getUserId());
		// userIdを案件追加画面に送る（マージした時は消す）
		model.addAttribute("userID", 1);
		// プルダウンDB取得
		// 案件追加画面に取得情報を送る
		model.addAttribute("dbList", service.getPulldownProjectDB());
		// プルダウンOS取得
		// 案件追加画面に取得情報を送る
		model.addAttribute("osList", service.getPulldownProjectOS());
		// プルダウン言語取得
		// 案件追加画面に取得情報を送る
		model.addAttribute("langList", service.getPulldownProjectLang());
		// プルダウンポジション情報取得
		// 案件追加画面に取得情報を送る
		model.addAttribute("dropDown", service.getDropdownInfo(3));
		// 遷移先skilldheet_project_registration(案件追加画面)
		return "skillsheet_project_registration";
	}

	/**
	 * 新規案件追加画面の保存.
	 *
	 * @param skillSheet bean SkillSheetのインスタンス変数
	 * @return スキルシート参照画面に返す
	 */
	@PostMapping("skillsheet_project_re")
	public String projectRegistration(@Valid SkillSheet skillSheet, BindingResult result, Model model) {
		// バリデーションチェック
		if (result.hasErrors()) {
			// return projectAdd(model, skillSheet);
			// 権限取得 マージした時用
			// model.addAttribute("role", service.getUserRole(skillSheet.getUserId()));
			// userIdを取得
			// 案件追加画面に情報を送る マージした時用
			// model.addAttribute("userID", skillSheet.getUserId());
			// userIdを案件追加画面に送る（マージした時は消す）
			model.addAttribute("userID", 1);
			// プルダウンDB取得
			// 案件追加画面に取得情報を送る
			model.addAttribute("dbList", service.getPulldownProjectDB());
			// プルダウンOS取得
			// 案件追加画面に取得情報を送る
			model.addAttribute("osList", service.getPulldownProjectOS());
			// プルダウン言語取得
			// 案件追加画面に取得情報を送る
			model.addAttribute("langList", service.getPulldownProjectLang());
			// プルダウンポジション情報取得
			// 案件追加画面に取得情報を送る
			model.addAttribute("dropDown", service.getDropdownInfo(3));
			// DBプルダウンバージョン最初の要素以外削除
			if (!(skillSheet.getDbVerPulArray().length == 1)) {
				List<String> dbVerArray = new ArrayList<String>(Arrays.asList(skillSheet.getDbVerPulArray()));
				for (int i = 1; i < skillSheet.getDbVerPulArray().length; i++) {
					int num = 1;
					dbVerArray.remove(num);
				}
				skillSheet.setDbVerPulArray((String[]) dbVerArray.toArray(new String[dbVerArray.size()]));
			}
			// DB最初の要素以外削除
			if (!(skillSheet.getDbArray().length == 1)) {
				List<String> dbArray = new ArrayList<String>(Arrays.asList(skillSheet.getDbArray()));
				for (int i = 1; i < skillSheet.getDbArray().length; i++) {
					int num = 1;
					dbArray.remove(num);
				}
				skillSheet.setDbArray((String[]) dbArray.toArray(new String[dbArray.size()]));
			}
			// DBバージョン最初の要素以外削除
			if (!(skillSheet.getDbVerArray().length == 1)) {
				List<String> dbVerArray = new ArrayList<String>(Arrays.asList(skillSheet.getDbVerArray()));
				for (int i = 0; i < skillSheet.getDbVerArray().length; i++) {
					int num = 0;
					dbVerArray.remove(num);
				}
				skillSheet.setDbVerArray((String[]) dbVerArray.toArray(new String[dbVerArray.size()]));
			}
			// osプルダウンバージョン最初の要素以外削除
			if (!(skillSheet.getOsVerPulArray().length == 1)) {
				List<String> osVerArray = new ArrayList<String>(Arrays.asList(skillSheet.getOsVerPulArray()));
				for (int i = 1; i < skillSheet.getOsVerPulArray().length; i++) {
					int num = 1;
					osVerArray.remove(num);
				}
				skillSheet.setOsVerPulArray((String[]) osVerArray.toArray(new String[osVerArray.size()]));
			}
			// os最初の要素以外削除
			if (!(skillSheet.getOsArray().length == 1)) {
				List<String> osArray = new ArrayList<String>(Arrays.asList(skillSheet.getOsArray()));
				for (int i = 1; i < skillSheet.getOsArray().length; i++) {
					int num = 1;
					osArray.remove(num);
				}
				skillSheet.setOsArray((String[]) osArray.toArray(new String[osArray.size()]));
			}
			// osバージョン最初の要素以外削除
			if (!(skillSheet.getOsVerArray().length == 1)) {
				List<String> osVerArray = new ArrayList<String>(Arrays.asList(skillSheet.getOsVerArray()));
				for (int i = 1; i < skillSheet.getOsVerArray().length; i++) {
					int num = 1;
					osVerArray.remove(num);
				}
				skillSheet.setOsVerArray((String[]) osVerArray.toArray(new String[osVerArray.size()]));
			}
			// その他最初の要素以外削除
			if (!(skillSheet.getOtherArray().length == 1)) {
				List<String> otherArray = new ArrayList<String>(Arrays.asList(skillSheet.getOtherArray()));
				for (int i = 1; i < skillSheet.getOtherArray().length; i++) {
					int num = 1;
					otherArray.remove(num);
				}
				skillSheet.setOtherArray((String[]) otherArray.toArray(new String[otherArray.size()]));
			}
			// その他バージョン最初の要素以外削除
			if (!(skillSheet.getOtherVerArray().length == 1)) {
				List<String> otherVerArray = new ArrayList<String>(Arrays.asList(skillSheet.getOtherVerArray()));
				for (int i = 1; i < skillSheet.getOtherVerArray().length; i++) {
					int num = 1;
					otherVerArray.remove(num);
				}
				skillSheet.setOtherVerArray((String[]) otherVerArray.toArray(new String[otherVerArray.size()]));
			}
			// FW/NW最初の要素以外削除
			if (!(skillSheet.getFwNwArray().length == 1)) {
				List<String> fwNwArray = new ArrayList<String>(Arrays.asList(skillSheet.getFwNwArray()));
				for (int i = 1; i < skillSheet.getFwNwArray().length; i++) {
					int num = 1;
					fwNwArray.remove(num);
				}
				skillSheet.setFwNwArray((String[]) fwNwArray.toArray(new String[fwNwArray.size()]));
			}
			// FW/NWバージョン最初の要素以外削除
			if (!(skillSheet.getFwNwVerArray().length == 1)) {
				List<String> fwNwVerArray = new ArrayList<String>(Arrays.asList(skillSheet.getFwNwVerArray()));
				for (int i = 1; i < skillSheet.getFwNwVerArray().length; i++) {
					int num = 1;
					fwNwVerArray.remove(num);
				}
				skillSheet.setFwNwVerArray((String[]) fwNwVerArray.toArray(new String[fwNwVerArray.size()]));
			}
			// 言語プルダウンバージョン最初の要素以外削除
			if (!(skillSheet.getLanguageVerPulArray().length == 1)) {
				List<String> languageArray = new ArrayList<String>(Arrays.asList(skillSheet.getLanguageVerPulArray()));
				for (int i = 1; i < skillSheet.getLanguageVerPulArray().length; i++) {
					int num = 1;
					languageArray.remove(num);
				}
				skillSheet.setLanguageVerPulArray((String[]) languageArray.toArray(new String[languageArray.size()]));
			}
			// 言語最初の要素以外削除
			if (!(skillSheet.getLanguageArray().length == 1)) {
				List<String> languageArray = new ArrayList<String>(Arrays.asList(skillSheet.getLanguageArray()));
				for (int i = 1; i < skillSheet.getLanguageArray().length; i++) {
					int num = 1;
					languageArray.remove(num);
				}
				skillSheet.setLanguageArray((String[]) languageArray.toArray(new String[languageArray.size()]));
			}
			// 言語バージョン最初の要素以外削除
			if (!(skillSheet.getLanguageVerArray().length == 1)) {
				List<String> languageVerArray = new ArrayList<String>(Arrays.asList(skillSheet.getLanguageVerArray()));
				for (int i = 1; i < skillSheet.getLanguageVerArray().length; i++) {
					int num = 1;
					languageVerArray.remove(num);
				}
				skillSheet
						.setLanguageVerArray((String[]) languageVerArray.toArray(new String[languageVerArray.size()]));
			}
			// 遷移先skilldheet_project_registration(案件追加画面)
			return "skillsheet_project_registration";
		}
		// チーム人数をString型からint型に変換しセット
		if (!(skillSheet.getTeamNumberString().isEmpty()))
			skillSheet.setTeamNumber(Integer.parseInt(skillSheet.getTeamNumberString()));
		// 日付を扱うクラスをインスタン
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 開始年月
		Date start = null;
		// 終了年月
		Date finish = null;
		// 案件期間（）
		long dayDiff = 0;
		// 案件終了日を入力してたいものを弾く
		if (!(skillSheet.getFinishDate().isEmpty())) {
			try {
				start = sdf.parse(skillSheet.getStartDate());
				finish = sdf.parse(skillSheet.getFinishDate());
			} catch (java.text.ParseException e) {
				e.printStackTrace();
			}
			// 終了年月(計算用)
			long dateTimeTo = finish.getTime();
			// 開始年月(計算用)
			long dateTimeFrom = start.getTime();
			// 開始年月と修了年月で期間を計算
			dayDiff = (dateTimeTo - dateTimeFrom) / (1000 * 60 * 60 * 24);
		} else {
			// 終了日の入力がない時にセット
			skillSheet.setFinishDate("0000-00-00");
		}
		// 計算された期間をセット
		skillSheet.setPeriodDate((int) dayDiff);
		// DBの期間をセット
		skillSheet.setDbPeriod((int) dayDiff);
		// FWNwの期間をセット
		skillSheet.setFwNwPeriod((int) dayDiff);
		// 言語の期間をセット
		skillSheet.setLanguagePeriod((int) dayDiff);
		// OSの期間をセット
		skillSheet.setOsPeriod((int) dayDiff);
		// その他の期間をセット
		skillSheet.setOtherPeriod((int) dayDiff);
		// 案件基本情報登録
		service.insertProject(skillSheet);
		// DB情報登録
		String[] dbPulArray = skillSheet.getDbPulArray();
		String[] dbVerPulArray = skillSheet.getDbVerPulArray();
		String[] dbArray = skillSheet.getDbArray();
		String[] dbVerArray = skillSheet.getDbVerArray();
		// db(プルダウン)配列の要素数だけ回す
		for (int i = 0; i < dbPulArray.length; i++) {
			// 指定なしを弾く
			if (!(dbPulArray[i].equals("指定なし"))) {
				// 空文字を弾く
				if (!(dbPulArray[i].equals(""))) {
					skillSheet.setDb(dbPulArray[i]);
					if (!(dbVerPulArray.length == 0)) {
						skillSheet.setDbVer(dbVerPulArray[i]);
					}
					service.insertProjectDB(skillSheet);
				}
			}
		}
		// db配列の要素数だけ回す
		for (int i = 0; i < dbArray.length; i++) {
			// 指定なしを弾く
			if (!(dbArray[i].equals("指定なし"))) {
				// 空文字を弾く
				if (!(dbArray[i].equals(""))) {
					skillSheet.setDb(dbArray[i]);
					skillSheet.setDbVer(dbVerArray[i]);
					service.insertProjectDB(skillSheet);
				}
			}
		}
		// FW/NW情報登録
		String[] fwNwArray = skillSheet.getFwNwArray();
		String[] fwNwVerArray = skillSheet.getFwNwVerArray();
		// fwNwArray配列の要素数だけ回す
		for (int i = 0; i < fwNwArray.length; i++) {
			// 空文字を弾く
			if (!(fwNwArray[i].equals(""))) {
				skillSheet.setFwNw(fwNwArray[i]);
				// 配列の要素数が０を弾く
				if (!(fwNwVerArray.length == 0)) {
					skillSheet.setFwNwVer(fwNwVerArray[i]);
				}
				service.insertProjectFWNW(skillSheet);
			}
		}
		// OS(プルダウン)情報登録
		String[] osPulArray = skillSheet.getOsPulArray();
		String[] osVerPulArray = skillSheet.getOsVerPulArray();
		String[] osArray = skillSheet.getOsArray();
		String[] osVerArray = skillSheet.getOsVerArray();
		// osArray配列の要素数だけ回す
		for (int i = 0; i < osPulArray.length; i++) {
			// 指定なしを弾く
			if (!(osPulArray[i].equals("指定なし"))) {
				// 空文字を弾く
				if (!(osPulArray[i].equals(""))) {
					skillSheet.setOs(osPulArray[i]);
					if (!(osPulArray.length == 0)) {
						skillSheet.setOsVer(osVerPulArray[i]);
					}
					service.insertProjectOS(skillSheet);
				}
			}
		}
		// osArray配列の要素数だけ回す
		for (int i = 0; i < osArray.length; i++) {
			// 指定なしを弾く
			if (!(osArray[i].equals("指定なし"))) {
				// 空文字を弾く
				if (!(osArray[i].equals(""))) {
					skillSheet.setOs(osArray[i]);
					skillSheet.setOsVer(osVerArray[i]);
					service.insertProjectOS(skillSheet);
				}
			}
		}
		// 言語情報登録
		String[] languagePulArray = skillSheet.getLanguagePulArray();
		String[] languageVerPulArray = skillSheet.getLanguageVerPulArray();
		String[] languageArray = skillSheet.getLanguageArray();
		String[] languageVerArray = skillSheet.getLanguageVerArray();
		// languageArray(プルダウン)配列の要素数だけ回す
		for (int i = 0; i < languagePulArray.length; i++) {
			// 指定なしを弾く
			if (!(languagePulArray[i].equals("指定なし"))) {
				// 空文字を弾く
				if (!(languagePulArray[i].equals(""))) {
					skillSheet.setLanguage(languagePulArray[i]);
					if (!(languagePulArray.length == 0)) {
						skillSheet.setLanguageVer(languageVerPulArray[i]);
					}
					service.insertProjectLang(skillSheet);
				}
			}
		}
		// languageArray配列の要素数だけ回す
		for (int i = 0; i < languageArray.length; i++) {
			// 指定なしを弾く
			if (!(languageArray[i].equals("指定なし"))) {
				// 空文字を弾く
				if (!(languageArray[i].equals(""))) {
					skillSheet.setLanguage(languageArray[i]);
					skillSheet.setLanguageVer(languageVerArray[i]);
					service.insertProjectLang(skillSheet);
				}
			}
		}
		// その他情報登録
		String[] otherArray = skillSheet.getOtherArray();
		String[] otherVerArray = skillSheet.getOtherVerArray();
		// otherArray配列の要素数だけ回す
		for (int i = 0; i < otherArray.length; i++) {
			// 空文字を弾く
			if (!(otherArray[i].equals(""))) {
				skillSheet.setOther(otherArray[i]);
				// 配列の要素数が０を弾く
				if (!(otherVerArray.length == 0)) {
					skillSheet.setOtherVer(otherVerArray[i]);
				}
				service.insertProjectOther(skillSheet);
			}
		}

		int userId = skillSheet.getUserId();
		session.setAttribute("userId", userId);

		// 案件追加メッセージを送る メッセージ：案件を登録しました。
		model.addAttribute("message",
				messageSource.getMessage("IMSG202", new MessageSourceResolvable[] { PADCH027 }, Locale.JAPAN));

		return "forward:skillsheet_reference";
	}
}

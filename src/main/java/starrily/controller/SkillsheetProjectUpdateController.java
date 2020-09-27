package starrily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import starrily.bean.SkillSheet;
import starrily.service.StarrilyService;

/**
 * 新規案件追加クラス
 *
 * @author s.lee
 * @version 1.0.0
 */
@Controller
public class SkillsheetProjectUpdateController {

	@Autowired
	StarrilyService service;

	/**
	 * 案件更新画面を表示
	 * @return　更新情報画面に返す。
	 */
	@PostMapping("/skillsheet_project_update")
	public String skillsheetUpdate(Model model) {

		SkillSheet skillSheet = new SkillSheet();
		skillSheet.setUserId(3);

		List<SkillSheet> projectList = service.getProject(skillSheet);

		model.addAttribute("skillSheet", projectList);

		// SkillSheetのインスタンスを渡す
		// 仮権限情報取得（マージするときは消す）
		model.addAttribute("role", service.getUserRole(11));
		// 権限取得 マージした時用
		//	model.addAttribute("role", service.getUserRole(skillSheet.getUserId()));
		// userIdを取得
		// 案件追加画面に情報を送る マージした時用
		// model.addAttribute("userID", skillSheet.getUserId());
		// userIdを案件追加画面に送る（マージした時は消す）
		model.addAttribute("userID", skillSheet.getUserId());
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

		return "skillsheet_project_update";
	}

	/**
	 * 案件変更をを実行
	 * @return　スキルシート参照画面に返す。
	 */
	@PutMapping("/skillsheet_update_check")
	public String skillsheetProjectUpdate(SkillSheet skillSheet, Model model, String checkboxfaze) {

		//チェックボックスに確定した値を設定する。
		if (!checkboxfaze.isEmpty() && !checkboxfaze.equals(null)) {
			skillSheet.setChargePhase(checkboxfaze);
		}

		// 案件基本情報更新を実行する。
		service.updateProject(skillSheet);
		// 案件経歴情報削除を実行する。
		service.deleteProjectItems(skillSheet);
		// DB情報登録を実行する。
		service.insertProjectDB(skillSheet);
		// 	OS情報登録を実行する。
		service.insertProjectOS(skillSheet);
		// 言語情報登録を実行する。
		service.insertProjectLang(skillSheet);
		// FW_NW情報登録を実行する。
		service.insertProjectFWNW(skillSheet);
		// その他情報登録を実行する。
		service.insertProjectOther(skillSheet);

		return "skillsheet_reference";
	}

}

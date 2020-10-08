package starrily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import starrily.bean.SkillSheet;
import starrily.service.StarrilyService;

/**
 * 新規案件追加クラス.
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
	 * @return 更新情報画面に返す。
	 */
	@PostMapping("/skillsheet_project_update")
	public String skillsheetUpdate(Model model, SkillSheet skillSheet) {

		skillSheet.setUserId(3);
		skillSheet.setCareerId(10);
		model.addAttribute("skillSheet", service.getProject(skillSheet));

		//担当フェーズの値を分けて保存
		String[] chargePhase = service.getProject(skillSheet).get(0).getChargePhase().split("、");
		//		 List<SkillSheet> chargePhase = service.getProject(skillSheet);
		//担当フェースの情報を取得
		model.addAttribute("chargePhase", chargePhase);

		model.addAttribute("userId", 1);
		model.addAttribute("career_Id", 3);

		// 仮権限情報取得
		model.addAttribute("role", service.getUserRole(11));
		// userIdを案件追加画面に送る
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
	 * 案件変更をを実行.
	 *
	 * @return スキルシート参照画面に返す。
	 */
	@PostMapping("/skillsheet_project_update_put")
	public String skillsheetProjectUpdate(@ModelAttribute @Validated SkillSheet skillSheet, BindingResult result,
			Model model, String checkboxfaze,
			String career_Id, String userId) {

		//チェックボックスに確定した値を設定する。
		try {
			if (!checkboxfaze.isEmpty() && !checkboxfaze.equals(null)) {
				skillSheet.setChargePhase(checkboxfaze);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		skillSheet.setUserId(Integer.parseInt(userId));
		skillSheet.setCareerId(Integer.parseInt(career_Id));

		if (result.hasErrors()) {
			return "skillsheet_project_update";
		}
		return "skillsheet_reference";
	}

	@PostMapping("/page_back")
	public String pasgeBack() {
		return "skillsheet_reference";
	}
}

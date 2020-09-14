package starrily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import starrily.bean.Dropdown;
import starrily.bean.SkillSheet;
import starrily.service.StarrilyService;

/**
 * 基本情報更新クラス
 *
 * @author yu.yamamoto
 * @version 1.0.0
 */
@Controller
public class SkillsheetInformationUpdateController {

	/** StarrilyServiceクラスの中のメソッドを呼び出せるようにする. */
	@Autowired
	private StarrilyService starrilyService;

	/**
	 ** 基本情報更新画面を表示
	 * @return　基本情報更新画面に返す。
	 */
	@PostMapping("/skillsheet_information_update")
	public String basicInformation(Model model, @RequestParam(name = "userId") int userId) {

		SkillSheet skillSheetBasicList = starrilyService.getSkillSheetBasic(userId);
		model.addAttribute("skillSheetBasicList", skillSheetBasicList);

		List<Dropdown> dropdownInfo = starrilyService.getDropdownInfo(6);
		model.addAttribute("dropdownInfo", dropdownInfo);

		return "skillsheet_information_update";
	}

	/**
	 ** 基本情報更新画面の更新処理
	 * @return スキルシート参照画面に返す。
	 */
	@PutMapping("/skillsheet_information_update")
	public String update(Model model, @ModelAttribute SkillSheet Skillsheet,
			RedirectAttributes redirectAttribute) {

		starrilyService.updateBasicInformation(Skillsheet);

		return "redirect:skillsheet_reference";
	}

}

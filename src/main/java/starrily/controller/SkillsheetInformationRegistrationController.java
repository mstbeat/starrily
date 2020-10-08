package starrily.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import starrily.bean.Dropdown;
import starrily.bean.SkillSheet;
import starrily.service.StarrilyService;
import starrily.validation.SkillsheetGroup;

/**
 *
 * @author taniryuki
 * @version 1.0.0
 */
@Controller
public class SkillsheetInformationRegistrationController {

	/** StarrilyServiceを自動的にDIする */
	@Autowired
	StarrilyService starrilyService;

	/** MessageSourceを自動的にDIする */
	@Autowired
	MessageSource messageSource;

	/**
	 * 基本情報登録処理を行うメソッド.
	 *
	 * @param skillSheet SkillSheetクラス、formからの情報を代入
	 * @param result バリデーションについてresultに代入する
	 * @param model モデル属性のホルダーを定義
	 * @return スキルシート参照画面を表示する
	 */
	@PostMapping("/skillsheet_information_registration")
	public String basicInformation(@ModelAttribute @Validated(SkillsheetGroup.class) SkillSheet skillSheet,
			BindingResult result, Model model) {

		int userRole = starrilyService.getUserRole(skillSheet.getUserId());
		model.addAttribute("showUserManagement", false);
		switch (userRole) {
		case 1:
		case 2:
		case 3:
			model.addAttribute("showUserManagement", true);
			break;
		}

		if (result.hasErrors()) {
			model.addAttribute("educationDropdown", starrilyService.getDropdownInfo(6));
			return "/skillsheet_information_registration";
		}
		starrilyService.insertBasicInformation(skillSheet);

		MessageSourceResolvable PADCH028 = new DefaultMessageSourceResolvable("PADCH028");

		model.addAttribute("infoMessage",
				messageSource.getMessage("IMSG202", new MessageSourceResolvable[] { PADCH028 }, Locale.JAPAN));

		// 学歴のプルダウンをDBから取ってくる
		List<Dropdown> dropdownInfo = starrilyService.getDropdownInfo(6);
		model.addAttribute("dropdownInfo", dropdownInfo);

		//スキルシート参照の処理を以下に記述

		return "forward:skillsheet_reference";
	}
}

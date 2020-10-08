package starrily.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import starrily.bean.SkillSheet;
import starrily.bean.UserInformation;
import starrily.commonProcessing.SkillsheetCommon;
import starrily.service.StarrilyService;

/**
 * スキルシート参照クラス.
 *
 * @author yu.yamamoto
 * @version 1.0.0
 */
@Controller
public class SkillsheetReferenceController {

	/** AutowireCapableBeanFactoryを取得(自動配線)*/
	@Autowired
	AutowireCapableBeanFactory beanFactory;

	/** starrilyServiceクラスの中のメソッドを呼び出せるようにする. */
	@Autowired
	private StarrilyService starrilyService;

	@Autowired
	HttpSession session;

	@Autowired
	HttpServletRequest request;

	/**
	 * スキルシート参照画面を表示.
	 *
	 * @param skillSheet インスタンス化されたエンティティ
	 * @param model webページで利用するデータを管理するためのクラス　
	 * @param flg ヘッダーのスキルシート参照か一覧画面からきたのかの判定
	 * @return スキルシート参照に返す。
	 */
	@PostMapping("/skillsheet_reference")
	public String SkillsheetReference(@ModelAttribute SkillSheet skillSheet, Model model,
			@RequestParam(name = "flg") int flg) {

		int LoginUserId = (int) session.getAttribute("Login");

		if (flg == 1) {
			int userId = Integer.parseInt(request.getParameter("userId"));
			// 一覧画面からスキルシート参照画面にきた時のIDで値を取得
			SkillsheetCommon ProjectAll = new SkillsheetCommon();
			beanFactory.autowireBean(ProjectAll);
			// 戻るボタンの一覧画面に返す判定
			int one = 1;
			model.addAttribute("one", one);
			ProjectAll.skillsheetReference(userId, model);
		} else if (flg == 2) {
			// 仮(基本情報登録画面を表示するため)
			if (starrilyService.getSkillSheetBasic(LoginUserId).getUserAddress().isEmpty()) {
				UserInformation user = starrilyService.getUserInformation(LoginUserId);

				skillSheet.setUserId(user.getUserId());
				skillSheet.setUserName(user.getUserName());
				model.addAttribute("skillSheet", skillSheet);

				model.addAttribute("educationDropdown", starrilyService.getDropdownInfo(6));
				return "skillsheet_information_registration";
			}
			// ヘッダーからスキルシート参照画面にきた時のIDで値で取得
			SkillsheetCommon ProjectAll = new SkillsheetCommon();
			beanFactory.autowireBean(ProjectAll);
			// 戻るボタンの検索画面に返す判定
			int two = 2;
			model.addAttribute("two", two);
			ProjectAll.skillsheetReference(LoginUserId, model);
		} else {
			int userId = Integer.parseInt(request.getParameter("userId"));
			SkillsheetCommon ProjectAll = new SkillsheetCommon();
			beanFactory.autowireBean(ProjectAll);
			ProjectAll.skillsheetReference(userId, model);
		}

		return "skillsheet_reference";
	}

	/**
	 * 案件削除を行うメソッド.
	 *
	 * @param model webページで利用するデータを管理するためのクラス　
	 * @param Skillsheet インスタンス化されたエンティティ
	 * @param redirectAttribute クライアントから送られてきたサーバー側で指定したurlに飛ばす。
	 * @return スキルシート参照に返す。
	 */
	@PostMapping("/skillsheet_referenceDelete")
	public String skillsheetDelete(Model model, @ModelAttribute SkillSheet Skillsheet,
			RedirectAttributes redirectAttribute) {
		// 案件削除の処理
		starrilyService.deleteSkillSheetProject(Skillsheet);

		return "forward:skillsheet_reference";
	}

}

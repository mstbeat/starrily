package starrily.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import starrily.bean.Dropdown;
import starrily.bean.SkillSheet;
import starrily.service.StarrilyService;

/**
 * スキルシート参照クラス
 *
 * @author yu.yamamoto
 * @version 1.0.0
 */
@Controller
public class SkillsheetReferenceController {

	/** starrilyServiceクラスの中のメソッドを呼び出せるようにする. */
	@Autowired
	private StarrilyService starrilyService;

	/**
	 *　スキルシート参照画面を表示
	 * @return　スキルシート参照に返す。
	 */
	@PostMapping("/skillsheet_reference")
	public String skillReference(@RequestParam(name = "userId") int userId, Model model) {

		// 検索一覧画面からパラメータで受け取るようにする。
		// userIdをLoginControllerからセッションで受け取る
		// int LoginUserId = (int) session.getAttribute("userId");
		// int role = (int) session.getAttribute("role");
		SkillSheet skillSheetBasicList = starrilyService.getSkillSheetBasic(userId);
		model.addAttribute("skillSheetBasicList", skillSheetBasicList);

		// 案件基本情報を取得
		List<SkillSheet> projectAllList = starrilyService.getProjectAll(userId);

		for (SkillSheet forProjectAll : projectAllList) {
			// DBの情報を取得
			// userIdで同じ数字があった場合、CareerIdの情報のDBを取ってくる
			List<SkillSheet> projectDbList = starrilyService.getProjectDB(forProjectAll.getCareerId());

			String projectDb = "";

			for (SkillSheet forDb : projectDbList) {
				String db = null;
				if (forDb.getDbVer() != null) {
					db = forDb.getDb() + forDb.getDbVer();
				} else {
					db = forDb.getDb();
				}
				projectDb = projectDb + db + "\n";
			}
			forProjectAll.setAllDb(projectDb);

			// フレームワークの情報を取得
			List<SkillSheet> projectFwNwList = starrilyService.getProjectFwNw(forProjectAll.getCareerId());

			String projectFwNw = "";

			for (SkillSheet ForFwNw : projectFwNwList) {

				String FwNw = null;

				if (ForFwNw.getFwNwVer() != null) {
					FwNw = ForFwNw.getFwNw() + ForFwNw.getFwNwVer();
				} else {
					FwNw = ForFwNw.getFwNw();
				}
				projectFwNw = projectFwNw + FwNw + "\n";
			}
			forProjectAll.setAllFwNw(projectFwNw);

			// OSの情報を取得
			List<SkillSheet> projectOsList = starrilyService.getProjectOS(forProjectAll.getCareerId());

			String projectOs = "";

			for (SkillSheet ForOs : projectOsList) {

				String Os = null;

				if (ForOs.getOsVer() != null) {
					Os = ForOs.getOs() + ForOs.getOsVer();
				} else {
					Os = ForOs.getOs();
				}
				projectOs = projectOs + Os + "\n";
			}
			forProjectAll.setAllOs(projectOs);

			// 言語の情報を取得
			List<SkillSheet> projectLangList = starrilyService.getProjectLang(forProjectAll.getCareerId());

			String projectLang = "";

			for (SkillSheet ForProjectLang : projectLangList) {

				String language = null;

				if (ForProjectLang.getOsVer() != null) {
					language = ForProjectLang.getLanguage() + ForProjectLang.getLanguageVer();
				} else {
					language = ForProjectLang.getLanguage();
				}
				projectLang = projectLang + language + "\n";
			}
			forProjectAll.setAllLang(projectLang);

			// その他の情報を取得
			List<SkillSheet> projectOtherList = starrilyService.getProjectOther(forProjectAll.getCareerId());

			String projectOther = "";

			for (SkillSheet ForProjectOther : projectOtherList) {

				String other = null;

				if (ForProjectOther.getOsVer() != null) {
					other = ForProjectOther.getOther() + ForProjectOther.getOtherVer();
				} else {
					other = ForProjectOther.getOther();
				}
				projectOther = projectOther + other + "\n";
			}
			forProjectAll.setAllOther(projectOther);

			if (forProjectAll.getFinishDate().equals("0000年00月")) {
				forProjectAll.setFinishDate("未定");
			}
		}
		model.addAttribute("projectAllList", projectAllList);

		if (userId == skillSheetBasicList.getUserId()) {
			int one = 1;
			model.addAttribute("one", one);
		}

		// 学歴のプルダウンをDBから取ってくる
		List<Dropdown> dropdownInfo = starrilyService.getDropdownInfo(6);
		model.addAttribute("dropdownInfo", dropdownInfo);

		return "skillsheet_reference";
	}

	/**
	 * 案件削除を行う
	 * @return　スキルシート参照に返す。
	 */
	@PostMapping("/skillsheet_referenceDelete")
	public String skillsheetDelete(HttpSession session, Model model, @ModelAttribute SkillSheet Skillsheet,
			RedirectAttributes redirectAttribute) {

		starrilyService.deleteSkillSheetProject(Skillsheet);

		int userId = Skillsheet.getUserId();
		session.setAttribute("userId", userId);

		return "forward:skillsheet_reference";
	}

	/**
	 *　ヘッダーのスキルシート参照画面から来たとの処理
	 *
	 * @param model Modelクラス
	 * @return スキルシート 参照画面に返す。
	 */
	@PostMapping("/skillsheet_reference_add")
	public String skillRefce(Model model) {

		//仮
		int LoginUserId = 3;

		// 検索一覧画面からパラメータで受け取るようにする。
		// userIdをLoginControllerからセッションで受け取る
		//	int LoginUserId = (int) session.getAttribute("userId");
		// int role = (int) session.getAttribute("role");
		SkillSheet skillSheetBasicList = starrilyService.getSkillSheetBasic(LoginUserId);
		model.addAttribute("skillSheetBasicList", skillSheetBasicList);

		// もし基本情報がなかった場合
		if (LoginUserId != skillSheetBasicList.getUserId()) {
			return "skillsheet_information_registration";
		}

		// 案件基本情報を取得
		List<SkillSheet> projectAllList = starrilyService.getProjectAll(LoginUserId);

		for (SkillSheet forProjectAll : projectAllList) {
			// DBの情報を取得
			// userIdで同じ数字があった場合、CareerIdの情報のDBを取ってくる
			List<SkillSheet> projectDbList = starrilyService.getProjectDB(forProjectAll.getCareerId());

			String projectDb = "";

			for (SkillSheet forDb : projectDbList) {
				String db = null;
				if (forDb.getDbVer() != null) {
					db = forDb.getDb() + forDb.getDbVer();
				} else {
					db = forDb.getDb();
				}
				projectDb = projectDb + db + "\n";
			}
			forProjectAll.setAllDb(projectDb);

			// フレームワークの情報を取得
			List<SkillSheet> projectFwNwList = starrilyService.getProjectFwNw(forProjectAll.getCareerId());

			String projectFwNw = "";

			for (SkillSheet ForFwNw : projectFwNwList) {

				String FwNw = null;

				if (ForFwNw.getFwNwVer() != null) {
					FwNw = ForFwNw.getFwNw() + ForFwNw.getFwNwVer();
				} else {
					FwNw = ForFwNw.getFwNw();
				}
				projectFwNw = projectFwNw + FwNw + "\n";
			}
			forProjectAll.setAllFwNw(projectFwNw);

			// OSの情報を取得
			List<SkillSheet> projectOsList = starrilyService.getProjectOS(forProjectAll.getCareerId());

			String projectOs = "";

			for (SkillSheet ForOs : projectOsList) {

				String Os = null;

				if (ForOs.getOsVer() != null) {
					Os = ForOs.getOs() + ForOs.getOsVer();
				} else {
					Os = ForOs.getOs();
				}
				projectOs = projectOs + Os + "\n";
			}
			forProjectAll.setAllOs(projectOs);

			// 言語の情報を取得
			List<SkillSheet> projectLangList = starrilyService.getProjectLang(forProjectAll.getCareerId());

			String projectLang = "";

			for (SkillSheet ForProjectLang : projectLangList) {

				String language = null;

				if (ForProjectLang.getOsVer() != null) {
					language = ForProjectLang.getLanguage() + ForProjectLang.getLanguageVer();
				} else {
					language = ForProjectLang.getLanguage();
				}
				projectLang = projectLang + language + "\n";
			}
			forProjectAll.setAllLang(projectLang);

			// その他の情報を取得
			List<SkillSheet> projectOtherList = starrilyService.getProjectOther(forProjectAll.getCareerId());

			String projectOther = "";

			for (SkillSheet ForProjectOther : projectOtherList) {

				String other = null;

				if (ForProjectOther.getOsVer() != null) {
					other = ForProjectOther.getOther() + ForProjectOther.getOtherVer();
				} else {
					other = ForProjectOther.getOther();
				}
				projectOther = projectOther + other + "\n";
			}
			forProjectAll.setAllOther(projectOther);
		}

		model.addAttribute("projectAllList", projectAllList);

		// ヘッダースキルシート参照から来たときの判断
		if (LoginUserId == skillSheetBasicList.getUserId()) {
			int two = 2;
			model.addAttribute("two", two);
		}

		// 学歴のプルダウンをDBから取ってくる
		List<Dropdown> dropdownInfo = starrilyService.getDropdownInfo(6);
		model.addAttribute("dropdownInfo", dropdownInfo);

		return "skillsheet_reference";
	}

}

package starrily.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	@GetMapping("/skillsheet_reference")
	public String skillReference(HttpSession session, Model model, @ModelAttribute @Validated SkillSheet skillSheet,
			BindingResult result) {

		// 検索一覧画面からパラメータで受け取るようにする。
		int userId = 3;

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

			// フレームワークの情報を取
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

		//		ヘッダーからスキルシート参照画面に表示させる(自分のスキルシート )
		//		List<SkillSheet> skillSheetBasicLis = starrilyService.getSkillSheetBasic(LoginUserId);
		//		model.addAttribute("skillSheetBasicList", skillSheetBasicLis);
		//
		//		// 案件基本情報を取得
		//		List<SkillSheet> projectAllLis = starrilyService.getProjectAll(LoginUserId);
		//
		//		for (SkillSheet forProjectAll : projectAllLis) {
		//			// DBの情報を取得
		//			// userIdで同じ数字があった場合、CareerIdの情報のDBを取ってくる
		//			List<SkillSheet> projectDb = starrilyService.getProjectDB(forProjectAll.getCareerId());
		//
		//			String ver = "";
		//
		//			for (SkillSheet db : projectDb) {
		//				String ver2 = null;
		//				if (db.getDbVer() != null) {
		//					ver2 = db.getDb() + db.getDbVer();
		//				} else {
		//					ver2 = db.getDb();
		//				}
		//				ver = ver + ver2 + "\n";
		//				// 1回目　ver= から文字　ver2  = Mysql
		//				// 2回目　ver= Mysql + 改行 ver2= MariaDN
		//			}
		//			forProjectAll.setAllDb(ver);
		//
		//			// フレームワークの情報を取
		//			List<SkillSheet> projectFwNwList = starrilyService.getProjectFwNw(forProjectAll.getCareerId());
		//
		//			String projectFwNw = "";
		//
		//			for (SkillSheet ForFwNw : projectFwNwList) {
		//
		//				String FwNw = null;
		//
		//				if (ForFwNw.getFwNwVer() != null) {
		//					FwNw = ForFwNw.getFwNw() + ForFwNw.getFwNwVer();
		//				} else {
		//					FwNw = ForFwNw.getFwNw();
		//				}
		//				projectFwNw = projectFwNw + FwNw + "\n";
		//			}
		//			forProjectAll.setAllFwNw(projectFwNw);
		//
		//			// OSの情報を取得
		//			List<SkillSheet> projectOsList = starrilyService.getProjectOS(forProjectAll.getCareerId());
		//
		//			String projectOs = "";
		//
		//			for (SkillSheet ForOs : projectOsList) {
		//
		//				String Os = null;
		//
		//				if (ForOs.getOsVer() != null) {
		//					Os = ForOs.getOs() + ForOs.getOsVer();
		//				} else {
		//					Os = ForOs.getOs();
		//				}
		//				projectOs = projectOs + Os + "\n";
		//			}
		//			forProjectAll.setAllOs(projectOs);
		//
		//			// 言語の情報を取得
		//			List<SkillSheet> projectLangList = starrilyService.getProjectLang(forProjectAll.getCareerId());
		//
		//			String projectLang = "";
		//
		//			for (SkillSheet ForProjectLang : projectLangList) {
		//
		//				String language = null;
		//
		//				if (ForProjectLang.getOsVer() != null) {
		//					language = ForProjectLang.getLanguage() + ForProjectLang.getLanguageVer();
		//				} else {
		//					language = ForProjectLang.getLanguage();
		//				}
		//				projectLang = projectLang + language + "\n";
		//			}
		//			forProjectAll.setAllLang(projectLang);
		//
		//			// その他の情報を取得
		//			List<SkillSheet> projectOtherList = starrilyService.getProjectOther(forProjectAll.getCareerId());
		//
		//			String projectOther = "";
		//
		//			for (SkillSheet ForProjectOther : projectOtherList) {
		//
		//				String other = null;
		//
		//				if (ForProjectOther.getOsVer() != null) {
		//					other = ForProjectOther.getOther() + ForProjectOther.getOtherVer();
		//				} else {
		//					other = ForProjectOther.getOther();
		//				}
		//				projectOther = projectOther + other + "\n";
		//			}
		//			forProjectAll.setAllOther(projectOther);
		//		}
		//
		//		model.addAttribute("projectAllList", projectAllList);

		// 学歴のプルダウンをDBから取ってくる
		List<Dropdown> dropdownInfo = starrilyService.getDropdownInfo(6);
		model.addAttribute("dropdownInfo", dropdownInfo);

		return "skillsheet_reference";
	}

	/**
	 * 案件削除を行う
	 * @return　スキルシート参照に返す。
	 */
	@DeleteMapping("/skillsheet_reference")
	public String skillsheetDelete(Model model, @ModelAttribute SkillSheet Skillsheet,
			RedirectAttributes redirectAttribute) {

		starrilyService.deleteSkillSheetProject(Skillsheet);

		return "redirect:skillsheet_reference";
	}

}

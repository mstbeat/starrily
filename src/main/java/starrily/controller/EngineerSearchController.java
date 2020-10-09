package starrily.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import starrily.bean.Dropdown;
import starrily.bean.EngineerSearch;
import starrily.bean.SkillSheet;
import starrily.bean.UserInformation;
import starrily.service.StarrilyService;

/**
 * エンジニア検索画面のコントローラー.
 *
 * @author t.osawa
 *
 */
@Controller
public class EngineerSearchController {

	@Autowired
	StarrilyService starrilyService;

	@Autowired
	MessageSource messageSource;

	@Autowired
	HttpSession session;
	/**
	 * エンジニア検索画面に遷移させるメソッド.
	 *
	 * @param model Modelクラス
	 * @return  エンジニア検索画面へ遷移する。
	 */
	@PostMapping("engineer_search")
	public String engineerSearchP(Model model) {

		List<SkillSheet> dB = starrilyService.getPulldownProjectDB();
		List<SkillSheet> oS = starrilyService.getPulldownProjectOS();
		List<SkillSheet> language = starrilyService.getPulldownProjectLang();
		List<SkillSheet> fwNw = starrilyService.getPulldownProjectFWNW();
		List<SkillSheet> other = starrilyService.getPulldownProjectOther();
		List<Dropdown> division = starrilyService.getDropdownInfo(1);
		List<Dropdown> status = starrilyService.getDropdownInfo(2);
		List<Dropdown> years = starrilyService.getDropdownInfo(5);
		List<Dropdown> position = starrilyService.getDropdownInfo(3);
		List<Dropdown> item = starrilyService.getDropdownInfo(4);

		session.setAttribute("Login", 3);

		for (Dropdown dd : item) {
			if (dd.getItemName().equals("項目を選択してください")) {
				dd.setItemCode("");
				continue;
			}
			if (dd.getItemName().equals("言語")) {
				dd.setItemCode("Language");
				continue;
			}
			if (dd.getItemName().equals("FW/NW")) {
				dd.setItemCode("FWNW");
				continue;
			}
			if (dd.getItemName().equals("その他")) {
				dd.setItemCode("Other");
				continue;
			}
			dd.setItemCode(dd.getItemName());
		}

		model.addAttribute("DB", dB);
		model.addAttribute("OS", oS);
		model.addAttribute("Language", language);
		model.addAttribute("FwNw", fwNw);
		model.addAttribute("Other", other);
		model.addAttribute("division", division);
		model.addAttribute("status", status);
		model.addAttribute("years", years);
		model.addAttribute("position", position);
		model.addAttribute("item", item);
		model.addAttribute("userInformation", new UserInformation());
		return "engineer_search";
	}

	/**
	 * 検索処理が実行されたときに処理するメソッド.
	 *
	 * @param model Modelクラス
	 * @return  エンジニア一覧画面表示処理へリダイレクトする。
	 */
	@PostMapping("engineer_search_execution")
	public String engineerSearchExecution(
		    //基本情報検索パラム
			@ModelAttribute UserInformation userInformation,
			//スキル情報検索パラム
			@RequestParam(name = "item1") String item1,
			@RequestParam(name = "item2") String item2,
			@RequestParam(name = "item3") String item3,
			@RequestParam(name = "item4") String item4,
			@RequestParam(name = "item5") String item5,
			@RequestParam(name = "detail1") String[] detail1,
			@RequestParam(name = "detail2") String[] detail2,
			@RequestParam(name = "detail3") String[] detail3,
			@RequestParam(name = "detail4") String[] detail4,
			@RequestParam(name = "detail5") String[] detail5, @RequestParam(name = "ver") String[] ver,
			@RequestParam(name = "years") String[] yearsStrs,
			//詳細情報検索パラム
			@RequestParam(name = "industry") String industry,
			@RequestParam(name = "position") String position,
			@RequestParam(name = "checkboxfaze") String[] chargePhase, Model model, HttpSession session,
			BindingResult result) {

		if (position.equals("指定なし")) {
			position = "";
		}
		List<String> errorMessage = new ArrayList<String>();

		//バージョン文字種trueならエラー
		boolean verMatchError = false;
		//バージョン文字数trueならエラー
		boolean verSizeError = false;
		//業界文字数trueならエラー
		boolean industryError = false;

		//この2つの数値が違っていたらエラー、スキル項目必須
		int countDetail = 0;
		int countItem = 0;

		String detailStr1 = "";
		String detailStr2 = "";
		String detailStr3 = "";
		String detailStr4 = "";
		String detailStr5 = "";

		if (!item1.equals("")) {
			countItem++;
		}
		if (!item2.equals("")) {
			countItem++;
		}
		if (!item3.equals("")) {
			countItem++;
		}
		if (!item4.equals("")) {
			countItem++;
		}
		if (!item5.equals("")) {
			countItem++;
		}

		if (detail1.length != 0 && !detail1[1].equals("")) {
			detailStr1 = detail1[1];
			countDetail++;
		}
		if (detail2.length != 0 && !detail2[1].equals("")) {
			detailStr2 = detail2[1];
			countDetail++;
		}
		if (detail3.length != 0 && !detail3[1].equals("")) {
			detailStr3 = detail3[1];
			countDetail++;
		}
		if (detail4.length != 0 && !detail4[1].equals("")) {
			detailStr4 = detail4[1];
			countDetail++;
		}
		if (detail5.length != 0 && !detail5[1].equals("")) {
			detailStr5 = detail5[1];
			countDetail++;
		}
		//バージョン部分
		for (String verSingle : ver) {
			if (!verSingle.matches("^[a-zA-Z0-9 -/:-@\\[-\\`\\{-\\~]+$") && !verSingle.equals("")) {
				verMatchError = true;
			}
			if (verSingle.length() > 20) {
				verSizeError = true;
			}
		}
		if (industry.length() > 20) {
			industryError = true;
		}
		//すべてのエラー確認
		if (result.hasErrors() || industryError || verMatchError || verSizeError || countDetail != countItem) {

			MessageSourceResolvable PADCH028 = new DefaultMessageSourceResolvable("PADCH028");
			errorMessage.add(messageSource.getMessage("EMSG012", new MessageSourceResolvable[] { PADCH028 }, Locale.JAPAN));

			List<SkillSheet> dB = starrilyService.getPulldownProjectDB();
			List<SkillSheet> oS = starrilyService.getPulldownProjectOS();
			List<SkillSheet> language = starrilyService.getPulldownProjectLang();
			List<SkillSheet> fwNw = starrilyService.getPulldownProjectFWNW();
			List<SkillSheet> other = starrilyService.getPulldownProjectOther();
			List<Dropdown> division = starrilyService.getDropdownInfo(1);
			List<Dropdown> status = starrilyService.getDropdownInfo(2);
			List<Dropdown> years = starrilyService.getDropdownInfo(5);
			List<Dropdown> positiondd = starrilyService.getDropdownInfo(3);
			List<Dropdown> item = starrilyService.getDropdownInfo(4);

			for (Dropdown dd : item) {
				if (dd.getItemName().equals("項目を選択してください")) {
					dd.setItemCode("");
					continue;
				}

				if (dd.getItemName().equals("言語")) {
					dd.setItemCode("Language");
					continue;
				}
				if (dd.getItemName().equals("FW/NW")) {
					dd.setItemCode("FWNW");
					continue;
				}
				if (dd.getItemName().equals("その他")) {
					dd.setItemCode("Other");
					continue;
				}
				dd.setItemCode(dd.getItemName());
			}

			model.addAttribute("errorMessage", errorMessage);
			model.addAttribute("DB", dB);
			model.addAttribute("OS", oS);
			model.addAttribute("Language", language);
			model.addAttribute("FwNw", fwNw);
			model.addAttribute("Other", other);
			model.addAttribute("division", division);
			model.addAttribute("status", status);
			model.addAttribute("years", years);
			model.addAttribute("position", positiondd);
			model.addAttribute("item", item);
			model.addAttribute("userInformation", new UserInformation());
			return "engineer_search";

		}
		List<Integer> yearsList = new ArrayList<Integer>();

		for (String yearsStr : yearsStrs) {
			if (yearsStr.equals("経歴年数を選択してください")) {
				yearsList.add(0);
				continue;
			}
			if (yearsStr.equals("1年未満")) {
				yearsList.add(11);
				continue;
			}
			yearsList.add(Integer.parseInt(yearsStr.replaceAll("[^0-9]", "")) * 12);
		}
		Integer[] years = yearsList.toArray(new Integer[yearsList.size()]);
		String[] detail = { detailStr1, detailStr2, detailStr3, detailStr4, detailStr5 };
		String[] item = { item1, item2, item3, item4, item5 };

		EngineerSearch es = new EngineerSearch();
		es.setUserInformation(userInformation);
		es.setItem(item);
		es.setDetail(detail);
		es.setChargePhase(chargePhase);
		es.setIndustry(industry);
		es.setPosition(position);
		es.setVer(ver);
		es.setYears(years);
		session.setMaxInactiveInterval(1800);
		session.setAttribute("engineer_search", es);
		return "forward:engineer_list";
	}

}

package starrily.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import starrily.bean.EngineerSearch;
import starrily.bean.SkillSheet;
import starrily.bean.UserInformation;
import starrily.service.StarrilyService;

/**
 * エンジニア検索画面のコントローラー
 *
 * @author PDA s.lee
 *
 */
@Controller
public class EngineerSearchController {

	@Autowired
	StarrilyService starrilyService;

	/**
	 * エンジニア検索画面に遷移させるメソッド.
	 *
	 * @param model Modelクラス
	 * @return  エンジニア検索画面へ遷移する。
	 */
	@PostMapping("engineer_search")
	public String engineerSearchP(Model model) {
		// DB情報を取得
		List<SkillSheet> dB = starrilyService.getPulldownProjectDB();
		// os情報を取得
		List<SkillSheet> oS = starrilyService.getPulldownProjectOS();
		// 言語の情報を取得
		List<SkillSheet> language = starrilyService.getPulldownProjectLang();
		// フレームワークの情報を取得
		List<SkillSheet> fwNw = starrilyService.getPulldownProjectFWNW();
		// その他の情報を取得
		List<SkillSheet> other = starrilyService.getPulldownProjectOther();

		model.addAttribute("DB", dB);
		model.addAttribute("OS", oS);
		model.addAttribute("Language", language);
		model.addAttribute("FwNw", fwNw);
		model.addAttribute("Other", other);
		model.addAttribute("userInformation", new UserInformation());

		return "engineer_search";
	}

	/**
	 * 検索処理が実行されたときに処理するメソッド
	 *
	 * @param model Modelクラス
	 * @return  エンジニア一覧画面表示処理へリダイレクトする。
	 */
	@PostMapping("engineer_search_execution")
	public String engineerSearchExecution(
			//基本情報検索パラム
			@ModelAttribute UserInformation userInformation,
			//スキル情報検索パラム
			@RequestParam(name = "item") String[] item,
			@RequestParam(name = "detail") String[] detail, @RequestParam(name = "ver") String[] ver,
			@RequestParam(name = "years") Integer[] years,
			//詳細情報検索パラム
			@RequestParam(name = "industry") String industry,
			@RequestParam(name = "position") String position,
			@RequestParam(name = "checkboxfaze") String[] chargePhase, Model model, HttpSession session) {

		// エンジニア検索をインスタンス化
		EngineerSearch es = new EngineerSearch();
		es.setUserInformation(userInformation);

		// Listの初期化と同時に文字列(配列)を追加
		// Arrays.asListメソッドを利用することで、配列をリスト（コレクション）に変換する手段
		List<String> list = new ArrayList<>(Arrays.asList(detail));

		//  lengthで配列の要素数を取得
		if (detail.length != 0) {
			//  listの要素を1つ削除
			list.remove("");
		}

		// 配列を生成と配列の長さを設定
		//[0][1][2][3][4][5]にそれぞれの値が入る。
		String[] detailname = new String[5];

		// 初期値設定
		int count = 0;

		// 1. detailに選択した値が入ってくる。
		// 2. detail配列をコレクションにまとめる。
		// 3. item で何を選択したのか判断
		// 4. list.get(0)で添字0の値をとる
		// 5. 必ず添字0を取って着たいので繰り上げるためにremove(0)
		// 6. そしてdetailnameに値を[0][1][2]にはめていく。

		// OS,FW/NW,DB,言語,その他が入力があるか判断
		for (String itemname : item) {
			// 上記の5つで空があるか判断
			if (!(itemname.equals(""))) {
				// 添字0(DB)の情報をcountにいれる
				detailname[count] = list.get(0);
				// 添字0を取り除く: 必ず添字の0を取ってきたいから。
				list.remove(0);
				// プラス1
				count++;
				// 処理をスキップ
				continue;
			}
			detailname[count] = "";
			count++;
		}

		es.setItem(item);
		// 選択された数の値をセット
		es.setDetail(detailname);
		es.setChargePhase(chargePhase);
		es.setIndustry(industry);
		es.setPosition(position);
		es.setVer(ver);
		// 経験年数を取得
		es.setYears(years);
		// セッションの有効期限
		session.setMaxInactiveInterval(1800);
		// 検索条件をセッションに保持
		session.setAttribute("engineer_search", es);

		return "forward:engineer_list";
	}

}

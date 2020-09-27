package starrily.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import starrily.bean.EngineerSearch;
import starrily.bean.SkillSheet;
import starrily.bean.UserInformation;
import starrily.service.StarrilyService;

/**
 * エンジニア一覧画面のコントローラー
 *
 * @author PDA s.lee
 *
 */
@Controller
public class EngineerListController {

	@Autowired
	private StarrilyService starrilyService;

	/**
	 * 検索ボタンを押下するときに処理するメソッド
	 *
	 * @return  エンジニア一覧画面へ遷移する。
	 */
	@PostMapping("engineer_list")
	public String engineerList(Model model, HttpSession session) {

		// セッションに検索した条件の保持
		EngineerSearch es = (EngineerSearch) session.getAttribute("engineer_search");
		// UserInformationクラスをインスタンス化
		UserInformation userInformation = es.getUserInformation();
		// 検索した条件をそれぞれに変数に代入
		String[] item = es.getItem();
		// engineerSaerchで何を選択したかをセットしてある。[0][1]...
		String[] detail = es.getDetail();
		String[] ver = es.getVer();
		Integer[] years = es.getYears();
		String industry = es.getIndustry();
		String position = es.getPosition();
		String[] chargePhase = es.getChargePhase();

		List<SkillSheet> skill = new ArrayList<SkillSheet>();
		List<Integer> userIdList = new ArrayList<>();
		int IdCount = 0;

		//スキル情報検索
		// item.lengthで全ての要素を取得(入力された文回る)
		for (int i = 0; i < item.length; i++) {

			SkillSheet skillSheet = new SkillSheet();

			// item[数字]OSだった場合
			if (item[i].equals("OS")) {
				// osをセットする。
				skillSheet.setOs(detail[i]);

				// バージョンが記入されているかの判断
				if (ver.length != 0 && ver[i] != null && !ver[i].equals("")) {
					// osバージョンをセット
					skillSheet.setOsVer(ver[i]);
				}
				// osの年数をセット
				skillSheet.setOsPeriod(years[i]);
				// DBの情報を取得
				List<SkillSheet> OS = starrilyService.searchProjectOS(skillSheet);
				// 取得したOSの情報をaddAllにセット
				skill.addAll(OS);
				// プラス1
				IdCount++;
				// スキップ
				continue;
			}

			// item[数字]DBだった場合
			if (item[i].equals("DB")) {
				// dbの情報をセット
				skillSheet.setDb(detail[i]);

				// バージョンが記入されているかの判断
				if (ver.length != 0 && ver[i] != null && !ver[i].equals("")) {
					// dbのバージョンをセット
					skillSheet.setDbVer(ver[i]);
				}
				// dbの経験連数をセット
				skillSheet.setDbPeriod(years[i]);
				//dbの情報を取得
				List<SkillSheet> DB = starrilyService.searchProjectDB(skillSheet);
				// 取得したDBの情報をaddAllにセット
				skill.addAll(DB);
				// プラス1
				IdCount++;
				// スキップ
				continue;
			}

			// item[数字]FW/NWだった場合
			if (item[i].equals("FWNW")) {
				// fwnwの情報をセット
				skillSheet.setFwNw(detail[i]);

				// fwfwバージョンが記入されているかの判断
				if (ver.length != 0 && ver[i] != null && !ver[i].equals("")) {
					// fwnwのバージョンをセット
					skillSheet.setFwNwVer(ver[i]);

				}
				// fwfwの経験連数をセット
				skillSheet.setFwNwPeriod(years[i]);
				// fwnwの情報を取得
				List<SkillSheet> FwNw = starrilyService.searchProjectFWNW(skillSheet);
				// // 取得したfwnwの情報をaddAllにセット
				skill.addAll(FwNw);
				IdCount++;
				continue;

			}

			if (item[i].equals("Language")) {
				skillSheet.setLanguage(detail[i]);

				if (ver.length != 0 && ver[i] != null && !ver[i].equals("")) {
					skillSheet.setLanguageVer(ver[i]);
				}

				skillSheet.setLanguagePeriod(years[i]);
				List<SkillSheet> Language = starrilyService.searchProjectLang(skillSheet);
				skill.addAll(Language);
				IdCount++;
				continue;

			}

			if (item[i].equals("Other")) {
				skillSheet.setOther(detail[i]);
				if (ver.length != 0 && ver[i] != null && !ver[i].equals("")) {
					skillSheet.setOtherVer(ver[i]);

				}
				skillSheet.setOtherPeriod(years[i]);
				List<SkillSheet> Other = starrilyService.searchProjectOther(skillSheet);
				skill.addAll(Other);
				IdCount++;
				continue;

			}

		}

		//詳細情報検索
		if (chargePhase.length != 0 || !industry.equals("") || !position.equals("")) {

			SkillSheet ss = new SkillSheet();

			// 業界が空でもなくnullでなかったら　
			if (!industry.equals("") && industry != null) {
				// 業界をセット
				ss.setIndustry(industry);
			}

			// ポジションが空でもなくnullでなかったら
			if (!position.equals("") && position != null) {
				// ポジションをセット
				ss.setPosition(position);
			}

			//担当フェーズが0でなかったら
			if (chargePhase.length == 0) {

				//ユーザーID,業界、ポジション、担当フェーズを取得
				List<SkillSheet> basicInfoList = starrilyService.searchProject(ss);
				//mapを初期化
				Map<Integer, Integer> user = new HashMap<>();

				//
				for (SkillSheet skillSheet : basicInfoList) {
					Integer i = user.get(skillSheet.getUserId());
					// ユーザーIDがnullでなかったら 1 : i+ 1か
					user.put(skillSheet.getUserId(), i == null ? 1 : i + 1);
				}

				//
				List<Integer> keyList = new ArrayList<>(user.keySet());

				for (Integer number : keyList) {
					SkillSheet sSheet = new SkillSheet();
					if (!industry.equals("") && industry != null) {
						sSheet.setIndustry(industry);
					}

					if (!position.equals("") && position != null) {
						sSheet.setPosition(position);
					}

					sSheet.setUserId(number);

					skill.add(sSheet);
				}

				IdCount++;

			} else {

				for (String str : chargePhase) {

					if (!str.equals("")) {

						ss.setChargePhase(str);

						List<SkillSheet> basicInfoList = starrilyService.searchProject(ss);

						Map<Integer, Integer> user = new HashMap<>();

						for (SkillSheet sSheet : basicInfoList) {
							Integer i = user.get(sSheet.getUserId());
							user.put(sSheet.getUserId(), i == null ? 1 : i + 1);
						}

						List<Integer> keyList = new ArrayList<>(user.keySet());

						for (Integer number : keyList) {
							SkillSheet sSheet = new SkillSheet();

							sSheet.setUserId(number);
							sSheet.setChargePhase(str);
							if (!industry.equals("") && industry != null) {
								sSheet.setIndustry(industry);
							}

							if (!position.equals("") && position != null) {
								sSheet.setPosition(position);
							}
							skill.add(sSheet);
						}

						IdCount++;
					}

				}

			}
		}

		//一致するIDを探す。
		Map<Integer, Integer> userId = new HashMap<>();

		for (SkillSheet skillSheet : skill) {
			Integer i = userId.get(skillSheet.getUserId());
			userId.put(skillSheet.getUserId(), i == null ? 1 : i + 1);
		}

		List<Integer> keyList = new ArrayList<>(userId.keySet());
		List<Integer> valueList = new ArrayList<>(userId.values());

		int count = 0;

		for (Integer number : valueList) {

			if (number != null && number == IdCount) {
				userIdList.add(keyList.get(count));
			}
			count++;
		}

		//userIDごとのSkillSheetを作成
		List<UserInformation> UI = new ArrayList<UserInformation>();
		for (Integer i : userIdList) {

			SkillSheet setSkill = new SkillSheet();

			for (SkillSheet ss : skill) {

				//IDがあった時セットする
				if (ss.getUserId() == i) {

					if (ss.getOs() != null) {
						setSkill.setOsAll(ss.getOs());
						if (ss.getOsVer() != null) {
							setSkill.setOsAll(setSkill.getOsAll() + ss.getOsVer());

						}
						if (ss.getOsPeriod() != 0) {
							int y = 0;
							int o = ss.getOsPeriod();
							for (o = ss.getOsPeriod(); o - 12 >= 0;) {
								o = o - 12;
								y++;
							}
							setSkill.setOsAll(setSkill.getOsAll() + " : " + y + "年" + o + "ヶ月");
						}

						continue;
					}

					if (ss.getDb() != null) {
						setSkill.setDbAll(ss.getDb());
						if (ss.getDbVer() != null) {
							setSkill.setDbAll(setSkill.getDbAll() + ss.getDbVer());

						}
						if (ss.getDbPeriod() != 0) {
							int y = 0;
							int o = ss.getDbPeriod();
							for (o = ss.getDbPeriod(); o - 12 >= 0;) {
								o = o - 12;
								y++;
							}
							setSkill.setDbAll(setSkill.getDbAll() + " : " + y + "年" + o + "ヶ月");
						}
						continue;
					}

					if (ss.getLanguage() != null) {
						setSkill.setLanguageAll(ss.getLanguage());
						if (ss.getLanguageVer() != null) {
							setSkill.setLanguageAll(setSkill.getLanguageAll() + ss.getLanguageVer());

						}
						if (ss.getLanguagePeriod() != 0) {
							int y = 0;
							int o = ss.getLanguagePeriod();
							for (o = ss.getLanguagePeriod(); o - 12 >= 0;) {
								o = o - 12;
								y++;
							}
							setSkill.setLanguageAll(setSkill.getLanguageAll() + " : " + y + "年" + o + "ヶ月");
						}
						continue;
					}

					if (ss.getFwNw() != null) {
						setSkill.setFwNwAll(ss.getFwNw());
						if (ss.getFwNwVer() != null) {
							setSkill.setFwNwAll(setSkill.getFwNwAll() + ss.getFwNwVer());

						}
						if (ss.getFwNwPeriod() != 0) {
							int y = 0;
							int o = ss.getFwNwPeriod();
							for (o = ss.getFwNwPeriod(); o - 12 >= 0;) {
								o = o - 12;
								y++;
							}
							setSkill.setFwNwAll(setSkill.getFwNwAll() + " : " + y + "年" + o + "ヶ月");
						}
						continue;
					}

					if (ss.getOther() != null) {
						setSkill.setOtherAll(ss.getOther());
						if (ss.getOtherVer() != null) {
							setSkill.setOtherAll(setSkill.getOtherAll() + ss.getOtherVer());

						}
						if (ss.getOtherPeriod() != 0) {
							int y = 0;
							int o = ss.getOtherPeriod();
							for (o = ss.getOtherPeriod(); o - 12 >= 0;) {
								o = o - 12;
								y++;
							}
							setSkill.setOtherAll(setSkill.getOtherAll() + " : " + y + "年" + o + "ヶ月");
						}
						continue;
					}

					if (ss.getPosition() != null) {
						setSkill.setPosition(ss.getPosition());
					}
					if (ss.getIndustry() != null) {
						setSkill.setIndustry(ss.getIndustry());
					}

					if (ss.getChargePhase() != null) {
						if (setSkill.getChargePhase() == null) {
							setSkill.setChargePhase(ss.getChargePhase());
						} else {
							setSkill.setChargePhase(setSkill.getChargePhase() + "," + ss.getChargePhase());
						}
					}

				}

			}

			setSkill.setUserId(i);
			if (setSkill.getOsAll() != null) {
				setSkill.setAllSkill("\n" + setSkill.getOsAll());
			} else {
				setSkill.setAllSkill("");
			}
			if (setSkill.getDbAll() != null) {
				setSkill.setAllSkill(setSkill.getAllSkill() + "\n" + setSkill.getDbAll());
			}
			if (setSkill.getLanguageAll() != null) {
				setSkill.setAllSkill(setSkill.getAllSkill() + "\n" + setSkill.getLanguageAll());
			}
			if (setSkill.getFwNwAll() != null) {
				setSkill.setAllSkill(setSkill.getAllSkill() + "\n" + setSkill.getFwNwAll());
			}
			if (setSkill.getOtherAll() != null) {
				setSkill.setAllSkill(setSkill.getAllSkill() + "\n" + setSkill.getOtherAll());
			}
			if (setSkill.getPosition() != null) {
				setSkill.setAllSkill(setSkill.getAllSkill() + "\n" + setSkill.getPosition());
			}
			if (setSkill.getIndustry() != null) {
				setSkill.setAllSkill(setSkill.getAllSkill() + "\n" + setSkill.getIndustry());
			}
			if (setSkill.getChargePhase() != null) {
				setSkill.setAllSkill(setSkill.getAllSkill() + "\n" + setSkill.getChargePhase());
			}

			UserInformation userInfo = new UserInformation();

			userInfo.setAllSkill(setSkill.getAllSkill());
			userInfo.setUserId(setSkill.getUserId());

			UI.add(userInfo);
		}

		if (IdCount == 0) {
			UI = starrilyService.searchAllUser();
		} else {
			int countUser = 0;
			for (UserInformation userInfo : UI) {
				String allSkill = userInfo.getAllSkill();
				userInfo = starrilyService.searchUserIndividual(userInfo.getUserId());
				if (userInfo == null) {
					UI.remove(countUser);
					if (UI.size() == 0) {
						break;
					}
					countUser++;
					continue;
				}
				userInfo.setAllSkill(allSkill);
				countUser++;
			}
		}
		model.addAttribute("userInfo", UI);
		model.addAttribute("count", UI.size());

		return "engineer_list";
	}
}

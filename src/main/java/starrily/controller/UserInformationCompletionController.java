package starrily.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import starrily.bean.UserInformation;
import starrily.service.LoginUserService;
import starrily.service.StarrilyService;

/**
*
* ユーザー情報変更完了画面のコントローラーです。
*
* @author s.kikuchi
*
*/
@Controller
public class UserInformationCompletionController {

	/** StarrilyServiceを自動的にDIする */
	@Autowired
	StarrilyService starrilyService;

	/** UserServiceを自動的にDIする */
	@Autowired
	LoginUserService userService;

	/**
	 * HttpServletRequestをインスタンス化.
	 */
	@Autowired
	HttpServletRequest request;

	/** MessageSourceを自動的にDIする */
	@Autowired
	MessageSource messageSource;

	/** HttpSessionを自動的にDIする */
	@Autowired
	HttpSession session;

	/**
	 * ユーザー情報変更確認画面にて確定ボタンが押下された際に更新処理をするメソッドです。
	 * @param user UserInformationクラス、formからの情報を代入
	 *
	 * @param model モデル属性のホルダーを定義
	 * @return ユーザー情報登録・変更完了画面を返します。
	 */
	@PostMapping("/user_information_completion")
	public String userInformationCompletion(@ModelAttribute UserInformation user, Model model) {
		int userRole = starrilyService.getUserRole(user.getUserId());
		model.addAttribute("showUserManagement", false);
		switch (userRole) {
		case 1:
		case 2:
		case 3:
			model.addAttribute("showUserManagement", true);
			break;
		}

		if (starrilyService.updateUserInformation(user) == 0 || starrilyService.updateUserRole(user) == 0) {
			MessageSourceResolvable PADCH001 = new DefaultMessageSourceResolvable("PADCH001");
			model.addAttribute("errMessage",
					messageSource.getMessage("EMSG203", new MessageSourceResolvable[] { PADCH001 }, Locale.JAPAN));
			session.getAttribute("searchConditions");
			UserInformation sessionUserInfo = (UserInformation) session.getAttribute("searchConditions");
			model.addAttribute("userInfo", new UserInformation());
			// 権限のプルダウン情報をユーザー管理画面に渡す
			model.addAttribute("roleDropdown", starrilyService.getDropdownInfo(7));
			// 権限を取得
			// ユーザー画面に送る（マージしたときに使う）
			// model.addAttribute("role", starrilyService.getUserRole(skillSheet.getUserId()));
			// 検索
			// 氏名、権限の入力の有無をチェック
			// どちらも未入力の処理
			if (sessionUserInfo.getUserName().isEmpty() && sessionUserInfo.getAuthority().equals("指定なし")) {
				// ユーザー情報取得.
				List<UserInformation> userInfo = userService.userInformationList();
				// 表示件数表示メソッド呼び出し
				numberDisplay(userInfo);
				// 変換メソッド呼び出し
				changeString(userInfo);
				// 取得した情報をユーザー管理画面に送る
				model.addAttribute("userInformation", userInfo);
				// それ以外
			} else {
				// 氏名の入力があれば実行
				if (!(sessionUserInfo.getUserName().isEmpty())) {
					// カタカナ変換メソッド呼び出し
					changePhonetic(sessionUserInfo);
					// 氏名を入力した情報を保持する
					request.setAttribute("retention", sessionUserInfo.getUserName());
				}
				// 権限の入力があれば実行
				if (!(sessionUserInfo.getAuthority().equals("指定なし"))) {
					// 権限の文字を数字に変換メソッド呼び出し
					changeInt(sessionUserInfo);
					// 選択した権限を保持する
					model.addAttribute("choice", sessionUserInfo.getAuthority());
				}
				// 検索結果を取得
				List<UserInformation> userInfo = userService.searchUserInfo(sessionUserInfo);
				// 変換メソッド呼び出し

				// 取得した情報をユーザー管理画面に送る
				model.addAttribute("userInformation", userInfo);
				// 表示件数表示メソッド呼び出し
				numberDisplay(userInfo);
			}

			return "/user_management_seach";
		}

		model.addAttribute("message",
				messageSource.getMessage("IMSG205", null, Locale.JAPAN));

		return "/user_processing_complete";
	}

	/**
	 * 権限の数字を文字に変換メソッド.
	 * @param list ユーザー情報
	 */
	void changeString(List<UserInformation> list) {
		// ユーザーIDを元に権限取得
		for (UserInformation userRole : list) {
			userRole.setAuthorityInt(starrilyService.getUserRole(userRole.getUserId()));
			// 権限の数字を文字に変換
			if (userRole.getAuthorityInt() == 1) {
				userRole.setAuthority("一般社員");
			} else if (userRole.getAuthorityInt() == 2) {
				userRole.setAuthority("現場リーダー");
			} else if (userRole.getAuthorityInt() == 3) {
				userRole.setAuthority("事業部リーダー");
			} else if (userRole.getAuthorityInt() == 4) {
				userRole.setAuthority("管理営業、社長");
			} else if (userRole.getAuthorityInt() == 5) {
				userRole.setAuthority("管理者");
			}
		}
	}

	/**
	 * 件数表示メソッド.
	 * @param list ユーザー情報
	 */
	void numberDisplay(List<UserInformation> list) {
		// 表示件数表示
		StringBuilder sb = new StringBuilder();
		sb.append("表示件数");
		sb.append(list.size());
		sb.append("件");
		request.setAttribute("result", sb.toString());
	}

	/**
	 * 権限の文字を数字に変換メソッド.
	 * @param userInformation 権限情報
	 */
	void changeInt(UserInformation userInformation) {
		if (userInformation.getAuthority().equals("一般社員")) {
			userInformation.setAuthorityInt(1);
		} else if (userInformation.getAuthority().equals("現場リーダー")) {
			userInformation.setAuthorityInt(2);
		} else if (userInformation.getAuthority().equals("事業部リーダー")) {
			userInformation.setAuthorityInt(3);
		} else if (userInformation.getAuthority().equals("管理営業、社長")) {
			userInformation.setAuthorityInt(4);
		} else if (userInformation.getAuthority().equals("管理者")) {
			userInformation.setAuthorityInt(5);
		}
	}
	/**
	 * ひらがなをカタカナに変換メソッド.
	 * @param userInformation 氏名の入力フォームで入力された値
	 */
	void changePhonetic(UserInformation userInformation) {
		// ひらがなをカタカナに変換
		StringBuffer sb = new StringBuffer(userInformation.getUserName());
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c >= 'ぁ' && c <= 'ん') {
				sb.setCharAt(i, (char) (c - 'ぁ' + 'ァ'));
			}
		}
		// カタカナにした名前をセット
		userInformation.setUserPhonetic(sb.toString());
	}

}

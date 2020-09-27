package starrily.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import starrily.bean.UserInformation;
import starrily.service.LoginUserService;
import starrily.service.StarrilyService;

/**
* ユーザー管理画面のコントローラーです。.
* @author s.kikuchi
*/
@Controller
public class UserManagementController {

	/**
	 * UserServiceをインスタンス化.
	 */
	@Autowired
	LoginUserService userService;

	/**
	 * StarrilyServiceをインスタン化.
	 */
	@Autowired
	StarrilyService starrilyService;

	/**
	 * HttpServletRequestをインスタンス化.
	 */
	@Autowired
	HttpServletRequest request;

	/**
	 * ValidationMessagesの情報を扱えるようになる
	 */
	@Autowired
	MessageSource messageSource;

	/**
	 * ValidationMessagesから情報を取得.
	 */
	MessageSourceResolvable PADCH001 = new DefaultMessageSourceResolvable("PADCH001");

	/**
	 * その他からユーザー管理画面へ遷移処理をするメソッドです.
	 * @param model html側で利用するデータ類をまとめて管理する
	 * @param userInformation UserInformationのbeanが使えるようになる
	 * @return ユーザー管理画面を返します。
	 */
	@PostMapping("/user_management")
	public String userManagementPost(Model model, UserInformation userInformation) {
		// ユーザー管理画面にUserInformationのインスタンスを渡す
		model.addAttribute("userInfo", new UserInformation());
		// 権限のプルダウン情報をユーザー管理画面に渡す
		model.addAttribute("roleDropdown", starrilyService.getDropdownInfo(7));
		// 権限を取得
		// 権限をユーザー画面に送る（仮後に消去）
		model.addAttribute("role", 4);
		// ユーザー画面に送る（マージしたときに使う）
		// model.addAttribute("role", starrilyService.getUserRole(skillSheet.getUserId()));
		// ユーザー管理画面
		return "user_management";
	}

	/**
	 * キーワード検索にて検索ボタンが押下された際にユーザー検索をするメソッドです.
	 * @param model html側で利用するデータ類をまとめて管理する
	 * @param userInformation UserInformationのbeanが使えるようになる
	 * @return ユーザー管理画面を返します。
	 */
	@PutMapping("/user_management")
	public String userManagementSerch(Model model, UserInformation userInformation) {
		// ユーザー管理画面にUserInformationのインスタンスを渡す
		model.addAttribute("userInfo", new UserInformation());
		// 権限のプルダウン情報をユーザー管理画面に渡す
		model.addAttribute("roleDropdown", starrilyService.getDropdownInfo(7));
		// 権限を取得
		// 権限をユーザー画面に送る（仮）
		model.addAttribute("role", 4);
		// ユーザー画面に送る（マージしたときに使う）
		// model.addAttribute("role", starrilyService.getUserRole(skillSheet.getUserId()));
		// 検索
		// 氏名、権限の入力の有無をチェック
		// どちらも未入力の処理
		if (userInformation.getUserName().isEmpty() && userInformation.getAuthority().equals("指定なし")) {
			// ユーザー情報取得
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
			if (!(userInformation.getUserName().isEmpty())) {
				// カタカナ変換メソッド呼び出し
				changePhonetic(userInformation);
				// 氏名を入力した情報を保持する
				request.setAttribute("retention", userInformation.getUserName());
			}
			// 権限の入力があれば実行
			if (!(userInformation.getAuthority().equals("指定なし"))) {
				// 権限の文字を数字に変換メソッド呼び出し
				changeInt(userInformation);

				// 選択した権限を保持する
				model.addAttribute("choice", userInformation.getAuthority());
			}
			// 検索結果を取得
			List<UserInformation> userInfo = userService.searchUserInfo(userInformation);
			// 変換メソッド呼び出し
			changeString(userInfo);
			// 取得した情報をユーザー管理画面に送る
			model.addAttribute("userInformation", userInfo);
			// 表示件数表示メソッド呼び出し
			numberDisplay(userInfo);
		}
		// ユーザー管理画面
		return "user_management_seach";
	}

	/**
	 * ユーザー管理画面からユーザーを削除したときに遷移するメソッド.
	 * @param model html側で利用するデータ類をまとめて管理する
	 * @param userInformation UserInformationのbeanが使えるようになる
	 * @param userName 削除したときに検索した氏名
	 * @param choiceAuthority 検索したときに選んだ権限
	 * @return ユーザー管理画面
	 */
	@GetMapping("/user_management")
	public String userManagementPut(Model model, UserInformation userInformation,
			@ModelAttribute("userName") String userName,
			@ModelAttribute("choiceAuthority") String choiceAuthority) {
		if (!(userName.isEmpty())) {
			// 氏名の入力フォームに入力した値をセット
			userInformation.setUserName(userName);
			// カタカナ変換メソッド呼び出し
			changePhonetic(userInformation);
			// 氏名を入力した情報を保持する
			request.setAttribute("retention", userInformation.getUserName());
		} else {
			// 空文字をセット
			userInformation.setUserName("");
		}
		if (!(choiceAuthority.isEmpty())) {
			// 権限セレクトボックスで選択した情報をセット
			userInformation.setAuthority(choiceAuthority);
			// 権限の文字を数字に変換メソッド呼び出し
			changeInt(userInformation);
			// 選択した権限を保持する
			model.addAttribute("choice", userInformation.getAuthority());
		} else {
			// 指定なしをセット
			userInformation.setAuthority("指定なし");
		}
		// 検索結果を取得
		List<UserInformation> userInfo = userService.searchUserInfo(userInformation);
		// 変換メソッド呼び出し
		changeString(userInfo);
		// 取得した情報をユーザー管理画面に送る
		model.addAttribute("userInformation", userInfo);
		// 表示件数表示メソッド呼び出し
		numberDisplay(userInfo);
		// ユーザー管理画面にUserInformationのインスタンスを渡す
		model.addAttribute("userInfo", new UserInformation());
		// 権限のプルダウン情報をユーザー管理画面に渡す
		model.addAttribute("roleDropdown", starrilyService.getDropdownInfo(7));
		// 権限を取得
		// 権限をユーザー画面に送る（仮）
		model.addAttribute("role", 4);
		// ユーザー画面に送る（マージしたときに使う）
		// model.addAttribute("role", starrilyService.getUserRole(skillSheet.getUserId()));
		// ユーザー管理画面
		return "user_management_seach";
	}

	/**
	 * 検索結果にあるユーザーを削除するメソッドです。.
	 * @param userInformation UserInformationのbeanが使えるようになる
	 * @param redirectAttributes リダイレクト先に情報を渡す
	 * @return ユーザー管理画面を返します。
	 */
	@DeleteMapping("/user_management")
	public String userManagementDelete(@Validated UserInformation userInformation, BindingResult result,
			RedirectAttributes redirectAttributes) {
		// ユーザー情報削除
		starrilyService.deleteUserInformation(userInformation);
		// リダイレクト先に氏名の検索フォームの入力値を渡す
		redirectAttributes.addFlashAttribute("userName", userInformation.getUserName());
		// リダイレクト先に権限のセレクトボックスの情報を渡す
		redirectAttributes.addFlashAttribute("choiceAuthority", userInformation.getAuthority());
		// リダイレクト先に削除メッセージを送る メッセージ：ユーザーを削除しました。
		redirectAttributes.addFlashAttribute("message",
				messageSource.getMessage("IMSG203", new MessageSourceResolvable[] { PADCH001 }, Locale.JAPAN));
		// ユーザー管理画面
		return "redirect:user_management";
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

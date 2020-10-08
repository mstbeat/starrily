package starrily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import starrily.bean.UserInformation;
import starrily.service.StarrilyService;
import starrily.validation.UserInfoGroup;

/**
 *
 * ユーザー情報変更画面のコントローラーです。
 *
 * @author s.kikuchi
 *
 */
@Controller
public class UserInformationConfirmationController {

	/** StarrilyServiceを自動的にDIする */
	@Autowired
	StarrilyService starrilyService;

	/**
	 * ユーザー情報変更画面にて確認ボタンが押下された際に遷移処理をするメソッドです。
	 * @param user UserInformationクラス、formからの情報を代入
	 * @param model モデル属性のホルダーを定義
	 * @return ユーザー情報変更確認画面を返します。
	 */
	@PostMapping("/user_information_confirmation")
	public String userInformationConfirmation(@ModelAttribute @Validated(UserInfoGroup.class) UserInformation user, BindingResult result,
			Model model) {
		int userRole = starrilyService.getUserRole(user.getUserId());
		model.addAttribute("showUserManagement", false);
		switch (userRole) {
		case 1:
		case 2:
		case 3:
			model.addAttribute("showUserManagement", true);
			break;
		}
		if (result.hasErrors()) {
			return "/user_information";
		}
		return "/user_information_confirmation";
	}

}
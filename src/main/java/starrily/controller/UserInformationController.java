package starrily.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import starrily.bean.UserInformation;
import starrily.service.StarrilyService;

/**
*
* ユーザー情報変更画面のコントローラーです。
*
* @author s.kikuchi
*
*/
@Controller
public class UserInformationController {

	/** StarrilyServiceを自動的にDIする */
	@Autowired
	StarrilyService starrilyService;

	/**
	 * ユーザー管理画面にてユーザー情報変更ボタンが押下された際に遷移処理をするメソッドです。
	 * @param userId ユーザー管理画面から渡されたユーザーID
	 * @param model モデル属性のホルダーを定義
	 * @return ユーザー情報変更画面を返します。
	 */
	@PostMapping("/user_information")
	public String userInformation(@RequestParam("userId") int userId, Model model) {
		UserInformation user = starrilyService.getUserInformation(userId);
		int userRole = starrilyService.getUserRole(userId);
		user.setAuthority(String.valueOf(userRole));
		model.addAttribute("showUserManagement", false);
		switch (userRole) {
		case 1:
		case 2:
		case 3:
			model.addAttribute("showUserManagement", true);
			break;
		}
		model.addAttribute("userInformation", user);
		return "/user_information";
	}
}
